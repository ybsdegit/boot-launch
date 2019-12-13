package com.ybs.bootlaunch.jpa.testdb1;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long> {
//    Article findByAuthor(String author);
}