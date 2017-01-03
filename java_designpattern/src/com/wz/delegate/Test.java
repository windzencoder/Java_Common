package com.wz.delegate;

public class Test {

	public static void main(String[] args) {
//		Car car = new Car();
//		car.move();
		
//		Car2 car2 = new Car2();
//		car2.move();
		
//		Car car = new Car();
//		CarTimeProxy ctp = new CarTimeProxy(car);
//		CarLogProxy clp = new CarLogProxy(ctp);
//		clp.move();
		
		Car car = new Car();
		CarLogProxy clp = new CarLogProxy(car);
		CarTimeProxy ctp = new CarTimeProxy(clp);
		ctp.move();
		
	}
	
}
