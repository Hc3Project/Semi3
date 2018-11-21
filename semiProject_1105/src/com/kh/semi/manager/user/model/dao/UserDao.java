package com.kh.semi.manager.user.model.dao;

import static com.kh.semi.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.semi.manager.user.model.vo.CategoryRating;
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
		} finally {
			close(rset);
			close(pstmt);
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
		} finally {
			close(pstmt);
		}
		return result;
	}

	public List<CategoryRating> selectAllRating(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		List<CategoryRating> result = null;
		String sql = prop.getProperty("selectAllRating");
		try {
			result = new ArrayList<CategoryRating>();
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			int tmpNum = 10;
			while(rset.next()) {
				CategoryRating cr = new CategoryRating();
				int[] ratingCnt = new int[tmpNum];
				cr.setName(rset.getString("gname"));
				for(int i=0; i<tmpNum; i++) {
					ratingCnt[i] = rset.getInt("s"+(i+1));
				}
				cr.setRatingCnt(ratingCnt);
				
				result.add(cr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
