package com.wz.factory;

/*
 * 发型工厂
 */
public class HairFactory {

	/**
	 * 根据类型来创建对象
	 * @param key
	 * @return
	 */
	public HairInterface getHair(String key) {
		if ("left".equals(key)) {
			return new LeftHair();
		}else if("right".equals(key)){
			return new RightHair();
		}
		return null;
	}
	
	/**
	 * 根据类的名称来创建对象
	 * @return
	 */
	public HairInterface getHairByClass(String className) {
		try {
			HairInterface hair = (HairInterface) Class.forName(className).newInstance();
			return hair;
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
