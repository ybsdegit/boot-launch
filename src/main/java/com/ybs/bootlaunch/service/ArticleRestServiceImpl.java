package com.ybs.bootlaunch.service;

import com.ybs.bootlaunch.jpa.testdb1.Article;
import com.ybs.bootlaunch.jpa.testdb1.ArticleRepository;
import com.ybs.bootlaunch.jpa.testdb2.Message;
import com.ybs.bootlaunch.jpa.testdb2.MessageRepository;
import com.ybs.bootlaunch.model.ArticleVO;
import com.ybs.bootlaunch.utils.DozerUtils;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * ArticleRestServiceImpl
 *
 * @author Paulson
 * @date 2019/12/13 0:00
 */

@Service
public class ArticleRestServiceImpl implements ArticleRestService{
    //将JPA仓库对象注入
    @Resource
    private ArticleRepository articleRepository;

    @Resource
    private Mapper dozerMapper;

    @Resource
    MessageRepository messageRepository;

    @Transactional
    public ArticleVO saveArticle(ArticleVO article) {

        Article articlePO = dozerMapper.map(article, Article.class);
        articleRepository.save(articlePO);    //保存一个对象到数据库，insert
        Message message = new Message();
        message.setName("paulson");
        message.setContent("加油！");

        int a = 3/0;

        messageRepository.save(message);

        return  article;
    }

    @Override
    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);   //根据id删除1条数据库记录
    }

    @Override
    public void updateArticle(ArticleVO article) {
        Article articlePO = dozerMapper.map(article,Article.class);
        articleRepository.save(articlePO);   //更新一个对象到数据库，仍然使用save方法
    }

    @Override
    public ArticleVO getArticle(Long id) {
        Optional<Article> article = articleRepository.findById(id);  //根据id查找一条数据
        // 查读者
        ArticleVO articleVO = dozerMapper.map(article.get(), ArticleVO.class);
        // articleVO.setReader();
        return articleVO;
    }

    @Override
    public List<ArticleVO> getAll() {
        List<Article> articleLis = articleRepository.findAll();  //查询article表的所有数据
        return DozerUtils.mapList(articleLis,ArticleVO.class);
    }
}
