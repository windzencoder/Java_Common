package com.imooc.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.imooc.entity.File;
import com.imooc.util.DBUtil;

public class FileService {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	//将文件保存在数据库中
	public boolean save(File file) {
		String sql = "insert into tb_file(fname, fcontent) values(?, ?)";
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, file.getFname());
			pstmt.setBytes(2, file.getFcontent());
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
