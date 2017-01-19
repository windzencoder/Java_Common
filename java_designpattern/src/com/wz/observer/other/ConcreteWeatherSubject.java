package com.wz.observer.other;

public class ConcreteWeatherSubject extends WeatherSubject {

	//用来存储天气情况
	//目标对象的状态
	private String weatherContent;
	
	@Override
	protected void notifyObservers() {
		//遍历所有注册的观察者
		for (Observer observer : observers) {
			if ("下雨".equals(this.getWeatherContent())) {
				if ("女朋友".equals(observer.getObserverName())) {
					observer.update(this);
				}
				if ("老妈".equals(observer.getObserverName())) {
					observer.update(this);
				}
			}
			if ("下雪".equals(this.getWeatherContent())) {
				if ("老妈".equals(observer.getObserverName())) {
					observer.update(this);
				}
			}
			
		}
	}

	public String getWeatherContent() {
		return weatherContent;
	}

	public void setWeatherContent(String weatherContent) {
		this.weatherContent = weatherContent;
		this.notifyObservers();
	}
	
	

}
