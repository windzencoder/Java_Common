package test;

import com.google.gson.annotations.SerializedName;

public class ForecastModeModel {

	@SerializedName("ForecastName")
	private String forecastName;
	
	@SerializedName("KeyMode")
	private String keyMode;
	
	@SerializedName("FilePath")
	private String filePath;
	
	
	public String getForecastName() {
		return forecastName;
	}
	public void setForecastName(String forecastName) {
		this.forecastName = forecastName;
	}
	public String getKeyMode() {
		return keyMode;
	}
	public void setKeyMode(String keyMode) {
		this.keyMode = keyMode;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	
	
}
