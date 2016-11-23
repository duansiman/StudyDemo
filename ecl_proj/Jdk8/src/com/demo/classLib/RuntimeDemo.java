package com.demo.classLib;

public class RuntimeDemo {

	public static void main(String[] args) {
		/**
		 * 	代表java程序的运行时环境
		 * 
		 * 	提供load(filename) 方法加载文件
		 * 	提供loadLibrary(libname) 方法加载动态链接库
		 * 
		 * 	可以访问JVM的相关信息，处理器信息，内存信息
		 * 
		 */
		
		Runtime rt = Runtime.getRuntime();
		
		System.out.println("处理器数量：" + rt.availableProcessors());
		
		System.out.println(rt.freeMemory() + ":" + rt.maxMemory());
		
		System.out.println("空闲内存：" + (rt.freeMemory() / 1024 / 1024));
		
		System.out.println("可用最大内存" + (rt.maxMemory() / 1024 / 1024));
	}
	
}
