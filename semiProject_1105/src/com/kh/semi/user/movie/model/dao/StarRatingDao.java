package com.kh.semi.user.movie.model.dao;

import static com.kh.semi.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class StarRatingDao {
	
	private Properties prop = new Properties();
	
	public StarRatingDao(){
		String filePath = StarRatingDao.class.getResource("/config/score-query.properties").getPath().replace("%20"," ");
		try {
			prop.load(new FileReader(filePath));
		} catch (IOException e) {
		}
	}
	
	public int selectStarRating(Connection con, String userId, String mCode){
		int score=0;
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		try {
			pstmt=con.prepareStatement(prop.getProperty("selectStarRating"));
			pstmt.setString(1, userId);
			pstmt.setString(2, mCode);
			rset=pstmt.executeQuery();
			if(rset.next()){
				score=rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		
		return score;
	}
	
	public int insertStarRating(Connection con, String userId, String mCode, int score){
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=con.prepareStatement(prop.getProperty("insertStarRating"));
			pstmt.setString(1, userId);
			pstmt.setString(2, mCode);
			pstmt.setInt(3, score);
			result=pstmt.executeUpdate();
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		return result;
	}
	
	public int updateStarRating(Connection con, String userId, String mCode, int score){
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=con.prepareStatement(prop.getProperty("updateStarRating"));
			pstmt.setInt(1, score);
			pstmt.setString(2, userId);
			pstmt.setString(3, mCode);
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		return result;
	}

	public int selectStarAvgRating(Connection con, String mCode) {
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		int result=0;
		try {
			pstmt=con.prepareStatement(prop.getProperty("selectStarAvgRating"));
			pstmt.setString(1, mCode);
			rset=pstmt.executeQuery();
			if(rset.next()){
				result=rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		return result;
	}

}
