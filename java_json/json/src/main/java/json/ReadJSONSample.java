package json;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadJSONSample {

	public static void main(String[] args) throws IOException, JSONException{
		
		File file = new File(ReadJSONSample.class.getResource("/wangxiaoer.json").getFile());
		String content = FileUtils.readFileToString(file);
		JSONObject jsonObject = new JSONObject(content);
		System.out.println("name : " + jsonObject.getString("name"));
		System.out.println("age : " + jsonObject.getDouble("age"));
		System.out.println("has_girlfriend : " + jsonObject.getBoolean("has_girlfriend"));
		System.out.println("major : " + jsonObject.getJSONArray("major"));
		
		JSONArray majorArray =  jsonObject.getJSONArray("major");
		for(int i=0; i < majorArray.length(); i++){
			String m = (String) majorArray.get(i);
			System.out.println("major-" + i + m);
		}
		
		if (!jsonObject.isNull("name")) {
			System.out.println("name : " + jsonObject.getString("name"));
		}
		
		
	}
	
	
	
}
