package test;

import com.google.gson.annotations.SerializedName;

public class ElementModel {

	@SerializedName("ItemEle")
	private String itemEle;
	
	@SerializedName("StartHour")
	private int startHour;
	
	@SerializedName("EndHour")
	private int endHour;
	
	@SerializedName("Interverls")
	private int interverls;
	
	public String getItemEle() {
		return itemEle;
	}
	public void setItemEle(String itemEle) {
		this.itemEle = itemEle;
	}
	public int getStartHour() {
		return startHour;
	}
	public void setStartHour(int startHour) {
		this.startHour = startHour;
	}
	public int getEndHour() {
		return endHour;
	}
	public void setEndHour(int endHour) {
		this.endHour = endHour;
	}
	public int getInterverls() {
		return interverls;
	}
	public void setInterverls(int interverls) {
		this.interverls = interverls;
	}
	
	
}
