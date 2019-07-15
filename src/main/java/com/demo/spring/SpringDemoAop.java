package com.demo.spring;

import com.demo.spring.api.DataBaseDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * spring aop使用
 * 实现原理
 * 1、解析配置文件xml中aop的标签
 * 2、创建代理
 * 3、执行切面功能
 *
 * @author haishen
 */
public class SpringDemoAop {

    public static void main(String[] args) {
        aopDemo1();
    }


    /**
     * 走注解化aop
     */
    private static void aopDemo1() {
        //初始化spring容器，使用xml文件，所以用ClasspathXmlApplicationContext
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-aop-1.xml");
        DataBaseDao demoDao = (DataBaseDao) context.getBean("accessOracleServiceImpl");
        System.out.println("demoDaoImpl:" + demoDao);
        demoDao.select();
        demoDao.delete();
    }

    /**
     * aop配置项 aop:pointcut和aop:aspect（切入点和切面）
     */
    private static void aopDemo2() {
        //初始化spring容器，使用xml文件，所以用ClasspathXmlApplicationContext
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-aop-2.xml");
        DataBaseDao demoDao = (DataBaseDao) context.getBean("accessMysqlServiceImpl");
        System.out.println("demoDaoImpl:" + demoDao);
        demoDao.select();
        demoDao.delete();
    }

    /**
     * aop配置项 aop:pointcut和aop:advisor（切入点和通知器）
     */
    private static void aopDemo3() {
        //初始化spring容器，使用xml文件，所以用ClasspathXmlApplicationContext
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");
        DataBaseDao demoDao = (DataBaseDao) context.getBean("accessMysqlServiceImpl");
        System.out.println("demoDaoImpl:" + demoDao);
        demoDao.select();
        demoDao.delete();
    }

}
