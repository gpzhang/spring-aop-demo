package com.demo.spring;

import com.demo.spring.api.DemoDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@ComponentScan
public class SpringDemoApplication {

    public static void main(String[] args) {
        aopDemo();
    }


    private static void aopDemo() {
        //初始化spring容器，使用xml文件，所以用ClasspathXmlApplicationContext
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");
        DemoDao demoDao = (DemoDao) context.getBean("demoDaoImpl");
        System.out.println("demoDaoImpl:" + demoDao);
        demoDao.select();
        demoDao.delete();
    }

}
