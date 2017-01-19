package com.wz.observer.weahter;

/*
 * 具体的观察者对象，实现更新的方法
 */
public class ConcreteObserver implements Observer{

	private String observerName;
	//观察者的状态
	private String weatherContent;
	
	private String remindThing;
	
	
	
	public String getObserverName() {
		return observerName;
	}



	public void setObserverName(String observerName) {
		this.observerName = observerName;
	}



	public String getWeatherContent() {
		return weatherContent;
	}



	public void setWeatherContent(String weatherContent) {
		this.weatherContent = weatherContent;
	}



	public String getRemindThing() {
		return remindThing;
	}



	public void setRemindThing(String remindThing) {
		this.remindThing = remindThing;
	}



	@Override
	public void update(WeatherSubject subject) {
		//获取目标的状态，同步到观察者状态中
		weatherContent = ((ConcreteWeatherSubject)subject).getWeatherContent();
		
		System.out.println(observerName+"收到了"+weatherContent+","+remindThing);
		
	}
	
}
