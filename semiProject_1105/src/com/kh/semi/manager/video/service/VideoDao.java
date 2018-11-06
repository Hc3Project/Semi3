package com.kh.semi.manager.video.service;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class VideoDao {
	
	private Properties prop;
	
	public VideoDao() {
		prop = new Properties();
		String filePath = VideoDao.class.getResource("/config/manager/manager-query.properties.properties").getPath();
		try {
			prop.load(new FileReader(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String selectCode(Connection con, String genre) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String result = null; 
		
		String sql = prop.getProperty("");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, genre);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) result = rset.getString("gcode");
			else 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
