package com.kh.semi.user.reviewer.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.semi.manager.reviewer.model.vo.ReviewerInfo;

import static com.kh.semi.common.JDBCTemplate.*;


public class UReviewerDao {
	
	private Properties prop;
	
	public UReviewerDao(){
		prop = new Properties();
		String filePath = UReviewerDao.class.getResource("/config/reviewerDetail-query.properties").getPath().replace("%20", " ");
	
		try {
			prop.load(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public ReviewerInfo reviewerDetail(Connection con, String rvrCode) {
		ReviewerInfo result = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		try {
			pstmt = con.prepareStatement(prop.getProperty("selectReviewer"));
			pstmt.setString(1, rvrCode);
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				result = new ReviewerInfo();
				
				result.setRvrCode(rset.getString("rvrcode"));
				result.setrName(rset.getString("rname"));
				result.setProfile(rset.getString("profile"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public String selectReviewerStatus(Connection con, String userId) {
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		StringBuffer sb=new StringBuffer();
		try {
			pstmt=con.prepareStatement(prop.getProperty("selectReviewerStatus"));
			pstmt.setString(1, userId);
			rset=pstmt.executeQuery();
			while(rset.next()){
				sb.append(rset.getString(1)+", ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		String result=sb.toString();
		return result;
	}

	public int insertReviewerLikes(Connection con, String userId, String rvrCode) {
		
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=con.prepareStatement(prop.getProperty("insertReviewerLikes"));
			pstmt.setString(1, userId);
			pstmt.setString(2, rvrCode);
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		return result;
	}

	public int deleteReviewerLikes(Connection con, String userId, String rvrCode) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=con.prepareStatement(prop.getProperty("deleteReviewerLikes"));
			pstmt.setString(1, userId);
			pstmt.setString(2, rvrCode);
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		return result;
	}

}
