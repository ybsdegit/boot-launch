package com.ybs.bootlaunch.service;

import com.ybs.bootlaunch.dao.ArticleJDBCDAO;
import com.ybs.bootlaunch.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class ArticleRestJDBCService implements ArticleRestService{

    @Resource
    private
    ArticleJDBCDAO articleJDBCDAO;

    @Transactional
    public Article saveArticle(Article article) {
        articleJDBCDAO.save(article);
        //int a = 2/0；  //人为制造一个异常，用于测试事务
        return article;
    }

    public void deleteArticle(Long id){
        articleJDBCDAO.deleteById(id);
    }

    public void updateArticle(Article article){
        articleJDBCDAO.updateById(article);
    }

    public Article getArticle(Long id){
        return articleJDBCDAO.findById(id);
    }

    public List<Article> getAll(){
        return articleJDBCDAO.findAll();
    }
}