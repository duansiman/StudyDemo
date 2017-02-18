package com.devin.java.aop.chapter10;

import com.devin.java.aop.entity.CounterImpl;
import com.devin.java.aop.entity.Foo;
import com.devin.java.aop.entity.ICounter;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

/**
 * Created by devin on 2017/2/7.
 */
@Aspect
public class AdviceAspect {

    @Before("execution(* *(*))")
    public void before(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        System.out.println(args);
    }

    @AfterThrowing(pointcut = "execution(void error())", throwing = "e")
    public void afterThrowing(Exception e){
        System.out.println("afterThrowing "+e.getMessage());
    }

    @AfterReturning(pointcut = "execution(String returnValue())", returning = "ret")
    public void returnValue(String ret){
        System.out.println(ret);
    }

    @DeclareParents(value = "com.devin.java.aop.entity.MockTask", defaultImpl = CounterImpl.class)/*introduction的advice*/
    public ICounter counter;

    public static void main(String[] args) {
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory();
        proxyFactory.setTarget(new Foo());
        proxyFactory.setProxyTargetClass(true);
        proxyFactory.addAspect(new AdviceAspect());
        Foo proxy = proxyFactory.getProxy();
//        try {
//            proxy.error();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        proxy.returnValue();
    }

}
