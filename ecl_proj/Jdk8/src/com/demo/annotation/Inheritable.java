package com.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.lang.model.element.Element;

@Target(ElementType.TYPE)//�࣬�ӿڣ�ö��
@Retention(RetentionPolicy.RUNTIME) //����������ʱ
@Inherited
public @interface Inheritable {

}
