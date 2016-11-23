package com.epdc.interview;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ListPng {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File root = new File("D:/AndroidStudy");	
		List<Future<ArrayList<File>>> futures = Collections.synchronizedList(new ArrayList<Future<ArrayList<File>>>());
		ExecutorService exec = Executors.newFixedThreadPool(5);
		futures.add(exec.submit(new ListThread(root, futures, exec)));
		ArrayList<File> files = new ArrayList<>();
		for (int i = 0; i < futures.size(); i++) {
			try {
				files.addAll(futures.get(i).get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		System.out.println("=================================");
		for (int i = 0; i < files.size(); i++) {
			System.out.println(files.get(i).getAbsolutePath());
		}
		exec.shutdown();
	}

}

class ListThread implements Callable<ArrayList<File>>{

	File root;
	List<Future<ArrayList<File>>> futures;
	ExecutorService exec;
	
	public ListThread(File root, List<Future<ArrayList<File>>> futures, ExecutorService exec) {
		super();
		this.root = root;
		this.futures = futures;
		this.exec = exec;
	}

	@Override
	public ArrayList<File> call() throws Exception {
		ArrayList<File> datas = new ArrayList<>();
		if (root.isDirectory()) {
			
			File[] files = root.listFiles(new FileFilter() {
				
				@Override
				public boolean accept(File pathname) {
					// TODO Auto-generated method stub
					return pathname.getName().endsWith(".png") || pathname.isDirectory();
				}
			});
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) {
					futures.add(exec.submit(new ListThread(files[i], futures, exec)));
				} else if(files[i].getName().endsWith(".png")) {
					datas.add(files[i]);
				}
			}
			
		} else if(root.getName().endsWith(".png")) {
			datas.add(root);
		}
		return datas;
	}
	
}
