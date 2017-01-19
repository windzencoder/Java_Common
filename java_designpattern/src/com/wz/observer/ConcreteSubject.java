package com.wz.observer;

/*
 * 具体的目标对象，负责把有关状态存入
 * 到相应的观察者对象中
 */
public class ConcreteSubject extends Subject {
	
	//目标对象的状态
	private String subjectState;

	public String getSubjectState() {
		return subjectState;
	}

	public void setSubjectState(String subjectState) {
		this.subjectState = subjectState;
		//状态改变 通知观察者
		this.notifyObservers();
	}

}
