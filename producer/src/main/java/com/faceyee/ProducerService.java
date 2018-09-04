package com.faceyee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 97390 on 9/4/2018.
 */
@RestController
public class ProducerService {

    @GetMapping("/pengproducer")
    public String sayHello() {
        System.out.printf(" sayHello is called in " + this.hashCode());
        return "producerInstanceCode:" + this.hashCode();
    }


    @Autowired
    ArticleService articleService;

    @GetMapping("/articles")
    public List<Article> getAllArticles(){
        return articleService.getAllArticles();
    }

    @GetMapping("/article")
    public void publishArticle(@RequestBody Article article){
        articleService.insertArticle(article);
    }
}