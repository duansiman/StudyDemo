package com.demo.gc;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class RefDemo {

	public static void main(String[] args) {
		/**
		 * 	������������4�֣�
		 * 	1��ǿ����(StrongReference) ���ڿɴ�״̬
		 * 	2��������(SoftReference) ���ܱ��������ջ��ƻ��գ���ϵͳ�ռ䲻��ʱ���������ڴ����еĳ�����
		 * 	3��������(WeakReference) �������ú��񣬵����ü�����͡���������������ʱ������ϵͳ�ڴ��Ƿ��㹻��������ոö���ռ�õĿռ�
		 * 	4��������(PhantomPeference) ������û�����ã����ڸ��ٶ����������յ�״̬�����ܵ���ʹ�ã���������ö��У�ReferenceQueue������ʹ��
		 * 
		 * ReferenceQueue ���汻���պ���������
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
		//����ͨ�������ã���ȡ���ö���
		System.out.println(reference.get());
		
		System.gc();
		System.runFinalization();
		
		System.out.println(queue.poll() == reference);
	}
	
}
