package com.bbs.demo;

import com.bbs.demo.dao.imp.CommentDaoImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

//@MapperScan(basePackages = "com.bbs.demo.dao")
@EnableCaching //缓存
@EnableScheduling //开启定时
@EnableMongoRepositories(basePackageClasses = CommentDaoImpl.class)
//@SpringBootApplication(exclude = MongoAutoConfiguration.class)
@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        System.out.println("项目启动成功");

    }
}
