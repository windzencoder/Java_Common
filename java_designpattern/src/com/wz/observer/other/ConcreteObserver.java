package com.wz.observer.other;

public class ConcreteObserver implements Observer {

	//观察者名称
	private String observerName;
	//天气情况的内容
	private String weatherContent;
	
	//提醒的内容 
	private String remindOfThing;
	
	@Override
	public void update(WeatherSubject subject) {
		weatherContent = ((ConcreteWeatherSubject)subject).getWeatherContent();
		System.out.println(observerName+" 收到了 "+weatherContent);
	}

	@Override
	public void setObserverName(String observerName) {
		this.observerName = observerName;
	}

	@Override
	public String getObserverName() {
		return observerName;
	}

	public String getWeatherContent() {
		return weatherContent;
	}

	public void setWeatherContent(String weatherContent) {
		this.weatherContent = weatherContent;
	}

	public String getRemindOfThing() {
		return remindOfThing;
	}

	public void setRemindOfThing(String remindOfThing) {
		this.remindOfThing = remindOfThing;
	}
	
	

}
