package com.kh.semi.user.category.model.dao;

import static com.kh.semi.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.semi.manager.video.model.vo.MovieInfo;
import com.kh.semi.user.category.model.vo.CategoryInfo;

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
			
		}else if(cCode.equals("all")){
			
			category = "all";
		
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
		case "all" : 
			sql = prop.getProperty("selectList");
		}
		
		try {
			pstmt = con.prepareStatement(sql);
			System.out.println("sql : " + sql);
			
			if(!(cCode.equals("all"))){
				pstmt.setString(1, cCode); // 첫번째 물음표 	
			}
			
			rset = pstmt.executeQuery();
			
			mList = new ArrayList<MovieInfo>();
			
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
		/*for(int i=0; i<mList.size(); i++){
			System.out.println(mList.get(i));
		}*/
		
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

	// 셀렉트박스의 정보로 영화정보 가져오는 메소드 
	public ArrayList<MovieInfo> selectMoiveSelectedList(Connection con, String msql, String gCode, String nCode, String rvrCode) {
		
		if(gCode.equals("all")){
			gCode = gCode.replace(gCode, "%%");
		}
		if(nCode.equals("all")){
			nCode = nCode.replace(nCode, "%%");
		}
		if(rvrCode.equals("all")){
			rvrCode = rvrCode.replace(rvrCode, "%%");
		}
		
		System.out.println("gcode:" + gCode);
		System.out.println("nCode:" + nCode);
		System.out.println("rvrCode:" + rvrCode);
		
		ArrayList<MovieInfo> mList = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null; 
		
		String sql = prop.getProperty(msql);
		
		try {
			pstmt = con.prepareStatement(sql);
			System.out.println("msql ??? " + sql);
			/*if(!(gCode.equals("%%")) || !(nCode.equals("%%") || !(rvrCode.equals("%%")))){*/
				pstmt.setString(1, gCode); // 첫번째 물음표 
				pstmt.setString(2, nCode); // 두번째 물음표
				pstmt.setString(3, rvrCode); // 세번째 물음표
			/*}else{
				pstmt.setString(1, "%%");
				pstmt.setString(2, "%%");
				pstmt.setString(3, "%%");
			}*/
			rset = pstmt.executeQuery();
			mList = new ArrayList<MovieInfo>();
			
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
	
	
	// 모든 카테고리 정보 가져오는 메소드 
	public ArrayList<CategoryInfo> selectCategoryList(Connection con, String csql) {
		
		ArrayList<CategoryInfo> cList = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		
		String sql = prop.getProperty(csql);
		
		System.out.println("csql 확인 : " + sql);
		try {
			
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			cList = new ArrayList<CategoryInfo>();
			
			CategoryInfo categoryInfo = null;
			
			if(sql.contains("GENRE")){
				while(rset.next()){
					categoryInfo = new CategoryInfo();
					
					categoryInfo.setCode(rset.getString("gcode"));
					categoryInfo.setName(rset.getString("gname"));

					cList.add(categoryInfo);
				}
			}
			
			if(sql.contains("NATION")){
				while(rset.next()){
					categoryInfo = new CategoryInfo();
					
					categoryInfo.setCode(rset.getString("ncode"));
					categoryInfo.setName(rset.getString("nname"));

					cList.add(categoryInfo);
				}
			}
			
			
			if(sql.contains("REVIEWER")){
				while(rset.next()){
					categoryInfo = new CategoryInfo();
					
					categoryInfo.setCode(rset.getString("rvrcode"));
					categoryInfo.setName(rset.getString("rname"));

					cList.add(categoryInfo);
				}
			}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		
		} finally{
			close(con);
			close(stmt);
		}
		
		/*for(int i=0; i<cList.size(); i++){
			System.out.println("불러온 카테고리 : " + cList.get(i));
		}*/
		
		return cList;
	}

}
