package org.pguide.auth.service.impl;

import com.alibaba.nacos.common.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.pguide.auth.controller.dto.SubSystemLoginDTO;
import org.pguide.auth.controller.vo.LoginBody;
import org.pguide.auth.controller.vo.SubSystemLoginBody;
import org.pguide.common.core.exceptions.auth.CaptchaErrorException;
import org.pguide.common.core.exceptions.auth.LoginInfoNotAllowException;
import org.pguide.auth.service.LoginService;
import org.pguide.auth.service.template.impl.SubSystemGetUserInfoVoTemplate;
import org.pguide.auth.service.template.impl.SubSystemLoginTemplateImpl;
import org.pguide.common.core.result.JsonResult;
import org.pguide.common.redis.constant.RedisConst;
import org.pguide.common.redis.service.RedisService;
import org.pguide.common.security.constant.JWTClaimsKeyConstants;
import org.pguide.common.security.constant.RedisLoginCacheConstants;
import org.pguide.common.security.utils.JWTUtil;
import org.pguide.user.entity.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author DKwms
 * @Date 2023/8/20 22:43
 * @description
 */

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Autowired
    RedisService redisService;

    @Autowired
    SubSystemLoginTemplateImpl subSystemLoginTemplate;

    @Autowired
    SubSystemGetUserInfoVoTemplate subSystemGetUserInfoVoTemplate;


    @Override
    public String dologin(LoginBody loginBody, HttpServletRequest request) {
        //tokenCheck(request,loginBody);

        preCheck(request);

        captchCheck(loginBody);

        passwordCheck(loginBody);

        String token = createToken(loginBody);
        // 检查通过返回token
        return token;
    }

    @Override
    public JsonResult<SubSystemLoginDTO> doSubSystemLogin(SubSystemLoginBody loginBody, HttpServletRequest request) {

        String token = dologin(loginBody,request);

        subSystempTokenCodeStore(loginBody.getTokenCode(),token);

        return JsonResult.success("login success!",new SubSystemLoginDTO(token,loginBody.getRedirectUrl()));
    }

    @Override
    public JsonResult<String> getTokenByCode(String tokenCode) {
        return JsonResult.success("subsystem login success!",(String)redisService.getObj(RedisConst.auth.PGUIDE_TOKEN_CODE+tokenCode));
    }

    @Override
    public String sendAuthCenterUrl(LoginBody loginBody, HttpServletRequest request) {
        if (loginBody.getRedirectUrl()==null){
            JsonResult.error("无重定向路径，无法进行鉴权返回");
        }
        return dologin(loginBody, request);
    }

    private void subSystempTokenCodeStore(String tokenCode,String token) {
        if (StringUtils.isEmpty(tokenCode)){
            throw new LoginInfoNotAllowException();
        }
        log.info("token储存成功!\ntoken:{}\n tokenCode:{}",token,tokenCode);
        //TODO 设置tokenCode 过期时长，暂时是1分钟
        redisService.setObj(RedisConst.auth.PGUIDE_TOKEN_CODE+tokenCode,token,1l, TimeUnit.MINUTES);
    }

    /**
     *创建tokeen，同时将token中的uuid与用户信息关联起来
     * @param loginBody 登录体用户信息
     * @return
     */
    private String createToken(LoginBody loginBody) {
        //createUUid send to user by jwt token
        String uuid = UUID.randomUUID().toString();
        HashMap<String, Object> chaim = new HashMap() {{
            this.put(JWTClaimsKeyConstants.UUID_KEY, uuid);
        }};
        String token = JWTUtil.createToken(chaim);

        // save token in redis
        UserInfoVo userInfoVo = subSystemGetUserInfoVoTemplate.match(loginBody.getSysType(),loginBody.getUserType(),loginBody);
        redisService.setObj(RedisConst.auth.TOKEN_USER_VO_KEY_REDIS+uuid,userInfoVo);

        return token;
    }

    private void captchCheck(LoginBody loginBody) {
        String answer = redisService.getString(RedisLoginCacheConstants.CAPTCHA_CODE_KEY + loginBody.getUuid());
        if (!answer.equals(loginBody.getCode())){
            //验证码匹配失败
            throw new CaptchaErrorException();
        }
    }

    private void passwordCheck(LoginBody loginBody) {
        // TODO <safe>进行密码单向加密等加密操作
        // TODO 异常处理细化
        subSystemLoginTemplate.doLoginAction(loginBody.getSysType(),loginBody.getUserType(),loginBody);
    }


    /**
     * 对网站的信息安全进行检测
     * @param request
     */
    private void preCheck(HttpServletRequest request) {

        //Map<String, String> collect = Collections.list(request.getHeaderNames())
        //        .stream()
        //        .collect(Collectors.toMap(h -> h, h -> request.getHeader(h)));
        //collect.entrySet().forEach(System.out::println);

        //TODO <safe>检测受信赖的host
        String hostPlace = request.getHeader("host");

    }


}
