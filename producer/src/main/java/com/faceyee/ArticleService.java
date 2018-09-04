package com.faceyee;

import com.faceyee.repo.ArticleRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 97390 on 9/4/2018.
 */
@Service
public class ArticleService {

    @Autowired
    ArticleRep articleRep;

    public List<Article> getAllArticles(){
        return articleRep.findAll();
    }

    public void insertArticle(Article article){
        articleRep.save(article);
    }
}
