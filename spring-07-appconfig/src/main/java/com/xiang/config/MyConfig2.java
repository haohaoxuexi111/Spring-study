package com.xiang.config;

import com.xiang.pojo.Book;
import com.xiang.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig2 {
    @Bean
    public User user1(){
        return new User("wang");
    }
}
