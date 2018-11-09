package com.kh.semi.user.category.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import static com.kh.semi.common.JDBCTemplate.*;

import com.kh.semi.manager.video.model.vo.MovieInfo;

public class CategoryDao {
	
	private Properties prop = null;
	
	public CategoryDao(){
		
		prop = new Properties();
		
		String filePath = CategoryDao.class.getResource("/config/category/movie-category-query.properties").getPath().replace("%20"," ");
		
		try {
			
			prop.load(new FileReader(filePath));
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
	}
	
	// 선택된 카테고리의 영화만 가져오는 메소드
	public ArrayList<MovieInfo> selectCategory(Connection con, String cCode) {
		
		ArrayList<MovieInfo> mList = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		System.out.println("cCode : " + cCode);
		
		String sql = null;
		String category = null;
		
		// 장르로 검색됐을 시
		if(cCode.charAt(0) == 'G'){
			
			category = "genre";
			
		// 나라로 검색됐을 시
		}else if(cCode.equals("KR") || cCode.equals("TW") || cCode.equals("IN") || cCode.equals("CN") ||
				cCode.equals("US") || cCode.equals("JP") || cCode.equals("HK") || cCode.equals("DE") ||
				cCode.equals("UK") || cCode.equals("FR") || cCode.equals("CA") || cCode.equals("IT") ||
				cCode.equals("ES") || cCode.equals("ETC")){
			
			category = "nation";
			
		// 리뷰어로 검색됐을 시
		}else if(cCode.length() > 10){
			category = "reviewer";		
		}
		
		System.out.println("카테고리 확인 : " + category);
		
		switch(category){
		case "genre" :
			sql = prop.getProperty("selectMovieByGenre");
			break;
		case "nation" :
			sql = prop.getProperty("selectMovieByNation");
			break;
		case "reviewer" :
			sql = prop.getProperty("selectMovieByReviewer");
			break;
		}
		
		try {
			pstmt = con.prepareStatement(sql);
			System.out.println("sql : " + sql);
			pstmt.setString(1, cCode); // 첫번째 물음표 
			
			rset = pstmt.executeQuery();
			
			mList = new ArrayList<MovieInfo>();
			
			System.out.println(rset);

			while(rset.next()){
				
				MovieInfo mi = new MovieInfo();
				
				mi.setmCode(rset.getString("mcode"));
				mi.setmTitle(rset.getString("mtitle"));
				mi.setDirector(rset.getString("director"));
				mi.setActor(rset.getString("actor"));
				mi.setShowTime(rset.getInt("showtime"));
				mi.setOpenDate(rset.getDate("opendate"));
				mi.setgCode1(rset.getString("gCode1"));
				mi.setgCOde2(rset.getString("gCode2"));
				mi.setnCode(rset.getString("ncode"));
				//mi.setSyno(rset.getString("syno"));
				
				mList.add(mi);
				//System.out.println("이거 동작해 : ? " + mList.size());
			}
		

		} catch (SQLException e) {
			
			e.printStackTrace();
		
		} finally {
			close(rset);
			close(pstmt);
			
		}
		
		//선택된 무비 리스트 확인용 
		for(int i=0; i<mList.size(); i++){
			System.out.println(mList.get(i));
		}
		
		return mList;
	}
	
	
	
	// 영화정보 전체 가져오는 메소드
	public ArrayList<MovieInfo> selectMoiveList(Connection con) {
		
		ArrayList<MovieInfo> mList = null;
		Statement stmt = null;
		ResultSet rset = null; 
		
		String sql = prop.getProperty("selectList");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			
			mList = new ArrayList<MovieInfo>();
			
			while(rset.next()){
				MovieInfo mi = new MovieInfo();
				
				mi.setmCode(rset.getString("mCode"));
				mi.setmTitle(rset.getString("mTitle"));
				mi.setDirector(rset.getString("director"));
				mi.setActor(rset.getString("actor"));
				mi.setShowTime(rset.getInt("showTime"));
				mi.setOpenDate(rset.getDate("openDate"));
				mi.setgCode1(rset.getString("gCode1"));
				mi.setgCOde2(rset.getString("gCode2"));
				mi.setnCode(rset.getString("nCode"));
				mi.setSyno(rset.getString("syno"));
				
				mList.add(mi);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return mList;
	}

}
