package com.wz.template;

/**
 * 抽象基类，为所有子类提供一个算法框架
 * 
 * 提神饮料
 */
public abstract class RefreshBeverage {

	public final void prepareBeverageTemplate() {
		//步骤1 将水煮沸
		boilWater();
		//步骤2 炮制饮料
		brew();
		//步骤3 将饮料倒入杯中
		pourInCup();
		if(isCustomerWantsCondiments()){
			//步骤4 加入调味料
			addCondiments();
		}
	}

	/*
	 * Hook，钩子函数，提供一个默认或空的实现
	 * 询问用户是否加入调料
	 */
	protected boolean isCustomerWantsCondiments() {
		return true;
	}

	//抽象的基本方法
	protected abstract void addCondiments();

	private void pourInCup() {
		System.out.println("将饮料倒入杯中...");
	}

	//抽象的基本方法
	protected abstract void brew();

	private void boilWater() {
		System.out.println("将水煮沸...");
	}
	
}
