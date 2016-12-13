package gson;

import java.lang.reflect.Field;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import bean.DiaoSi;

public class GsonCreateSample {

	public static void main(String[] args) {
		
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
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();
		gsonBuilder.setFieldNamingStrategy(new FieldNamingStrategy() {
			
			public String translateName(Field f) {
				if (f.getName().equals("age")) {
					return "AGE";
				}
				return f.getName();
			}
		});
		Gson gson = gsonBuilder.create();
		System.out.println(gson.toJson(bean));
		
		
	}
	
	
	
}
