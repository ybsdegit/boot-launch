package com.ybs.bootlaunch.service;

import com.ybs.bootlaunch.generator.testdb1.Article;
import com.ybs.bootlaunch.generator.testdb1.ArticleMapper;
import com.ybs.bootlaunch.generator.testdb2.Message;
import com.ybs.bootlaunch.generator.testdb2.MessageMapper;
import com.ybs.bootlaunch.model.ArticleVO;
import com.ybs.bootlaunch.utils.DozerUtils;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArticleMybatisRestService implements ArticleRestService {

    @Resource
    protected Mapper dozerMapper;

    @Resource
    private ArticleMapper articleMapper;

    @Resource
    private MessageMapper messageMapper;


    //新增
    @Override
    public ArticleVO saveArticle(ArticleVO article) {
        Article articlePO = dozerMapper.map(article,Article.class);
        articleMapper.insert(articlePO);

        Message message = new Message();
        message.setName("curry");
        message.setContent("厉害");
        messageMapper.insert(message);
        return null;
    }

    //删除
    @Override
    public void deleteArticle(Long id) {
        articleMapper.deleteByPrimaryKey(id);
    }

    //更新
    @Override
    public void updateArticle(ArticleVO article) {
        Article articlePO = dozerMapper.map(article,Article.class);
        articleMapper.updateByPrimaryKeySelective(articlePO);
    }

    //查询
    @Override
    public ArticleVO getArticle(Long id) {
        return dozerMapper.map(articleMapper.selectByPrimaryKey(id),ArticleVO.class);
    }
    //查询所有
    @Override
    public List<ArticleVO> getAll() {
        List<Article> articles = articleMapper.selectByExample(null);
        return DozerUtils.mapList(articles,ArticleVO.class);
    }
}