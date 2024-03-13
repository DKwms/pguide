package org.pguide.auth.service;

import org.pguide.common.core.result.JsonResult;

/**
 * @author DKwms
 * @Date 2023/8/20 22:43
 * @description
 */
public interface CaptchSerivce {

    public JsonResult doGetCaptch();

    public JsonResult doCheckCaptch(String uuid,String code);

}
