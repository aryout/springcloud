package com.faceyee.repo;


import com.faceyee.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by 97390 on 9/4/2018.
 */
@Repository
public interface ArticleRep extends JpaRepository<Article,Long> {
}