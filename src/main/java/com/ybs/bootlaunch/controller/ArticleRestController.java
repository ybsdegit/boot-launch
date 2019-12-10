package com.ybs.bootlaunch.controller;

import com.ybs.bootlaunch.model.AjaxResponse;
import com.ybs.bootlaunch.model.Article;
import com.ybs.bootlaunch.service.ArticleRestService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

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

    @Resource(name = "articleRestJDBCService")
    ArticleRestService articleRestService;

    //增加一篇Article ，使用POST方法
    // @RequestMapping(value = "/article", method = POST, produces = "application/json")
    @ApiOperation(value = "添加文章", notes = "添加新的文章", tags = "Article",httpMethod = "POST")
    @ApiResponses({
            @ApiResponse(code=200,message="成功",response=AjaxResponse.class),
    })
    @PostMapping("/article")
    public AjaxResponse saveArticle(@RequestBody Article article) {
        articleRestService.saveArticle(article);
        //因为使用了lombok的Slf4j注解，这里可以直接使用log变量打印日志
        return  AjaxResponse.success(article);
    }


    //删除一篇Article，使用DELETE方法，参数是id
    @RequestMapping(value = "/article/{id}", method = DELETE, produces = "application/json")
    public AjaxResponse deleteArticle(@PathVariable Long id) {
        articleRestService.deleteArticle(id);
        return AjaxResponse.success(id);
    }

    //更新一篇Article，使用PUT方法，以id为主键进行更新
    @RequestMapping(value = "/article/{id}", method = PUT, produces = "application/json")
    public AjaxResponse updateArticle(@PathVariable Long id, @RequestBody Article article) {
        article.setId(id);
        articleRestService.updateArticle(article);
        return AjaxResponse.success(article);
    }

    //获取一篇Article，使用GET方法
    @RequestMapping(value = "/article/{id}", method = GET, produces = "application/json")
    public AjaxResponse getArticle(@PathVariable Long id) {


        return AjaxResponse.success(articleRestService.getArticle(id));
    }

    @GetMapping("/article")
    public @ResponseBody AjaxResponse getAllArticle(){

        return AjaxResponse.success(articleRestService.getAll());
    }
}