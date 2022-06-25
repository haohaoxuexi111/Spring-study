import com.xiang.pojo.User;
import com.xiang.pojo.UserT;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User) context.getBean("user别名");
        UserT user1 = (UserT) context.getBean("t1");
        User user2 = (User) context.getBean("user");
        user.show();
        user1.show();
        System.out.println(user == user2); //true，是同一对象，内存中只有一份实例，默认单例实现
    }
}
