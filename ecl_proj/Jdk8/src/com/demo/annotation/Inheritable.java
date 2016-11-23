package com.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.lang.model.element.Element;

@Target(ElementType.TYPE)//类，接口，枚举
@Retention(RetentionPolicy.RUNTIME) //保留到运行时
@Inherited
public @interface Inheritable {

}
