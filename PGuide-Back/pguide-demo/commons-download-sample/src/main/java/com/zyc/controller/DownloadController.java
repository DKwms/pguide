package com.zyc.controller;

import com.zyc.download4j.core.aop.annotation.Download;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author StevenZhang
 * @date 2023/10/3
 * @description
 */
@RestController
@RequestMapping("/download")
public class DownloadController {

    @Download
    @GetMapping("/error")
    public Object error() {
        return new Object();
    }

    @GetMapping("/exception")
    public void exception() {
        throw new RuntimeException();
    }

}
