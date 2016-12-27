package com.wz.singleton;

public class Test {

	public static void main(String[] args) {
		
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		
		if (s1 == s2) {
			System.out.println("same");
		}
		
		Singleton2 s3 = Singleton2.getInstance();
		Singleton2 s4 = Singleton2.getInstance();
		if (s3 == s4) {
			System.out.println("same");
		}
		
	}
	
}
