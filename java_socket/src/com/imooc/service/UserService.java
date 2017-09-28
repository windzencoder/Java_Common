package com.imooc.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.imooc.entity.User;
import com.imooc.util.DBUtil;

public class UserService {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs = null;
	
	//用户登录
	public boolean login(User user) {
		String sql = "select * from tb_user where username = ? and password = ?";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassoword());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(rs, pstmt, conn);
		}
		return false;
	}
	
	//用户注册
	public boolean register(User user) {
		String sql = "insert into tb_user(username, password) values(?, ?)";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassoword());
			int count = pstmt.executeUpdate();
			if (count > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(rs, pstmt, conn);
		}
		return false;
	}
	
	
}




















