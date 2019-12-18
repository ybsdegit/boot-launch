package com.ybs.bootlaunch.controller;

import com.ybs.bootlaunch.dao.ArticleDao;
import com.ybs.bootlaunch.model.AjaxResponse;
import com.ybs.bootlaunch.model.Article;
import com.ybs.bootlaunch.service.ArticleRestService;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * ArticleRestController
 *
 * @author Paulson
 * @date 2019/12/9 23:50
 */
@Slf4j
@RestController
@RequestMapping("/rest")
public class ArticleRestController {
    @Resource
    ArticleRestService articleRestService;

    @Resource
    ArticleDao articleDao;

    @Autowired
    MongoTemplate mongoTemplate;


    //增加一篇Article ，使用POST方法
    @PostMapping("/article")
    public AjaxResponse saveArticle(@RequestBody Article article) {
        //因为使用了lombok的Slf4j注解，这里可以直接使用log变量打印日志
        log.info("saveArticle：{}",article);
        articleDao.save(article);
        return  AjaxResponse.success(article);
    }


    @DeleteMapping("/article/{id}")
    public AjaxResponse deleteArticle(@PathVariable String id) {
        log.info("deleteArticle：{}",id);
        articleDao.deleteById(id);
        return AjaxResponse.success(id);
    }

    //更新一篇Article，使用PUT方法，以id为主键进行更新
    @PutMapping("/article/{id}")
    public AjaxResponse updateArticle(@PathVariable String id, @RequestBody Article article) {
        log.info("updateArticle：{}",article);
        articleDao.save(article);
        return AjaxResponse.success(article);
    }

    //获取一篇Article，使用GET方法
    @GetMapping( "/article/{id}")
    public AjaxResponse getArticle(@PathVariable String id) {
        Optional<Article> article = articleDao.findById(id);
        return AjaxResponse.success(article);
    }

    @GetMapping( "/article")
    public @ResponseBody  AjaxResponse getAll() {
        List<Article> all = articleDao.findAll();
        System.out.print(all);
        return AjaxResponse.success(articleDao.findAll());
    }
}