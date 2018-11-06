package com.kh.semi.manager.video.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.semi.manager.video.model.vo.MovieInfo;

public class VideoDao {
	
	private Properties prop;
	
	public VideoDao() {
		prop = new Properties();
		String filePath = VideoDao.class.getResource("/config/manager/manager-query.properties").getPath();
		try {
			prop.load(new FileReader(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String selectGenreCode(Connection con, String genre) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String result = null; 
		
		String sql = prop.getProperty("selectGenre");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, genre);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) result = rset.getString("gcode");
			else result = "G19";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public String selectNationCode(Connection con, String nation) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String result = null;
		
		String sql = prop.getProperty("selectNation");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, nation);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) result = rset.getString("ncode");
			else result = "ETC";
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public int insertMovie(Connection con, MovieInfo mi) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = prop.getProperty("insertMovie");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mi.getmCode());
			pstmt.setString(2, mi.getmTitle());
			pstmt.setString(3, mi.getDirector());
			pstmt.setString(4, mi.getActor());
			pstmt.setInt(5, mi.getShowTime());
			pstmt.setDate(6, mi.getOpenDate());
			pstmt.setString(7, mi.getgCode1());
			pstmt.setString(8, mi.getgCOde2());
			pstmt.setString(9, mi.getnCode());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public int insertDetail(Connection con, MovieInfo mi) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = prop.getProperty("insertDetail");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mi.getmCode());
			pstmt.setString(2, mi.getSyno());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public int selectDup(Connection con, String mCode) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String sql = prop.getProperty("selectDup");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mCode);
			rset = pstmt.executeQuery();
			if(rset.next()) result++;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
