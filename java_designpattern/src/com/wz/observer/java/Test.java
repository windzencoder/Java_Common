package com.wz.observer.java;

public class Test {

	public static void main(String[] args) {
		
		//创建天气目标
		ConcreteWeatherSubject subject = new ConcreteWeatherSubject();
		//创建观察者
		ConcreteObserver observer = new ConcreteObserver();
		observer.setObserverName("小米");
		
		//注册观察者
		subject.addObserver(observer);

		//目标更新
		subject.setContent("天气好.....");
		
	}
	
}
