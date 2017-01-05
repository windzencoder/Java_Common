package com.wz.factory;

public class Test {

	public static void main(String[] args) {
		
		HairFactory factory = new HairFactory();
//		HairInterface left = factory.getHair("left");
//		left.draw();
		
		HairInterface left = factory.getHairByClass("com.wz.factory.LeftHair");
		left.draw();
		
	}

}
