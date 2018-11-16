package com.kh.semi.user.movie.model.dao;

import static com.kh.semi.common.JDBCTemplate.*;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.semi.manager.video.model.vo.MovieInfo;
import com.kh.semi.user.movie.model.vo.MovieDetailInfo;
import com.kh.semi.user.movie.model.vo.PosterInfo;

public class MovieDao {
	
	private Properties prop = new Properties();
	
	public MovieDao(){
		String filePath = MovieDao.class.getResource("/config/view-query.properties").getPath().replace("%20"," ");
		try {
			prop.load(new FileReader(filePath));
		} catch (IOException e) {
		}
	}

	public List<PosterInfo> getPowerImage(Connection con, String result, String keyword) {
		// 포스터찾기
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		List<PosterInfo> list=null;
		try {
			pstmt=con.prepareStatement(prop.getProperty("findCorrectMovie"));
			pstmt.setString(1, keyword);
			rset=pstmt.executeQuery();
			list=new ArrayList<>();
			while(rset.next()){
				PosterInfo pi=new PosterInfo(rset.getString(1),rset.getDate(2));
				list.add(pi);
			}
		} catch (SQLException e) {
		}finally{
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public MovieDetailInfo selectMovieDetail(Connection con, String mCode) {
		// 영화 상세정보
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		MovieDetailInfo mov=null;
		try {
			pstmt=con.prepareStatement(prop.getProperty("selectMovieDetail"));
			pstmt.setString(1, mCode);
			rset=pstmt.executeQuery();
			if(rset.next()){
				mov=new MovieDetailInfo();
				mov.setMtitle(rset.getString(1));
				mov.setMcode(rset.getString(2));
				mov.setDirector(rset.getString(3));
				mov.setActor(rset.getString(4));
				mov.setShowtime(rset.getInt(5));
				mov.setOpendate(rset.getDate(6));
				mov.setGname1(rset.getString(7));
				mov.setGname2(rset.getString(8));
				mov.setNname(rset.getString(9));
				mov.setCounts(rset.getInt(10));
				mov.setSynopsis(rset.getString(11));
			}
			
		} catch (SQLException e) {
		}finally{
			close(rset);
			close(pstmt);
		}
		return mov;
	}
//최근방문기록
	public int MovieVisit(Connection con, String mCode,String userId) {
		int result =0;
		String sql = prop.getProperty("movieVisit");
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(2, mCode);
			pstmt.setString(1, userId);
			
			result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		
		
		return result;
		
	}
//조회수 증가
	public int MovieCount(Connection con, String mCode) {
		int result =0;
		String sql = prop.getProperty("movieCount");
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mCode);
			
			
			result=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		
		
		return result;
	}

	public ArrayList<MovieInfo> visitMovie(Connection con, String userId) {
		ArrayList<MovieInfo> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset =null;
		
		String sql = prop.getProperty("visitMovie");
		
		try {
			list=new ArrayList<MovieInfo>();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			MovieInfo mi = null;
			while(rset.next()) {
				mi=new MovieInfo();
				mi.setmTitle(rset.getString("MTITLE"));
				mi.setmCode(rset.getString("MCODE"));
				
				list.add(mi);
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	

}
