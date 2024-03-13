package com.zyc.controller;

import com.zyc.download4j.core.aop.annotation.CompressCache;
import com.zyc.download4j.core.aop.annotation.Download;
import com.zyc.download4j.core.aop.annotation.SourceCache;
import com.zyc.download4j.core.source.reflect.SourceModel;
import com.zyc.download4j.core.source.reflect.SourceName;
import com.zyc.download4j.core.source.reflect.SourceObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author StevenZhang
 * @date 2023/10/3
 * @description
 */
@RestController
@RequestMapping("/file")
public class FileDownloadController {

    //==================================================UserHome Download
    @Download(source = "user.home:/Public/README.txt")
    @GetMapping("/test1")
    public void test1() {
    }

    //==================================================ClassPath Download
    @Download(source = "classpath:/download/README.txt")
    @GetMapping("/test2")
    public void test2() {
    }

    @Download
    @GetMapping("/test3")
    public String test3() {
        return "classpath:/download/README.txt";
    }

    @Download
    @GetMapping("/test4")
    public ClassPathResource test4() {
        return new ClassPathResource("/download/README.txt");
    }

    //==================================================Plain Text Download
    @Download(filename = "demo.txt")
    @GetMapping("/test5")
    public String test5() {
        return "返回一个文本，如果有Download注解，将被当作文本文件处理";
    }

    //==================================================Http Download
    @Download(source = "https://gulimall-dkwms.oss-cn-chengdu.aliyuncs.com/5b5e74d0978360a1.jpg")
    @GetMapping("/test6")
    public void test6() {
    }

    @Download
    @GetMapping("/test7")
    public String test7() {
        return "https://gulimall-dkwms.oss-cn-chengdu.aliyuncs.com/5b5e74d0978360a1.jpg";
    }

    //==================================================Encoding Download
    @Download(source = "classpath:/download/README_GBK.txt",
            filename = "readme.zip",
            charset = "GBK",
            forceCompress = true)
    @GetMapping("/test8")
    public void test8() {
    }

    //==================================================Multi-Download
    @Download(source = {
            "classpath:/download/text.txt",
            "https://gulimall-dkwms.oss-cn-chengdu.aliyuncs.com/5b5e74d0978360a1.jpg"},
            filename = "压缩包Demo.zip")
    @GetMapping("/test9")
    public void test9() {
    }

    @Download(filename = "压缩包List-Demo.zip")
    @GetMapping("/test10")
    public List<Object> test10() {
        List<Object> list = new ArrayList<>();
        list.add(new ClassPathResource("/download/README.txt"));
        list.add(new ClassPathResource("/download/th.jpg"));
        list.add("https://gulimall-dkwms.oss-cn-chengdu.aliyuncs.com/5b5e74d0978360a1.jpg");
        return list;
    }

    //==================================================Image-Video-Download
    @Download(source = "classpath:/download/th.jpg", inline = true, contentType = "image/jpeg")
    @GetMapping("/test11")
    public void test11() {
    }

    @Download(source = "classpath:/download/83丨Before Advice Schema-based实现 - aopbefore.mp4", inline = true, contentType = "video/mp4")
    @GetMapping("/test12")
    public void test12() {
    }

    //逆天
    @Download(filename = "test13.zip")
    @SourceCache(group = "test13",delete = true)
    @CompressCache(group = "test13", name = "test13.zip",delete = true)
    @GetMapping("/test13")
    public List<BusinessModel> test13() {
        List<BusinessModel> businessModels = new ArrayList<>();
        businessModels.add(new BusinessModel("11.jpg", "https://gulimall-dkwms.oss-cn-chengdu.aliyuncs.com/5b5e74d0978360a1.jpg"));
        businessModels.add(new BusinessModel("22.jpg", "https://gulimall-dkwms.oss-cn-chengdu.aliyuncs.com/5b5e74d0978360a1.jpg"));
        businessModels.add(new BusinessModel("33.jpg", "https://gulimall-dkwms.oss-cn-chengdu.aliyuncs.com/5b5e74d0978360a1.jpg"));
        businessModels.add(new BusinessModel("classpath.txt", "classpath:/download/README.txt"));
        businessModels.add(new BusinessModel("83丨Before Advice Schema-based实现 - aopbefore.mp4", "classpath:/download/83丨Before Advice Schema-based实现 - aopbefore.mp4"));
        return businessModels;
    }

    @Data
    @SourceModel
    @AllArgsConstructor
    public static class BusinessModel {

        @SourceName
        private String name;

        @SourceObject
        private Object source;
    }

}
