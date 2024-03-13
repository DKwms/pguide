package com.zyc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author StevenZhang
 * @date 2023/8/15
 * @description
 */
@RestController
@RequestMapping("/web/infra")
public class TestController {

    @RequestMapping("/test")
    public String test_service() {
        return "Service Returns With Response Code [200]";
    }
}
