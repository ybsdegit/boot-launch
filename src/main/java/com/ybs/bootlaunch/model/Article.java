package com.ybs.bootlaunch.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Article
 *
 * @author Paulson
 * @date 2019/12/9 22:40
 */

@AllArgsConstructor  // 所有参数的构造函数
@NoArgsConstructor   // 无参构造函数
@Data
@Builder
public class Article {
    @JsonIgnore // 排除某个属性不做序列化与反序列化
    private Long id;
    private String author;
    private String title;
    private String content;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private java.util.Date createTime;
    private List<Reader> reader;
}
