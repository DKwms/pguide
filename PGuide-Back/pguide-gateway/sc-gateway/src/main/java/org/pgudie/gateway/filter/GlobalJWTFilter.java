package org.pgudie.gateway.filter;


import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.pguide.api.user.redis.UserInfoRedisServer;
import org.pguide.common.core.utils.PathUtil;
import org.pguide.common.security.constant.AuthConst;
import org.pguide.common.security.constant.AuthTokenConst;
import org.pguide.common.security.utils.TokenUtil;
import org.pguide.user.entity.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.RequestPath;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * @author DKwms
 * @Date 2023/8/23 20:49
 * @description 全局token过滤器
 */

@Component
@Slf4j
public class GlobalJWTFilter implements GlobalFilter, Ordered {

    @Autowired
    UserInfoRedisServer redisService;

    @Value("${pguide.gateway.authentication.url}")
    private String ignoreUrls = "/api/auth/login";


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        // 白名单
        RequestPath requestPath = exchange.getRequest().getPath();
        ArrayList<String> paths = Lists.newArrayList(Splitter.on(",").trimResults().split(ignoreUrls));
        String path = exchange.getRequest().getPath().value();
        for (String singlePath : paths) {
            if (PathUtil.checkAuthKeyValue(singlePath,path)) {
                // 白名单默认放置所有的权限
                log.info("path:{},白名单放行成功！",path);
                exchange.getRequest().mutate().header(AuthConst.AspectAuthKeyConst.SYS_USER_AUTH_KEY_IN_HEADER, "*:*");
                return chain.filter(exchange);
            }
        }

        // 普通用户，进行校验
        String token = exchange.getRequest().getHeaders().getFirst(AuthTokenConst.TOKEN_HEADER);

        if(token==null || StringUtils.isEmpty(token)){
            log.error("path:{},登录失败，非白名单请求，用户无token。",path);
            return unauthorized(exchange,"登录异常");
        }
        String uuid = TokenUtil.getUUIDInToken(token);
        UserInfoVo userInfo = redisService.getUserInfo(uuid);

        if (userInfo==null){
            log.error("path:{},登录失败，非白名单请求，用户无登录信息。token:{}",path,token);
            return unauthorized(exchange,"登录异常");
        }

        String userType = userInfo.getUserType();
            // 设置用户权限，后面会使用到,这里暂时没有系统的区别，设置为 *:userType
        exchange.getRequest().mutate().header(AuthConst.AspectAuthKeyConst.SYS_USER_AUTH_KEY_IN_HEADER, "*:"+userType);

        //TODO 添加密钥，防止请求恶意绕过网关打入微服务内部

        // 通过
        return chain.filter(exchange);
    }


    private Mono<Void> unauthorized(ServerWebExchange serverWebExchange, String str) {
        serverWebExchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        String s = "{\"status\":\"401\",\"errorMsg\":\"" + str + "\"}";
        byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
        DataBuffer buffer = serverWebExchange.getResponse()
                .bufferFactory().wrap(bytes);
        return serverWebExchange.getResponse().writeWith(Flux.just(buffer));
    }


    @Override
    public int getOrder() {
        return -1;
    }
}
