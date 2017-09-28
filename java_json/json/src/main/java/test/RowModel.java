package test;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class RowModel {

	@SerializedName("ForecastMode")
	private List<ForecastModeModel> forecastMode;
	
	@SerializedName("Elements")
	private List<ElementModel> elements;
	
	@SerializedName("StartHour")
	private int startHour;
	
	@SerializedName("EndHour")
	private int endHour;
	
	@SerializedName("IntervalHour")
	private int intervalHour;
	

	private boolean isZoreHour;
	

	private int timeout;
	
	public List<ForecastModeModel> getForecastMode() {
		return forecastMode;
	}
	public void setForecastMode(List<ForecastModeModel> forecastMode) {
		this.forecastMode = forecastMode;
	}
	public List<ElementModel> getElements() {
		return elements;
	}
	public void setElements(List<ElementModel> elements) {
		this.elements = elements;
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
	public int getIntervalHour() {
		return intervalHour;
	}
	public void setIntervalHour(int intervalHour) {
		this.intervalHour = intervalHour;
	}
	public boolean isZoreHour() {
		return isZoreHour;
	}
	public void setZoreHour(boolean isZoreHour) {
		this.isZoreHour = isZoreHour;
	}
	public int getTimeout() {
		return timeout;
	}
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}
	
	
	
}
