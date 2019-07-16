package com.demo.spring.aop;

/**
 * @author haishen
 * @date 2019/3/21
 */
public class AccessDbAspect {

    public void accessBefore() {
        System.out.println("访问DB前！");
    }

    public void accessAfter() {
        System.out.println("访问DB后！");
    }
}
