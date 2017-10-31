package com.wz.generic03;

import java.util.ArrayList;
import java.util.List;

public class WildcardsTest {

	public static void main(String[] args) {
		List<?> list = new ArrayList<Integer>();
		list = new ArrayList<Object>();
		list = new ArrayList<String>();
	}
	
	public static void test(List<?> list){
		
	}
	
}
