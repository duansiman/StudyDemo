package com.demo.gc;

public class GcDemo {

	/**
	 *  ��������������
	 *  	1��ֻ���ն��ڴ��еĶ��󣬲�������κ�������Դ
	 *  	2�������޷���ȷ�����������յ����У����ں��ʵ�ʱ�����
	 *  	3�������κζ���֮ǰ���ȵ�������finalize����������ʹ�ö�����д����Ӷ������������ջ���ȡ������
	 *  
	 *  
	 *  ���ݶ������ñ���������״̬����Ϊ
	 *  	1���ɴ�״̬����һ���������ñ���������
	 *  	2���ɻָ�״̬���������κ����ñ���������������������finalize���������ܻ�������һ�����ñ���������
	 *  	3�����ɴ�״̬���������κ����ñ�������������ʹ��������finalize������Ҳû�С�
	 *  
	 *  ֪ͨϵͳ������������
	 *  	1��System���gc()��̬����
	 *  	2��Runtime�����gcʵ��������Runtime.getRuntime().gc();
	 *  
	 *  ǿ���������ջ��Ƶ��ÿ��Իָ������finalize����
	 *  	1��System��runFinalization()
	 *  	2��Runtime.getRuntime().runFinalization()
	 */
	
	public static void main(String[] args) {
		for (int i = 0; i < 4; i++) {
			new GcDemo();
			System.gc();
		}
	}
	
	/**
	 * 1����Ҫ�������ö���finalize�������������ջ��Ƶ���
	 * 2����ʱ�����ò�ȷ����finalize��һ����ִ��
	 * 3�������쳣ʱ�����ᱨ���쳣���������ִ��
	 */
	
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		System.out.println("finalize ϵͳ������������");
	}
	
}
