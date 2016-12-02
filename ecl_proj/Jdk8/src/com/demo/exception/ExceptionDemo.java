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
		 *  java 7 ֧��һ��catch����������͵��쳣
		 *  	1����������� |�ֿ�
		 *  	2���쳣��������ʽ��final
		 *  
		 *  	�Զ��ر���Դ��try��䣬�����()��������ʼ����Դ����ô��������ʱ�Զ��ر���Դ
		 *  	����Դ�����ʵ��Closeable/AutoCloseable�ӿ�
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
		 * 	checked�쳣��Runtime�쳣��ǰ���Ǹ���Ҫ��ʾ����
		 *  
		 *  ��д�������׳��쳣�����Ǹ���ķ����쳣��������Ҳ��ܱȸ���ķ����쳣��
		 */
		
		/**
		 *  java 7 ����throw�׳��쳣��ʵ������
		 *  
		 *  java 1.4 �쳣��������Խ���һ��cause���󣬱�ʾԭʼ�쳣
		 */
		
		try {
			new FileOutputStream("");
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		
	}
	
}
