package itcast_anno.controller;

import itcast_anno.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountController {

    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext-anno.xml");
        AccountService accountService = app.getBean(AccountService.class);
        accountService.transfer("A","B",500);
    }

}
