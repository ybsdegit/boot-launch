package com.ybs.bootlaunch.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Configuration
public class JPADataSourceConfig {

    @Primary
    @Bean(name = "primaryDataSource")
    @Qualifier("primaryDataSource")
    @ConfigurationProperties(prefix="spring.datasource.primary")    //结合application.yml的配置
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }



    @Bean(name = "secondaryDataSource")
    @Qualifier("secondaryDataSource")
    @ConfigurationProperties(prefix="spring.datasource.secondary")   //结合application.yml的配置
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create().build();
    }
}