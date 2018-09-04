package com.faceyee.feignconsumer.controller;

import com.faceyee.feignconsumer.domain.Article;
import com.faceyee.feignconsumer.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 97390 on 9/4/2018.
 */
@RestController
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    @GetMapping("/outterArticles") // 想要允许外网访问,就得使用@RestController @RController配置url暴露
    List<Article> getAllArticles(){
        return consumerService.getAllArticles();
    };
}
