package com.imooc.dao;

import java.awt.Label;
import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.imooc.db.DBUtil;
import com.imooc.model.Goddess;

/*
 * 操作方法
 */
public class GoddessDao {

	public void addGoddess(Goddess goddess) throws Exception
	{
		Connection connection = DBUtil.getConection();
		String sql = "" +
						"insert into imooc_goddess" +
						"(user_name,sex,age,birthday,email,mobile," + 
						"create_user,create_date,update_user,update_date,isdel)" + 
						"values(" + 
						"?,?,?,?,?,?,?,current_date(),?,current_date(),?)";
		PreparedStatement ptmt = connection.prepareStatement(sql);
		
		ptmt.setString(1, goddess.getUser_name());
		ptmt.setInt(2, 1);
		ptmt.setInt(3, goddess.getAge());
		ptmt.setDate(4, new Date(goddess.getBirthday().getTime()) );
		ptmt.setString(5, goddess.getEmail());
		ptmt.setString(6, goddess.getMobile());
		ptmt.setString(7, "admin");
		ptmt.setString(8, "admin");
		ptmt.setInt(9, 0);
		
		ptmt.execute();
		
	}
	
	
	public void updateGoddess(Goddess goddess) throws SQLException
	{
		Connection connection = DBUtil.getConection();
		String sql = "" +
						" update imooc_goddess " +
						" set user_name=?,sex=?,age=?,birthday=?,email=?,mobile=?, " + 
						" update_user=?,update_date=current_date(),isdel=? " + 
						" where id=? ";
		PreparedStatement ptmt = connection.prepareStatement(sql);
		
		ptmt.setString(1, goddess.getUser_name());
		ptmt.setInt(2, goddess.getSex());
		ptmt.setInt(3, goddess.getAge());
		ptmt.setDate(4, new Date(goddess.getBirthday().getTime()) );
		ptmt.setString(5, goddess.getEmail());
		ptmt.setString(6, goddess.getMobile());
		ptmt.setString(7, goddess.getUpdate_user());
		ptmt.setInt(8, goddess.getIsdel());
		ptmt.setInt(9, goddess.getId());
		
		ptmt.execute();
		
	}
	
	public void delGoddess(Integer id) throws SQLException
	{
		Connection connection = DBUtil.getConection();
		String sql = "" +
						" delete from imooc_goddess  " + 
						" where id=? ";
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setInt(1, id);
		
		ptmt.execute();
	}
	
	//查询获取女神
	public List<Goddess> query() throws Exception
	{
		Connection connection = DBUtil.getConection();
		Statement statement = connection.createStatement();
		ResultSet rs = statement.executeQuery("select * from imooc_goddess");
		
		List<Goddess> gs = new ArrayList<Goddess>();
		Goddess goddess = null;
		while(rs.next()){
			goddess = new Goddess();
			goddess.setId(rs.getInt("id"));
			goddess.setUser_name(rs.getString("user_name"));
			goddess.setSex(rs.getInt("sex"));
			goddess.setAge(rs.getInt("age"));
			goddess.setBirthday(rs.getDate("birthday"));
			goddess.setEmail(rs.getString("email"));
			goddess.setMobile(rs.getString("mobile"));
			goddess.setCreate_date(rs.getDate("create_date"));
			goddess.setCreate_user(rs.getString("create_user"));
			goddess.setUpdate_date(rs.getDate("update_date"));
			goddess.setUpdate_user(rs.getString("update_user"));
			goddess.setIsdel(rs.getInt("isdel"));
			
			gs.add(goddess);
		}
		return gs;
	}
	
	//按姓名和手机号查询
	public List<Goddess> query(String name, String mobile, String email) throws Exception
	{
		Connection connection = DBUtil.getConection();
		
		StringBuilder sb = new StringBuilder();
		sb.append("select * from imooc_goddess ");
		sb.append(" where user_name like ? and mobile like ? and email like ?");
		
		PreparedStatement ptmt = connection.prepareStatement(sb.toString());
		ptmt.setString(1, "%"+name+"%");
		ptmt.setString(2, "%"+mobile+"%");
		ptmt.setString(3, "%"+email+"%");
		
		ResultSet rs = ptmt.executeQuery();
		
		List<Goddess> gs = new ArrayList<Goddess>();
		Goddess goddess = null;
		while(rs.next()){
			goddess = new Goddess();
			goddess.setId(rs.getInt("id"));
			goddess.setUser_name(rs.getString("user_name"));
			goddess.setSex(rs.getInt("sex"));
			goddess.setAge(rs.getInt("age"));
			goddess.setBirthday(rs.getDate("birthday"));
			goddess.setEmail(rs.getString("email"));
			goddess.setMobile(rs.getString("mobile"));
			goddess.setCreate_date(rs.getDate("create_date"));
			goddess.setCreate_user(rs.getString("create_user"));
			goddess.setUpdate_date(rs.getDate("update_date"));
			goddess.setUpdate_user(rs.getString("update_user"));
			goddess.setIsdel(rs.getInt("isdel"));
			
			gs.add(goddess);
		}
		return gs;
	}
	
	//通过集合传递参数
		public List<Goddess> query(List<Map<String, Object>> params) throws Exception
		{
			Connection connection = DBUtil.getConection();
			
			StringBuilder sb = new StringBuilder();
			sb.append("select * from imooc_goddess where 1=1 ");//小技巧
			
			if (params != null && params.size() > 0) {
				for (int i = 0; i < params.size(); i++) {
					Map<String, Object> map = params.get(i);
					sb.append(" and " + map.get("name") + " " + map.get("rela")+ " " +map.get("value")+" ");
				}
			}
			
			System.out.println("sb is ==="+sb.toString());
			PreparedStatement ptmt = connection.prepareStatement(sb.toString());
			
			
			ResultSet rs = ptmt.executeQuery();
			
			List<Goddess> gs = new ArrayList<Goddess>();
			Goddess goddess = null;
			while(rs.next()){
				goddess = new Goddess();
				goddess.setId(rs.getInt("id"));
				goddess.setUser_name(rs.getString("user_name"));
				goddess.setSex(rs.getInt("sex"));
				goddess.setAge(rs.getInt("age"));
				goddess.setBirthday(rs.getDate("birthday"));
				goddess.setEmail(rs.getString("email"));
				goddess.setMobile(rs.getString("mobile"));
				goddess.setCreate_date(rs.getDate("create_date"));
				goddess.setCreate_user(rs.getString("create_user"));
				goddess.setUpdate_date(rs.getDate("update_date"));
				goddess.setUpdate_user(rs.getString("update_user"));
				goddess.setIsdel(rs.getInt("isdel"));
				
				gs.add(goddess);
			}
			return gs;
		}
	
	//通过id获取
	public Goddess getGoddess(Integer id) throws SQLException
	{
		Connection connection = DBUtil.getConection();
		String sql = "" +
						" select * from imooc_goddess " +
						" where id=? ";
		PreparedStatement ptmt = connection.prepareStatement(sql);
		ptmt.setInt(1, id);
		
		Goddess goddess = null;
		ResultSet rs = ptmt.executeQuery();
		while(rs.next()){
			goddess = new Goddess();
			goddess.setId(id);
			goddess.setUser_name(rs.getString("user_name"));
			goddess.setSex(rs.getInt("sex"));
			goddess.setAge(rs.getInt("age"));
			goddess.setBirthday(rs.getDate("birthday"));
			goddess.setEmail(rs.getString("email"));
			goddess.setMobile(rs.getString("mobile"));
			goddess.setCreate_date(rs.getDate("create_date"));
			goddess.setCreate_user(rs.getString("create_user"));
			goddess.setUpdate_date(rs.getDate("update_date"));
			goddess.setUpdate_user(rs.getString("update_user"));
			goddess.setIsdel(rs.getInt("isdel"));
		}
		return goddess;
	}
	
}
