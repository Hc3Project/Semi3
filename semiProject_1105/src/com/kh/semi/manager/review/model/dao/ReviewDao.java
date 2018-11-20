package com.kh.semi.manager.review.model.dao;

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

import com.kh.semi.manager.review.model.vo.ReviewInfo;
import com.kh.semi.manager.reviewer.model.vo.ReviewerInfo;
import com.kh.semi.manager.video.model.vo.MovieInfo;

public class ReviewDao {
	
	private Properties prop;
	
	public ReviewDao() {
		prop = new Properties();
		String filePath = ReviewDao.class.getResource("/config/manager/review-query.properties").getPath().replace("%20", " ");
		
		try {
			prop.load(new FileReader(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public List<ReviewerInfo> selectAllReviewer(Connection con) {
		Statement pstmt = null;
		ResultSet rset = null;
		List<ReviewerInfo> result = null;
		
		try {
			result = new ArrayList<ReviewerInfo>();
			pstmt = con.createStatement();
			rset = pstmt.executeQuery(prop.getProperty("selectAllReviewer"));
			
			while(rset.next()) {
				ReviewerInfo ri = new ReviewerInfo();
				ri.setrName(rset.getString("rname"));
				ri.setRvrCode(rset.getString("rvrcode"));
				
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

	public List<MovieInfo> selectMovie(Connection con, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<MovieInfo> result = null;
		try {
			result = new ArrayList<MovieInfo>();
			pstmt = con.prepareStatement(prop.getProperty("selectMovie"));
			pstmt.setString(1, keyword);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				MovieInfo mi = new MovieInfo();
				mi.setmCode(rset.getString("mcode"));
				mi.setmTitle(rset.getString("mtitle"));
				mi.setDirector(rset.getString("director"));
				mi.setActor(rset.getString("actor"));
				mi.setnCode(rset.getString("nname"));
				mi.setOpenDate(rset.getDate("opendate"));
				
				result.add(mi);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}

	public int insertReview(Connection con, ReviewInfo rvi) {
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			pstmt = con.prepareStatement(prop.getProperty("insertReview"));
			pstmt.setString(1, rvi.getVideoId());
			pstmt.setString(2, rvi.getmCode());
			pstmt.setString(3, rvi.getRvrCode());
			pstmt.setDate(4, rvi.getUploadDate());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int selectOneReview(Connection con, String videoId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		try {
			pstmt = con.prepareStatement(prop.getProperty("selectOneReview"));
			pstmt.setString(1, videoId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) result++;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}

	public List<ReviewInfo> selectPartReview(Connection con, String rvrCode, String keyword) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<ReviewInfo> result = null;
		
		try {
			result = new ArrayList<ReviewInfo>();
			pstmt = con.prepareStatement(prop.getProperty("selectPartReview"));
			pstmt.setString(1, rvrCode);
			pstmt.setString(2, keyword);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				ReviewInfo ri = new ReviewInfo();
				ri.setVideoId(rset.getString("videoid"));
				ri.setRvrCode(rset.getString("rname"));
				ri.setmCode(rset.getString("mtitle"));
				ri.setUploadDate(rset.getDate("uploaddate"));
				
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

	public int deleteReview(Connection con, String videoId) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = con.prepareStatement(prop.getProperty("deleteReview"));
			pstmt.setString(1, videoId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
