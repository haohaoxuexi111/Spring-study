import com.xiang.pojo.Student;
import com.xiang.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Student stu = (Student) context.getBean("student");
        System.out.println(stu.toString());
    }

    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("userbeans.xml");
        User user = context.getBean("user2", User.class);//原型模型每次从容器中getBean的时候都会产生新的对象
        User user2 = context.getBean("user2", User.class);//单例模型每次从容器中getBean的时候得到的是同一对象
        System.out.println(user == user2);//scope="singteton" 得到true 所有实例共享一个对象
                                            //scope="prototype" 得到false

    }
}
