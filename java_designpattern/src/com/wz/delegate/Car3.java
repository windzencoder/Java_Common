package com.wz.delegate;

public class Car3 implements Moveable {

	public Car3(Car car) {
		super();
		this.car = car;
	}
	
	private Car car;
	
	@Override
	public void move() {
		
		long startTime = System.currentTimeMillis();
		System.out.println("汽车开始行驶...");
		car.move();
		long endTime = System.currentTimeMillis();
		System.out.println("汽车结束行驶... ，汽车行驶时间："+(endTime - startTime));
		
	}

}
