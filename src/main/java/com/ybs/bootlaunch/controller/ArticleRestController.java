package com.ybs.bootlaunch.controller;

import com.ybs.bootlaunch.model.AjaxResponse;
import com.ybs.bootlaunch.model.ArticleVO;
import com.ybs.bootlaunch.service.ArticleRestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

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

    @Resource(name = "articleMybatisRestService")
    ArticleRestService articleRestService;

    // 保存文章
    @PostMapping("/article")
    public AjaxResponse saveArticle(@RequestBody ArticleVO article) {
        log.info("saveArticle：{}",article);
        log.info("articleRestService return :" + articleRestService.saveArticle(article));
        return  AjaxResponse.success(article);
    }


    //删除一篇Article，使用DELETE方法，参数是id
    @DeleteMapping("/article/{id}")
    public AjaxResponse deleteArticle(@PathVariable Long id) {
        log.info("deleteArticle：{}",id);
        articleRestService.deleteArticle(id);
        return AjaxResponse.success(id);
    }

    //更新一篇Article，使用PUT方法，以id为主键进行更新
    @PutMapping("/article/{id}")
    public AjaxResponse updateArticle(@PathVariable Long id, @RequestBody ArticleVO article) {
        article.setId(id);
        log.info("updateArticle：{}",article);
        articleRestService.updateArticle(article);
        return AjaxResponse.success(article);
    }

    //获取一篇Article，使用GET方法
    @GetMapping( "/article/{id}")
    public AjaxResponse getArticle(@PathVariable Long id) {
        return AjaxResponse.success(articleRestService.getArticle(id));
    }

    @GetMapping( "/article")
    public @ResponseBody  AjaxResponse getAll() {
        return AjaxResponse.success(articleRestService.getAll());
    }
}