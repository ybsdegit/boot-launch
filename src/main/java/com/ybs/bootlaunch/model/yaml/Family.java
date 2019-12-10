package com.ybs.bootlaunch.model.yaml;

import com.ybs.bootlaunch.config.MixPropertySourceFactory;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

/**
 * Family
 *
 * @author Paulson
 * @date 2019/12/10 23:57
 */

@Data
@Component
@Validated
@ConfigurationProperties(prefix = "family")
@PropertySource(value = {"classpath:family.yml"}, factory = MixPropertySourceFactory.class)
public class Family {

//    @Value("${family.family-name}")
//    @NotEmpty
    private String familyName;
    private Father father;
    private Mother mother;
    private Child child;
}
