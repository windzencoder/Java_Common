package json;


import java.util.HashMap;
import java.util.Map;

import org.json.*;

import bean.DiaoSi;

public class JsonObjectSample {

	public static void main(String[] args) {
		createJsonByBean();
	}
	
	public static void createJsonByBean() {
		
		DiaoSi bean = new DiaoSi();
		bean.setName("王小二");
		bean.setAge(25.2);
		bean.setBirthday("1990-01-01");
		bean.setSchool("蓝翔");
		bean.setMajor(new String[] {"理发", "挖掘机"});
		bean.setHas_girlfriend(false);
		bean.setHouse(null);
		bean.setCar(null);
		bean.setComment("这是一个注释");
		System.out.println(new JSONObject(bean));
		
	}
	
	private static void createJsonByMap(){
		Object nullObj = null;
		Map<String, Object> object = new HashMap<String, Object>();
		object.put("name", "王小二");
		object.put("age", 25.2);
		object.put("birthday", "1990-01-01");
		object.put("school", "蓝翔");
		object.put("major", new String[] {"理发", "挖掘机"});
		object.put("has_girlfriend", false);
		object.put("car", nullObj);
		object.put("house", nullObj);
		object.put("comment", "这是一个注释");
		
		System.out.println(new JSONObject(object));
		
	}
	
	
	private static void JSONObject() {
		
		JSONObject object = new JSONObject();
		Object nullObj = null;
		try {
			object.put("name", "王小二");
			object.put("age", 25.2);
			object.put("birthday", "1990-01-01");
			object.put("school", "蓝翔");
			object.put("major", new String[] {"理发", "挖掘机"});
			object.put("has_girlfriend", false);
			object.put("car", nullObj);
			object.put("house", nullObj);
			object.put("comment", "这是一个注释");
			
			System.out.println(object.toString());
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
	}
	
}
