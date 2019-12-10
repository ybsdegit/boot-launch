package com.ybs.bootlaunch.yaml;

import com.ybs.bootlaunch.model.yaml.Family;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * CustomYamlTesl
 *
 * @author Paulson
 * @date 2019/12/11 0:03
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomYamlTesl {
    @Autowired
    Family family;

    @Test
    public void hello(){
        System.out.println(family.toString());
    }
}
