package com.ybs.bootlaunch.model.yaml;

import lombok.Data;

import java.util.List;

/**
 * Child
 *
 * @author Paulson
 * @date 2019/12/10 23:59
 */

@Data
public class Child {
    private String name;
    private Integer age;
    private List<Friend> friends;
}
