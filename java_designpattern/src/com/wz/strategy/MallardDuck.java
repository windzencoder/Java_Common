package com.wz.strategy;

import com.wz.strategy.impl.FlyWithWin;

public class MallardDuck extends Duck {

	public MallardDuck() {
		super();
		super.setFlyStragety(new FlyWithWin());
	}
	
	@Override
	public void display() {
		System.out.println("我的脖子是绿色的");
	}

}
