package com.wz.observer.java;

import java.util.Observable;
import java.util.Observer;

//具体的观察者对象
public class ConcreteObserver implements Observer {

	//观察者名称
	private String observerName;
	
	@Override
	public void update(Observable o, Object arg) {
		//第一种是推的方式
		System.out.println(observerName+" 收到了 " + arg);
		//第二种是拉的方式
		System.out.println(observerName+" 收到了 " + ((ConcreteWeatherSubject)o).getContent());
	}

	public String getObserverName() {
		return observerName;
	}

	public void setObserverName(String observerName) {
		this.observerName = observerName;
	}

	
	
}
