package com.imooc.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBUtil {

	private static final String URL = "jdbc:mysql://127.0.0.1:3306/imooc?useUnicode=true&characterEncoding=UTF-8";
	private static final String NAME = "root";
	private static final String PASSWORD = "";

	private static Connection connection = null;
	
	static{
		try {
			//1.加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			//2.获取数据库的连接
			connection = DriverManager.getConnection(URL, NAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//获取连接
	public static Connection getConection()
	{
		return connection;
	}
	
	public static void main(String[] args) throws Exception {

		//3.通过数据库的连接操作数据库，实现增删改查
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from imooc_goddess");
		while(resultSet.next()){
			System.out.println(resultSet.getString("user_name")+" "+resultSet.getInt("age"));
		}
	}
}
