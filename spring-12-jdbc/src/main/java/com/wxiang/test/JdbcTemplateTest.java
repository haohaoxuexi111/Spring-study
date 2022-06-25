package com.wxiang.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;

public class JdbcTemplateTest {

    @Test  // 测试JdbcTemplate开发步骤
    public void test1() throws PropertyVetoException {
        // 创建数据源
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/jdbcstudy");
        dataSource.setUser("root");
        dataSource.setPassword("123456");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        int row = jdbcTemplate.update("insert into account values (?,?,?)", 8,"E", 2000);
        System.out.println(row);
    }

    @Test  // 测试Spring产生jdbcTemplate对象
    public void test2() {
        ApplicationContext app = new ClassPathXmlApplicationContext("application.xml");
        JdbcTemplate bean = app.getBean(JdbcTemplate.class);
        int row = bean.update("insert into account values (?,?,?)", 7, "G", 3500);
        System.out.println(row);
    }


}
