package org.pguide.common.core.utils;

import org.pguide.common.core.constant.HttpStatus;
import org.pguide.common.core.result.JsonResult;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * @author DKwms
 * @Date 2023/9/22 20:36
 * @description
 */
public class RedirectHelper {

    /**
     * 重定向
     * @param redirectUrl
     * @param response
     * @return
     */
    public static JsonResult doRedirect(String redirectUrl, HttpServletResponse response){
        response.setHeader("redirectUrl",redirectUrl);
        return JsonResult.success("Redirect Success!",redirectUrl).code(HttpStatus.RE_DIRECTED.value());
    }

    /**
     * 记录当前url的重定向
     * 用于重定向处理后返回回来
     * @param sendUrl 发起url
     * @param redirectUrl 重定向目标路径
     * @param response 重定向发起路径
     * @return
     */
    public static JsonResult doRedirectMemory(String sendUrl,String redirectUrl,HttpServletResponse response){
        response.setHeader("redirectUrl",redirectUrl);
        response.setHeader("sendUrl",sendUrl);
        HashMap<String, String> data = new HashMap(2){{
            this.put("redirectUrl",redirectUrl);
            this.put("sendUrl",sendUrl);
        }};
        return JsonResult.success("Redirect Success!",data).code(HttpStatus.RE_DIRECTED.value());
    }

}
