package com.baizhi.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by asus on 2018/8/5.
 */

//声明我的注解要使用的属性范围
@Target(ElementType.FIELD)
//声明注解在运行时生效
@Retention(RetentionPolicy.RUNTIME)
public @interface FiledName {

    String value();
}
