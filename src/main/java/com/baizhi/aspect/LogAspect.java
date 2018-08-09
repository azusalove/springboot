package com.baizhi.aspect;


import com.baizhi.entity.Admin;
import com.baizhi.entity.Log;
import com.baizhi.service.LogService;

import org.aspectj.lang.ProceedingJoinPoint;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;


/**
 * AOP面向切面编程
 * 记录管理员的操作的  无论操作成败都会被记录
 * Created by asus on 2018/8/3.
 */
@Configuration
@Aspect
public class LogAspect {


    @Autowired
    private LogService logService;

    //使用自定义的一个切入点
    @Pointcut(value = "@annotation(LogAnnotation)")
    public void pt() {
    }

    //使用自定义的一个切入点
    @Around("pt()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        //用这种方式可以取session
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpSession session = requestAttributes.getRequest().getSession();
        Admin admin = (Admin) session.getAttribute("isLogin");
        String username = null;
        if (admin != null) {
            username = admin.getName();
        }

        Log log = new Log();

        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = signature.getMethod();
        LogAnnotation annotation = method.getAnnotation(LogAnnotation.class);
        String name = annotation.name();

        //给属性赋值
        log.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        log.setUsername(username);
        log.setCreateDate(new Date(System.currentTimeMillis()));
        log.setRecord(name);

        Object proceed = null;
        boolean flag = false;
        try {
            proceed = proceedingJoinPoint.proceed();
            flag = true;
            log.setArg("操作成功");
            logService.addLog(log);
        } catch (Throwable throwable) {
            flag = false;
            log.setArg("操作失败");
            logService.addLog(log);
            throwable.printStackTrace();
        }
        return proceed;
    }



   /* //使用自定义的一个切入点
    @Around("pt()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {

        *//**
     * 首先我们要考虑里面的都是有哪些需要的操作
     *
     * 1.什么人
     * 2.什么时间
     * 3.做了什么事情
     * 4.执行操作的结果
     *//*
        //要先获取到session，获取到session后  然后在从session中取出什么用户登录的
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpSession session = requestAttributes.getRequest().getSession();
        session.getAttribute("admin");

        //2.什么时间   只需要创建一个当前时间
        Date date = new Date();


        //3.做了什么操作   我们要拿到登录的用户都是执行了哪些操作
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        //拿到用户操作的方法名
        Method method = signature.getMethod();
        //用过反射拿到注解的内容
        LogAnnotation annotation = method.getAnnotation(LogAnnotation.class);
        //拿到注解里面的值
        String name = annotation.name();

        Object proceed = null;
        boolean flag=false;
        try {
            proceed=proceedingJoinPoint.proceed();
            flag = true;

        } catch (Throwable throwable) {
            flag = false;
            throwable.printStackTrace();
        }
        return proceed;

    }*/
}
