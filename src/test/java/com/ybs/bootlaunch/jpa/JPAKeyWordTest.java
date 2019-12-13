package com.ybs.bootlaunch.jpa;

//import com.ybs.bootlaunch.dao.Article;
//import com.ybs.bootlaunch.dao.ArticleRepository;
import com.ybs.bootlaunch.jpa.testdb1.Article;
import com.ybs.bootlaunch.jpa.testdb1.ArticleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JPAKeyWordTest {

    @Resource
    private ArticleRepository articleRepository;
    
    @Test
    public void userTest() {
//        Article article = articleRepository.findByAuthor("paulson");
//        System.out.println(article);
    }

}