package com.kh.semi.manager.user.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.semi.manager.user.model.vo.UserInfo;

public class UserDao {
	
	private Properties prop;
	
	public UserDao() {
		prop = new Properties();
		String filePath = UserDao.class.getResource("/config/manager/user-query.properties").getPath();
		try {
			prop.load(new FileReader(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<UserInfo> selectPartUser(Connection con, String opt, String keyword, int stNum, int edNum) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<UserInfo> result = null;
		try {
			result = new ArrayList<UserInfo>();
			pstmt = con.prepareStatement(prop.getProperty("selectPartUser").replace("condition", opt));
			pstmt.setString(1, keyword);
			pstmt.setInt(2, stNum);
			pstmt.setInt(3, edNum);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				UserInfo ui = new UserInfo();
				ui.setUserId(rset.getString("userid"));
				ui.setEmail(rset.getString("email"));
				result.add(ui);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int deleteUser(Connection con, String userId) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = con.prepareStatement(prop.getProperty("deleteUser"));
			pstmt.setString(1, userId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
