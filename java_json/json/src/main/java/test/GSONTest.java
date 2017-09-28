package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class GSONTest {

	public static void main(String[] args) {
		
		List<ForecastModeModel> fList = new ArrayList<ForecastModeModel>();
		
		ForecastModeModel fmodel1 = new ForecastModeModel();
		fmodel1.setForecastName("ecthin[nc](240)");
		fmodel1.setKeyMode("o_nc_xxxxxxx");
		fmodel1.setFilePath("E:Files\\xxxxxxxxxxxxxxxxxxxxxxx");
		fList.add(fmodel1);

		ForecastModeModel fmodel2 = new ForecastModeModel();
		fmodel2.setForecastName("ecthin[nc](240)");
		fmodel2.setKeyMode("o_nc_xxxxxxx");
		fmodel2.setFilePath("E:Files\\xxxxxxxxxxxxxxxxxxxxxxx");
		fList.add(fmodel2);
		
		List<ElementModel> eList = new ArrayList<ElementModel>();
		
		ElementModel e1 = new ElementModel();
		e1.setItemEle("10uv,rainc,tcc,xxxxxxxxxxx");
		e1.setStartHour(3);
		e1.setEndHour(72);
		e1.setInterverls(3);
		eList.add(e1);
		
		ElementModel e2 = new ElementModel();
		e2.setItemEle("10uv,rainc,tcc,xxxxxxxxxxx");
		e2.setStartHour(3);
		e2.setEndHour(72);
		e2.setInterverls(3);
		eList.add(e2);
		
		ElementModel e3 = new ElementModel();
		e3.setItemEle("10uv,rainc,tcc,xxxxxxxxxxx");
		e3.setStartHour(3);
		e3.setEndHour(72);
		e3.setInterverls(3);
		eList.add(e3);
		
		RowModel r1 = new RowModel();
		r1.setForecastMode(fList);
		r1.setElements(eList);
		r1.setStartHour(8);
		r1.setEndHour(20);
		r1.setIntervalHour(12);
		r1.setZoreHour(true);
		r1.setTimeout(3600);
		
		List<RowModel> rowList = new ArrayList<RowModel>();
		rowList.add(r1);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Rows", rowList);
		
		
		Gson gson = new Gson();
	    System.out.println(gson.toJson(map));
		
		
	}

}
