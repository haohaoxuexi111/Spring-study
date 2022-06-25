import com.xiang.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //动态代理，代理的是"接口"，而不是具体的类
        //配置文件中：<bean id="userService" class="com.xiang.service.UserServiceImpl"/>
        UserService userService = (UserService) context.getBean("userService");
        userService.select();
        userService.delete();
    }
}
