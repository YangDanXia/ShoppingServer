package com.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

//把普通pojo实例化到spring容器中，相当于配置文件中的<bean id="" class=""/>
@Component
public class CtxUtil{
    static ApplicationContext ctx;

    //    根据类型获得bean
    public static <T> T getBean(Class<T> var1){
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        return ctx.getBean(var1);
    }

    //    根据名称获得bean
    public static Object getBean(String name){
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        return ctx.getBean(name);
    }
}
