package com.wz.adapter;

public class TwoPlugAdapterExtends extends GBTwoPlug implements ThreePlugInterface {

	@Override
	public void powerWithThree() {
		this.powerWithTwo();
	}

}
