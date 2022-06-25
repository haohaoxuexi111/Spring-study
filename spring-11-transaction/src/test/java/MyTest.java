import com.xiang.mapper.UserMapper;
import com.xiang.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        UserMapper mapper = context.getBean("userMapper", UserMapper.class);
        for (User user : mapper.selectUser()) {
            System.out.println(user);
        }

    }
}
