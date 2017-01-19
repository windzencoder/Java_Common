package com.wz.observer.other;

public class Test {

	public static void main(String[] args) {
		
		ConcreteWeatherSubject subject = new ConcreteWeatherSubject();
		
		ConcreteObserver observerGF = new ConcreteObserver();
		observerGF.setObserverName("女朋友");
		observerGF.setRemindOfThing("待在家里");
		
		subject.attach(observerGF);
		
		subject.setWeatherContent("晴天");
		subject.setWeatherContent("下雨");
		
	}
	
}
