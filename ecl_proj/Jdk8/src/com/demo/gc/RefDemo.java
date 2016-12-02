package com.demo.gc;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class RefDemo {

	public static void main(String[] args) {
		/**
		 * 	对象引用如下4种：
		 * 	1、强引用(StrongReference) 处于可达状态
		 * 	2、软引用(SoftReference) 可能被垃圾回收机制回收，当系统空间不足时，被用于内存敏感的程序中
		 * 	3、弱引用(WeakReference) 和软引用很像，但引用级别更低。当垃圾回收运行时，不管系统内存是否足够，都会回收该对象占用的空间
		 * 	4、虚引用(PhantomPeference) 类似于没有引用，用于跟踪对象被垃圾回收的状态，不能单独使用，必须和引用队列（ReferenceQueue）联合使用
		 * 
		 * ReferenceQueue 保存被回收后对象的引用
		 */
		
		String str = new String("java 8");
		
		WeakReference weakReference = new WeakReference(str);
		
		str = null;
		
		System.out.println(weakReference.get());
		
		System.gc();
		System.runFinalization();
		
		System.out.println(weakReference.get());
		
		String str2 = new String("java 8");
		
		ReferenceQueue queue = new ReferenceQueue<>();
		
		PhantomReference reference = new PhantomReference<>(str2, queue);
		
		str2 = null;
		//不能通过虚引用，获取引用对象
		System.out.println(reference.get());
		
		System.gc();
		System.runFinalization();
		
		System.out.println(queue.poll() == reference);
	}
	
}
