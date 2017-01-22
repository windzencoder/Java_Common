package com.imooc.test;

import java.util.Date;
import java.util.List;

import com.imooc.action.GoddessAction;
import com.imooc.model.Goddess;

/*
 * 测试
 */
public class TestAction {
	public static void main(String[] args) throws Exception {
		
		GoddessAction action = new GoddessAction();
		//查询
		/*
		List<Goddess> result =  action.query();
		
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i).getId() + ":" + result.get(i).getUser_name());
		}
		*/
		
		//新增
		/*
		Goddess goddess = new Goddess();
		goddess.setUser_name("小青");
		goddess.setSex(1);
		goddess.setAge(25);
		goddess.setBirthday(new Date());
		goddess.setEmail("xiaoqing@111.com");
		goddess.setMobile("123456789");
		goddess.setIsdel(0);
		
		action.add(goddess);
		*/
		
		//删除
		action.del(19);
		
		
		
		
		
	}
}
