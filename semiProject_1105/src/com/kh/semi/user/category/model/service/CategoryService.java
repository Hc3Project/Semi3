package com.kh.semi.user.category.model.service;

import static com.kh.semi.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.semi.manager.video.model.vo.MovieInfo;
import com.kh.semi.user.category.model.dao.CategoryDao;

public class CategoryService {
	
	private CategoryDao cDao = new CategoryDao();
	
	public ArrayList selectCategory(String cCode) {
	
		Connection con = getConnection();
		
		ArrayList<MovieInfo> mList = null;
		
		if(cCode.length()>0) mList = cDao.selectCategory(con, cCode);//전달된 cCode가 있으면 해당 카테고리 페이지로 이동
		else mList = cDao.selectMoiveList(con); //없으면 전체 영화 불러오는 페이지 
		
		return mList;
	}

}
