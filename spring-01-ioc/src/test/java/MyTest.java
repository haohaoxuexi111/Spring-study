import com.xiang.dao.UserDaoImpl;
import com.xiang.dao.UserDaoMysqlImpl;
import com.xiang.service.UserService;
import com.xiang.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {

        //用户实际调用的是业务层，dao层他们不需要接触
//        UserService userService = new UserServiceImpl();
//        UserService userService = new UserServiceImpl();
//        ((UserServiceImpl)userService).setUserDao(new UserDaoMysqlImpl());
//        userService.getUser();

        //设置Spring容器后
        //获取ApplicationContext:拿到Spring的容器
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //拿到容器之后就可以使用容器中的所有对象了，需要什么，就直接get什么
        UserServiceImpl userServiceImpl = (UserServiceImpl) context.getBean("UserServiceImpl");
        userServiceImpl.getUser();
    }
}
