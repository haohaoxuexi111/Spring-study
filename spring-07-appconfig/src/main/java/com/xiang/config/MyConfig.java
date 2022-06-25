package com.xiang.config;

import com.xiang.pojo.EnrollCondition;
import com.xiang.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

//这个也会被Spring容器托管，注册到容器中，因为它本身就是一个@component
//@Configuration代表这是一个配置类，和我们之前看的beans.xml一样
@Configuration
@ComponentScan("com.xiang.pojo")
@Import(MyConfig2.class) //引入配置类
public class MyConfig {
    /*
    注册一个bean，就相当于我们之前写的一个bean标签<bean/>
    这个方法的名字，就相当于bean标签中的id属性
    这个方法的返回值，就相当于bean标签中的class属性
     */
    @Bean
    public User user2(){
        return new User("xiang"); //就是返回要注入到bean的对象
    }

    @Bean
    public User user3(){
        return new User("tai");
    }

    @Test
    public void test(){
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        // 返回容器中所有bean的名字
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

    }
}
