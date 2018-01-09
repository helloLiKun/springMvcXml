package test;

import com.mvc.cn.entity.Company;
import com.mvc.cn.entity.JDBC;
import com.mvc.cn.entity.User;
import com.mvc.cn.util.PropertiesReadAndWrite;
import jdk.nashorn.internal.scripts.JD;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;

/**
 * Created by liKun on 2018/1/3 0003.
 */
public class TestUser {
    AbstractApplicationContext ac;
    @Before
    public void initSpring(){
        String cfg="resource/applicationContext.xml";
        ac =new ClassPathXmlApplicationContext(cfg);
        System.out.println("----------reload----------");
    }

    @Test
    public void getCalendarTest(){
        Calendar calendar1=(Calendar) ac.getBean("calendar1");
        Calendar calendar2=ac.getBean("calendar2",Calendar.class);
        Date date1=ac.getBean("calendar3",Date.class);
        Date date2=ac.getBean("calendar3",Date.class);
        Date date3=ac.getBean("calendar4",Date.class);
        System.out.println("calendar3==c3:"+(calendar1==calendar2));
        System.out.println(date1==date2);
        System.out.println("c3==c4:"+(date2==date3));
    }

    @Test
    public void testConstructorAndSetter(){
        System.out.println("-----constructor-----");
        User user1=ac.getBean("user1",User.class);
        System.out.println("---user---"+user1);
        System.out.println("----setter-----------");
        User user2=ac.getBean("user2",User.class);
        System.out.println("---user---"+user2);
    }

    @Test
    public void testAutowired(){
        System.out.println("----------begin---------------");
        User user=ac.getBean("user_byType",User.class);
        User user1=ac.getBean("user_byType",User.class);
        System.out.println("--------:"+(user==user1));
    }

    @Test
    public void testRef(){
        Company company=ac.getBean("company",Company.class);
        System.out.println(company);
    }

    @Test
    public void testProperties(){
        PropertiesReadAndWrite propertiesReadAndWrite=(PropertiesReadAndWrite) ac.getBean("propertiesReadAndWrite");
        propertiesReadAndWrite.readProperties();
        propertiesReadAndWrite.writeProperties();
    }

    @Test
    public void jdbc(){
        JDBC jdbc=ac.getBean("jdbc", JDBC.class);
        System.out.println(jdbc);
    }

    @Test
    public void testMap(){
        Map<String,String> map=ac.getBean("testMap", Map.class);
        for(Map.Entry entry:map.entrySet()){
            System.out.println(entry.getKey()+"-----"+entry.getValue());
        }
    }
}