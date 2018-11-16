package com.kh.semi.user.reviewer.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		
		String sql = prop.getProperty("selectReviewer");
		
		try {
			pstmt = con.prepareStatement(sql);
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

}
