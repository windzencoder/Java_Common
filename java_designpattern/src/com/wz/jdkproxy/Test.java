package com.wz.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import com.wz.delegate.Car;
import com.wz.delegate.Moveable;

public class Test {

	public static void main(String[] args) {
		Car car = new Car();
		InvocationHandler h = new TimeHandler(car);
		Class<?> cls = car.getClass();
		/*
		 * loader类加载器
		 * interfaces 实现接口
		 * h InvocationHandler
		 */
		Moveable m = (Moveable) Proxy.newProxyInstance(cls.getClassLoader(), 
				cls.getInterfaces(), 
				h);
		m.move();
	}
	
}
