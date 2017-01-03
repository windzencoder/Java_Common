package com.wz.delegate;

public class CarTimeProxy implements Moveable {

	public CarTimeProxy(Moveable m) {
		super();
		this.m = m;
	}
	
	private Moveable m;
	
	@Override
	public void move() {
		
		System.out.println("日志开始...");
		m.move();
		System.out.println("日志结束...");
		
	}
	


}
