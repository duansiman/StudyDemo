package com.devin.java.aop.chapter10;

import com.devin.java.aop.entity.Foo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

/**
 * Created by devin on 2017/2/7.
 */
@Aspect
public class PointcutAspect {

    /*Spring 是使用代理模式。所以目标对象和代理对象实现同一接口；使用CGLIB，代理对象继承于目标对象，所以有时this和target效果差不多*/

    @Pointcut("execution(* *(*)) && this(com.devin.java.aop.entity.Foo)") /*this指定目标对象的代理对象是Foo*/
    public void thisName(){}

    @Pointcut("execution(* *(*)) && target(com.devin.java.aop.entity.Foo)") /*target指定目标对象是Foo*/
    public void targetName(){}

    @Pointcut("args(String)")/*匹配方法参数类型和参数数量*/
    public void args(){}

    @Pointcut("within(com.devin.java.aop.entity.Foo)")/*匹配类型*/
    public void within(){}

    @Pointcut("@within(PointcutAnnotation)")/*匹配类型*/
    public void within2(){}

    @Pointcut("@target(PointcutAnnotation)")/*匹配类型*/
    public void target(){}

    @Pointcut("@args(PointcutAnnotation)")/*匹配参数拥有的类注解，而不是@PointcutAnnotation int arg这种形式*/
    public void args2(){}

    @Pointcut("bean(foo)")/*匹配ioc容器中beanName*/
    public void beanName(){}

    @Around("beanName()")
    public Object aspect(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("bean...");
        return joinPoint.proceed();
    }

    public static void main(String[] args) {
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory(new Foo());
        proxyFactory.setProxyTargetClass(true);
        proxyFactory.addAspect(new PointcutAspect());
        Foo foo = proxyFactory.getProxy();
        foo.method2();
    }

}
