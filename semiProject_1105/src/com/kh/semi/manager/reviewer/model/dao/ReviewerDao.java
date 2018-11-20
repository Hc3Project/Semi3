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

import static com.kh.semi.common.JDBCTemplate.*;

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
		
		try {
			result = new ArrayList<ReviewerInfo>();
			pstmt = con.prepareStatement(prop.getProperty("selectPart"));
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
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}

	public int updateReviewer(Connection con, ReviewerInfo ri) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = con.prepareStatement(prop.getProperty("updateReviewer"));
			pstmt.setString(1, ri.getrName());
			pstmt.setString(2, ri.getProfile());
			pstmt.setString(3, ri.getRvrCode());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int insertReviewer(Connection con, ReviewerInfo ri) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = con.prepareStatement(prop.getProperty("insertReviewer"));
			pstmt.setString(1, ri.getRvrCode());
			pstmt.setString(2, ri.getrName());
			pstmt.setString(3, ri.getProfile());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public List<ReviewerInfo> reviewerSelectPartCnt(Connection con, List<ReviewerInfo> list) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<ReviewerInfo> result = null;
		
		try {
			result = list;
			pstmt = con.prepareStatement(prop.getProperty("selectPartCnt"));
			
			for(ReviewerInfo rvInfo : result) {
				pstmt.setString(1, rvInfo.getRvrCode());
				
				rset = pstmt.executeQuery();
				
				if(rset.next()) rvInfo.setReviewCnt(rset.getInt(1));
				else rvInfo.setReviewCnt(0);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public int deleteReviewer(Connection con, String channelId) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = con.prepareStatement(prop.getProperty("deleteReviewer"));
			pstmt.setString(1, channelId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int selectReviewerOne(Connection con, String channelId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		try {
			pstmt = con.prepareStatement(prop.getProperty("duplicateReviewer"));
			pstmt.setString(1, channelId);
			rset = pstmt.executeQuery();
			if(rset.next()) result++;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
