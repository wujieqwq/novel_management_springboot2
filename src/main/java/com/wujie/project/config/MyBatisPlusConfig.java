package com.wujie.project.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.wujie.project.mapper")
public class MyBatisPlusConfig {
}
