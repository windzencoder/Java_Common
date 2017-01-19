package com.wz.observer.java;

import java.util.Observable;

//天气目标的具体实现类
public class ConcreteWeatherSubject extends Observable {

	//天气情况的内容
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
		//通知所有的观察者
		//调用setChanged
		this.setChanged();
		//主动通知，推模型实现
		this.notifyObservers(content);
		//如果是拉方式，我们就调用下面的无参数的方法
		//this.notifyObservers();
	}
	
	
	
	
}
