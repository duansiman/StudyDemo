package com.demo.classLib;

public class CloneDemo {

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		
		CloneClass cloneClass = new CloneClass("����", 23, new Teacher("����"));
		
		CloneClass cloneClass2 = cloneClass.clone();
		
		System.out.println(cloneClass == cloneClass2);
		
		System.out.println(cloneClass.teacher == cloneClass2.teacher);
	}

}
