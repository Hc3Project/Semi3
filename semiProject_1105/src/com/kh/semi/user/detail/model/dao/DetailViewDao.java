package com.kh.semi.user.detail.model.dao;

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

import com.kh.semi.user.detail.model.vo.MovieDetailInfo;
import com.kh.semi.user.detail.model.vo.PosterInfo;
import com.kh.semi.user.detail.model.vo.ReviewInfo;

public class DetailViewDao {
	
	private Properties prop = new Properties();
	
	public DetailViewDao(){
		String filePath = DetailViewDao.class.getResource("/config/view-query.properties").getPath().replace("%20"," ");
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

	public MovieDetailInfo selectMovieDetail(Connection con, String keyword) {
		// 영화 상세정보
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		MovieDetailInfo mov=null;
		try {
			pstmt=con.prepareStatement(prop.getProperty("selectMovieDetail"));
			pstmt.setString(1, keyword);
			rset=pstmt.executeQuery();
			if(rset.next()){
				mov=new MovieDetailInfo();
				mov.setMtitle(rset.getString(1));
				mov.setDirector(rset.getString(2));
				mov.setActor(rset.getString(3));
				mov.setShowtime(rset.getInt(4));
				mov.setOpendate(rset.getDate(5));
				mov.setGname1(rset.getString(6));
				mov.setGname2(rset.getString(7));
				mov.setNname(rset.getString(8));
				mov.setCounts(rset.getInt(9));
				mov.setSynopsis(rset.getString(10));
			}
			
		} catch (SQLException e) {
		}finally{
			close(rset);
			close(pstmt);
		}
		return mov;
	}

	public ReviewInfo selectReview(Connection con, String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
