package com.kh.semi.user.search.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.semi.manager.video.model.vo.MovieInfo;

import static com.kh.semi.common.JDBCTemplate.*;

public class SearchMovieDao {
	private Properties prop;
	
	public SearchMovieDao(){
		prop = new Properties();
		String filePath = SearchMovieDao.class.getResource("/config/search-query.properties").getPath().replace("%20", " ");
	
		try {
			prop.load(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public ArrayList<MovieInfo> searchMovie(Connection con, String movieTitle) {
		
		ArrayList<MovieInfo> mList = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("searchTitle");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, movieTitle);
			rset = pstmt.executeQuery();
			
			mList = new ArrayList<MovieInfo>();
			
			while(rset.next()){
				MovieInfo mi = new MovieInfo();
				
				mi.setmCode(rset.getString("mcode"));
				mi.setmTitle(rset.getString("mtitle"));
				
				mList.add(mi);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			close(rset);
			close(pstmt);
			
		}
		
		// 확인용 출력문
		for(MovieInfo mi : mList) System.out.println(mi);
		return mList;
	}

}
