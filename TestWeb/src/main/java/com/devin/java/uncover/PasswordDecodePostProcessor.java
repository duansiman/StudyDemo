package com.devin.java.uncover;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by devin on 2017/1/23.
 */
public class PasswordDecodePostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof PasswordDecodable) {
            ((PasswordDecodable) bean).setDecodedPassword(((PasswordDecodable) bean).getEncodedPassword()+"789");
        }
        return bean;
    }
}
