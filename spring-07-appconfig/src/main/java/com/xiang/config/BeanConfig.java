package com.xiang.config;

import com.xiang.exclude.NoScan;
import com.xiang.pojo.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

import java.util.Map;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_SINGLETON;

/**
 * springIOC配置容器类
 * 用于代替spring-beans.xml，生成bean对象
 */
@Configuration
@ComponentScan(basePackages = "com.xiang.pojo")
@ComponentScan(basePackages = {"com.xiang.exclude","com.xiang.pojo"},
excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {NoScan.class})})
public class BeanConfig {

    // 生成Person实例，bean的id默认是方法名
    @Bean(value = "personBean")
    public Person person(){
        String name = "张三";
        int age = 18;
        return new Person(name, age);
    }


    @Autowired  // 只有注册到ioc容器中的类才能进行注入
    Person person;

    /**
     * 使用单例模式生成Book实例
     * 此时，会在springIOC容器启动时创建bean实例，之后每次获取实例时，直接从容器中拿。
     */
    @Bean(value = "singletonBook")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Book singletonBook(){
        String name = "animals world";
        float price = 1000;
        return new Book(name, price);
    }

    /**
     * 使用多实例模式（原型模式）Prototype生成Book实例
     * 此时，启动springIOC容器并未创建bean实例，而是在每次获取bean实例时调用该方法重新创建
     */
    @Bean(value = "prototypeBook")
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Book prototypeBook(){
        String name = "alien world";
        float price = 2000;
        return new Book(name, price);
    }

    @Bean(value = "testNoScan")
    public NoScan noScan(){
        String n = "noScan";
        int num = 11;
        return new NoScan(n, num);
    }

    // @Autowired  //被excludeFilters排除了，没有注册到ioc容器中，getBean会报错 NoSuchBeanDefinitionException: No bean named 'noScan' available
    // private NoScan noScan;

    // 按条件注册bean类，若条件类EnrollCondition中的条件成立(返回true)，则生成名为success的TestEnrollCondition对象
    @Bean
    @Scope(value = SCOPE_SINGLETON)
    @Conditional({EnrollCondition.class})
    public TestEnrollCondition success(){
        return new TestEnrollCondition("条件成立，生成TestEnrollCondition对象");
    }


    @Test
    public void test(){

        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        Object person = context.getBean("personBean");
        System.out.println(person);

        // 虽然类上有@Component注解，但是未使用扫描注入，不过，可以通过在方法上加@Bean注解，返回NoScan类型的方式注入ioc容器中
        Object testNoScan = context.getBean("testNoScan");
        System.out.println(testNoScan);
        // 类上有@Component注解，可以被@ComponentScan扫描到，并注入ioc容器
        Object scan = context.getBean("scan");
        System.out.println(scan);
        // 按条件注册bean
        Object success = context.getBean("success");
        System.out.println(success);

        ApplicationContext context1 = new AnnotationConfigApplicationContext(MyConfig.class);
        // 根据类型，返回容器中所有bean的名字
        String[] beanNames = context1.getBeanNamesForType(User.class);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
        // 根据类型，返回容器中所有的bean对象
        Map<String, User> map = context1.getBeansOfType(User.class);
        System.out.println(map);

    }

}
