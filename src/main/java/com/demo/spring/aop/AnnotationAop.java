package com.demo.spring.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


/**
 * @author haishen
 * @date 2019/6/3
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
     * 目标方法执行完后调用
     */
    @AfterReturning("performance()")
    public void after() {
        System.out.println("delete after !!!!");
    }

    /**
     * 目标方法发生异常时调用
     */
    @AfterThrowing("performance()")
    public void exception() {
        System.out.println("delete exception!!!");
    }

}
