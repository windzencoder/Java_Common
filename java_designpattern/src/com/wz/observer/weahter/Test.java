package com.wz.observer.weahter;

public class Test {

	public static void main(String[] args) {
		ConcreteWeatherSubject weather = new ConcreteWeatherSubject();
		
		
		ConcreteObserver observerG = new ConcreteObserver();
		observerG.setObserverName("女朋友");
		observerG.setRemindThing("去购物");
		
		weather.attach(observerG);
		
		weather.setWeatherContent("天气晴朗");
		
	}
	
}
