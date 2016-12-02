package com.devin.java.aware;

import com.devin.java.beans.Command;
import com.devin.java.beans.Foo;
import com.devin.java.beans.User;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by devin on 2016/12/2.
 */
// DOUBT: 2016/12/2 你可以实现ApplicationContextAware接口来让bean A感知到容器， 并且在需要的时候通过使用使用getBean("B")向容器请求一个（新的）bean B实例
    //需要把B指定为非单例的
public class CommandManager implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public void createCommand() {
        System.out.println(this.applicationContext.getBean("command", Command.class));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}