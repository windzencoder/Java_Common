package com.wz.observer.weahter;

/*
 * 具体的目标对象，负责把有关状态存入
 * 到相应的观察者对象中
 */
public class ConcreteWeatherSubject extends WeatherSubject {
	
	//目标对象的状态
	private String weatherContent;

	public String getWeatherContent() {
		return weatherContent;
	}

	public void setWeatherContent(String weatherContent) {
		this.weatherContent = weatherContent;
		//通知所有订阅天气的人
		this.notifyObservers();
	}

}
