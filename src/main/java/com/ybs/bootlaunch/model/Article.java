package com.ybs.bootlaunch.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.List;

/**
 * Article
 *
 * @author Paulson
 * @date 2019/12/9 22:40
 */

@Document(collation = "article")
@AllArgsConstructor  // 所有参数的构造函数
@NoArgsConstructor   // 无参构造函数
@Data
@Builder
public class Article implements Serializable {
//    @Id
    private String id;

//    @Indexed
    private String author;

    private String title;

    @Field("msgContent")  // 别名
    private String content;

    @CreatedDate
    private java.util.Date createTime;
    private List<Reader> reader;
}
