package com.kh.semi.user.category.model.service;

import static com.kh.semi.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.semi.exception.CategoryViewException;
import com.kh.semi.manager.video.model.vo.MovieInfo;
import com.kh.semi.user.category.model.dao.CategoryDao;
import com.kh.semi.user.category.model.vo.CategoryInfo;

public class CategoryService {
	
	private CategoryDao cDao = new CategoryDao();
	
	public ArrayList selectCategory(String cCode) throws CategoryViewException {
	
		Connection con = getConnection();
		
		ArrayList<MovieInfo> mList = null;
		
		if(cCode.length()>0) mList = cDao.selectCategory(con, cCode);//전달된 cCode가 있으면 해당 카테고리 페이지로 이동
		else mList = cDao.selectMoiveList(con); //없으면 전체 영화 불러오는 페이지 
		
		if(mList!=null) return mList;
		else throw new CategoryViewException("카테고리를 가져오는 중 문제가 발생했습니다!");
	}
	
	// DB에서 생성된 카테고리 목록 불러오는 서비스
	public ArrayList<CategoryInfo> selectCategoryList(String csql) {
		ArrayList<CategoryInfo> cList = new ArrayList<CategoryInfo>();
		Connection con = getConnection();
		cList = cDao.selectCategoryList(con, csql);
		
		close(con);
		
		return cList;
	}
	
	// 셀렉트박스에서 가져오는 부분 
	public ArrayList<MovieInfo> selectMovieList(String msql, String gCode, String nCode, String rvrCode,int mPage) {
		
		Connection con = getConnection();
		
		ArrayList<MovieInfo> mList = null;
		
		mList = cDao.selectMoiveSelectedList(con, msql, gCode, nCode, rvrCode,mPage);
		
		return mList;
	}

}
