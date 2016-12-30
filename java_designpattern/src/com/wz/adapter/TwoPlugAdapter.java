package com.wz.adapter;

/**
 * 二相转三相的插座适配器
 * @author Miller
 *
 */
public class TwoPlugAdapter implements ThreePlugInterface {

	private GBTwoPlug plug;
	
	public TwoPlugAdapter(GBTwoPlug plug) {
		this.plug = plug;
	}
	
	@Override
	public void powerWithThree() {
		plug.powerWithTwo();
	}

}
