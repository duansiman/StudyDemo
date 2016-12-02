package com.demo.exception;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import javax.annotation.processing.Filer;
import javax.lang.model.element.Element;
import javax.tools.FileObject;
import javax.tools.JavaFileObject;
import javax.tools.JavaFileManager.Location;

public class ExceptionDemo {

	public static void main(String[] args) throws FileNotFoundException {
		/**
		 *  java 7 支持一个catch捕获多种类型的异常
		 *  	1、多个类型用 |分开
		 *  	2、异常变量有隐式的final
		 *  
		 *  	自动关闭资源的try语句，后面跟()声明，初始化资源，那么在语句结束时自动关闭资源
		 *  	但资源类必须实现Closeable/AutoCloseable接口
		 */
		
//		try (
//				BufferedReader br = new BufferedReader(new FileReader("test.txt"));
//				){
//			String line = null;
//			while ((line = br.readLine()) != null) {
//				System.out.println(line);
//			}
//		};
		
		/**
		 * 	checked异常，Runtime异常，前面那个需要显示处理
		 *  
		 *  重写方法，抛出异常必须是父类的方法异常子类或本身，且不能比父类的方法异常多
		 */
		
		/**
		 *  java 7 会检查throw抛出异常的实际类型
		 *  
		 *  java 1.4 异常构造类可以接收一个cause对象，表示原始异常
		 */
		
		try {
			new FileOutputStream("");
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		
	}
	
}
