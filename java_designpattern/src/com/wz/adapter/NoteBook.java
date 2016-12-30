package com.wz.adapter;

public class NoteBook {

	private ThreePlugInterface plug;
	
	public NoteBook(ThreePlugInterface plug) {
		this.plug = plug;
	}
	
	//使用插座充电
	public void charge() {
		plug.powerWithThree();
	}
	
	public static void main(String[] args) {
		GBTwoPlug twoPlug = new GBTwoPlug();
		ThreePlugInterface threePlug = new TwoPlugAdapter(twoPlug);
		NoteBook noteBook = new NoteBook(threePlug);
		noteBook.charge();
	}
	
}
