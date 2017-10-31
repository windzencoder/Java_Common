package com.wz.generic01;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;



public class Method {

	public static <T> void test(T t){
		System.out.println(t);
	}
	
	public static <T extends List> void test(T t){
		System.out.println(t);
		t.add("ttt");
	}
	
	public static <T extends Closeable> void test(T... t){
		for (T temp : t) {
			try {
				if (null != temp) {
					temp.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		test("Hello");
	}
	
}
