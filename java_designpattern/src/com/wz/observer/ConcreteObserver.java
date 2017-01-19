package com.wz.observer;

/*
 * 具体的观察者对象，实现更新的方法
 */
public class ConcreteObserver implements Observer{

	//观察者的状态
	private String observerState;
	
	@Override
	public void update(Subject subject) {
		//获取目标的状态，同步到观察者状态中
		observerState = ((ConcreteSubject)subject).getSubjectState();
	}
	
}
