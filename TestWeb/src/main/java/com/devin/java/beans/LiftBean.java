package com.devin.java.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.Lifecycle;

/**
 * Created by devin on 2016/12/5.
 */
public class LiftBean implements /*InitializingBean, DisposableBean,*/ Lifecycle/*, BeanPostProcessor */{

    /*析构函数*/
    public void destroy() throws Exception {
        System.out.println("destroy");
    }

    /*初始化函数*/
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    @Override
    public void start() {
        System.out.println("start");
    }

    @Override
    public void stop() {
        System.out.println("stop");
    }

    @Override
    public boolean isRunning() {
        System.out.println("isRuning");
        return false;
    }

    /*提供你自己的(或者重写容器默认的) 实例化逻辑，依赖分析逻辑*/
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println(o + ", " + s);
        return o;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println(o + ", " + s);
        return o;
    }
}
