package com.devin.java.aop;

import org.apache.catalina.User;
import org.springframework.aop.Advisor;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

/**
 * Created by devin on 2017/2/4.
 */
public class ProxyFactoryTest {

    public static void main(String[] args) {

        UserService userService = new UserService();

        ProxyFactory proxyFactory = new ProxyFactory(userService);

        MethodBeforeAdvice methodBeforeAdvice = new UserMethodBeforeAdvice();//advice,切入逻辑载体

        NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor(new ExceptionAdvice());//advisor,包括pointcut和advice模块
        advisor.setMappedName("login");//pointcut 切入点表述。根据方法名

        proxyFactory.addAdvisor(advisor);

        UserService proxy = (UserService) proxyFactory.getProxy();//获取目标对象的代理对象
        try {
            proxy.login("devin", "123456");
        } catch (Exception e) {

        }

    }

}
