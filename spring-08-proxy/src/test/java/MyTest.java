import com.xiang.demo02.UserServiceImpl;
import com.xiang.demo02.UserServiceProxy;
import org.junit.jupiter.api.Test;

public class MyTest {

    @Test
    public void testDemo02(){
        UserServiceProxy proxy = new UserServiceProxy();
        proxy.setUserService(new UserServiceImpl());
        proxy.add();
    }
}
