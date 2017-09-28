package com.imooc.action;

import java.util.List;
import java.util.Map;

import com.imooc.dao.GoddessDao;
import com.imooc.model.Goddess;

/*
 * 控制层
 */
public class GoddessAction {
	
	public void add(Goddess goddess) throws Exception
	{
		GoddessDao dao = new GoddessDao();
		
		dao.addGoddess(goddess);
	}
	
	public void edit(Goddess goddess) throws Exception
	{
		GoddessDao dao = new GoddessDao();
		
		dao.updateGoddess(goddess);
	}
	
	public Goddess get(Integer id) throws Exception
	{
		GoddessDao dao = new GoddessDao();
		return dao.getGoddess(id);
	}
	
	public void del(Integer id) throws Exception
	{
		GoddessDao dao = new GoddessDao();
		
		dao.delGoddess(id);
	}
	
	
	public List<Goddess> query() throws Exception
	{
		GoddessDao dao = new GoddessDao();
		return dao.query();
	}
	
	public List<Goddess> query(List<Map<String, Object>> params) throws Exception
	{
		GoddessDao dao = new GoddessDao();
		return dao.query(params);
	}
	

	
}









