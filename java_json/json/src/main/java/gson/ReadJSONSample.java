package gson;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import bean.DiaoSi;


public class ReadJSONSample {

	public static void main(String[] args) throws IOException {
		
		File file = new File(ReadJSONSample.class.getResource("/wangxiaoer.json").getFile());
		String content = FileUtils.readFileToString(file);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		DiaoSiWithBirthday bean = gson.fromJson(content, DiaoSiWithBirthday.class);
		System.out.println(bean);
		
		System.out.println(bean.getMajor());
		System.out.println(bean.getMajor().getClass());
	}
	
}
