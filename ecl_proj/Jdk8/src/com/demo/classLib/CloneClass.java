package com.demo.classLib;
/**
 * ʵ��Cloneable�ӿڣ���ʾ�ýӿڶ���������ҿ�¡
 * @author epdc
 *
 */
public class CloneClass implements Cloneable {

	public String name;
	public int age;
	public Teacher teacher;
	
	public CloneClass(String name, int age, Teacher teacher) {
		super();
		this.name = name;
		this.age = age;
		this.teacher = teacher;
	}



	@Override
	public CloneClass clone() throws CloneNotSupportedException {
		CloneClass cc = (CloneClass) super.clone();
		cc.teacher = teacher.clone();
		return cc;
	}
}

class Teacher implements Cloneable {
	public String source;
	
	public  Teacher(String s) {
		this.source = s;
	}
	
	@Override
	public Teacher clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (Teacher) super.clone();
	}
}
