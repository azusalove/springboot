package com.baizhi.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by asus on 2018/8/3.
 */
//这是声明使用的位置   以及范围
@Target(ElementType.METHOD)
//然后在声明注解的生效时机
@Retention(RetentionPolicy.RUNTIME)
public @interface LogAnnotation {
    //用方法的形式定义属性
    String name();
}
