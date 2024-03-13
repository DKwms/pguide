package org.pguide.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author DKwms
 * @Date 2024/1/20 15:58
 * @description
 */
@RequestMapping("/api/user")
public class UserInfoController {

    @RequestMapping("")
    public void getUserInfo(){
        // get it from redis
    }
}
