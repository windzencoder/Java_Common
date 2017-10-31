package com.wz.generic01;

public class MyStudent<T> {

	private T javase;
	
	//private static T a;//编译错误

	public T getJavase() {
		return javase;
	}

	public void setJavase(T javase) {
		this.javase = javase;
	}
	
}
