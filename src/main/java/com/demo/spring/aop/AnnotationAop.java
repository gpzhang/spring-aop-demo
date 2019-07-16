package com.demo.spring.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


/**
 *
 * 切入点
 * ------------------
 *      try{
 *          try{
 *          //@Before
 *          method.invoke(..);
 *          }finally{
 *          //@After  方法执行后@After注解的逻辑都会执行，不管是否异常
 *      }
 *          //@AfterReturning，方法出现异常@AfterReturning注解的逻辑不会执行
 *      }catch(Exception e){
 *           //@AfterThrowing
 *      }
 * ------------------
 * @author haishen
 * @date 2019/6/3
 * 基于注解的aop实现方式
 * 1、配置文件配置<aop:aspectj-autoproxy/>
 * 2、对应到AopNamespaceHandler解析配置文件xml中aop的标签（自定义标签时），
 * 注解aop对应的标签解析器为AspectJAutoProxyBeanDefinitionParser，该解析器主要向spring容器注册了代理创建器AnnotationAwareAspectJAutoProxyCreator
 * <p>
 * 此次标签解析部分的工作完成，后续就是aop在spring容器创建bean的时候发挥作用了，
 * 一般来说aop发挥作用在什么时候合适呢，肯定是在bean以及完成实例化、并且也完成初始化之后对bean进行增强最好
 * 3、因为代理创建器AnnotationAwareAspectJAutoProxyCreator实现了BeanPostProcessor接口，并在方法postProcessAfterInitialization内实现了处理逻辑。
 * 所以当前spring容器创建bean的时候，在bean完成初始化总之后，会执行方法postProcessAfterInitialization内的逻辑
 * 4、postProcessAfterInitialization内的逻辑内部过滤出匹配当前bean的增强器（Advisor：每一个advisor持有一个advice实现类和pointcut实现类）
 * 5、然后通过动态代理创建代理对象
 */
@Component
@Aspect
public class AnnotationAop {

    /**
     * 定义一个公共的切点
     */
    @Pointcut("execution(* com.demo.spring.impl.AccessOracleServiceImpl.delete())")
    public void performance() {
    }

    /**
     * 目标方法执行之前调用
     */
    @Before("performance()")
    public void before() {
        System.out.println("delete before!!!");
    }

    /**
     * 目标方法调用执行后
     */
    @After("performance()")
    public void after() {
        System.out.println("delete after !!!!");
    }

    /**
     * 目标方法执行完后、返回结果时调用
     */
    @AfterReturning("performance()")
    public void afterReturn() {
        System.out.println("delete after return !!!!");
    }

    /**
     * 目标方法发生异常时调用
     */
    @AfterThrowing("performance()")
    public void exception() {
        System.out.println("delete exception!!!");
    }


}
