package com.lkw.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 使用配置类的形式代替配置文件的方式进行bean的管理
 */
@Configuration
@ComponentScan({"com.lkw.spring.dao","com.lkw.spring.service"})
public class SpringConfig {

}
