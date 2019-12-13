package com.ybs.bootlaunch.controller;

import com.ybs.bootlaunch.model.ArticleVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController
 *
 * @author Paulson
 * @date 2019/12/9 22:41
 */
@Slf4j
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public ArticleVO hello(){
        ArticleVO article = new ArticleVO();
        ArticleVO article1 = article.builder().id(3L).author("paulson").build();
        log.info("测试一下" + article1);
        return article1;
    }
}
