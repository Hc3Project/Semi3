package com.kh.semi.manager.reviewer.model.dao;

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

public class ReviewerDao {
	
	private Properties prop;
	
	public ReviewerDao() {
		prop = new Properties();
		String filePath = ReviewerDao.class.getResource("/config/manager/rvr-query.properties").getPath();
		try {
			prop.load(new FileReader(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<ReviewerInfo> reviewerSelectPart(Connection con, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<ReviewerInfo> result = null;
		String sql = prop.getProperty("selectPart");
		
		try {
			result = new ArrayList<ReviewerInfo>();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, keyword);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ReviewerInfo ri = new ReviewerInfo();
				ri.setRvrCode(rset.getString("rvrcode"));
				ri.setrName(rset.getString("rname"));
				ri.setProfile(rset.getString("profile"));
				
				result.add(ri);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
