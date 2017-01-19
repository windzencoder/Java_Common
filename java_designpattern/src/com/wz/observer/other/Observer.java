package com.wz.observer.other;

//观察者接口
public interface Observer {
	
	//更新的接口
	public void update(WeatherSubject subject);
	
	//设置观察者名称
	public void setObserverName(String observerName);
	
	//取得观察者名称
	public String getObserverName();
	
}
