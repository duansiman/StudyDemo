package com.demo.gc;

public class GcDemo {

	/**
	 *  垃圾回收特征：
	 *  	1、只回收堆内存中的对象，不会回收任何物理资源
	 *  	2、程序无法精确控制垃圾回收的运行，会在合适的时候进行
	 *  	3、回收任何对象之前，先调用它的finalize方法，可能使该对象重写复活，从而导致垃圾回收机制取消回收
	 *  
	 *  
	 *  根据对象被引用变量所引用状态，分为
	 *  	1、可达状态，有一个以上引用变量引用它
	 *  	2、可恢复状态，不再有任何引用变量引用它，但调用它的finalize方法，可能会重新让一个引用变量引用它
	 *  	3、不可达状态，不再有任何引用变量引用它，即使调用它的finalize方法，也没有。
	 *  
	 *  通知系统进行垃圾回收
	 *  	1、System类的gc()静态方法
	 *  	2、Runtime对象的gc实例方法，Runtime.getRuntime().gc();
	 *  
	 *  强制垃圾回收机制调用可以恢复对象的finalize方法
	 *  	1、System的runFinalization()
	 *  	2、Runtime.getRuntime().runFinalization()
	 */
	
	public static void main(String[] args) {
		for (int i = 0; i < 4; i++) {
			new GcDemo();
			System.gc();
		}
	}
	
	/**
	 * 1、不要主动调用对象finalize，交给垃圾回收机制调用
	 * 2、何时被调用不确定，finalize不一定会执行
	 * 3、出现异常时，不会报告异常，程序继续执行
	 */
	
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		System.out.println("finalize 系统正在清理。。。");
	}
	
}
