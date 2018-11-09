package com.kh.semi.user.search.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.semi.manager.video.model.vo.MovieInfo;
import com.kh.semi.user.search.model.dao.SearchMovieDao;
import static com.kh.semi.common.JDBCTemplate.*;

public class SearchMovieService {
	
	private SearchMovieDao smDao = new SearchMovieDao();

	public ArrayList<MovieInfo> searchMovie() {
		
		ArrayList<MovieInfo> mList = null;
		Connection con = getConnection();
		
		// 수정 필요
		mList = smDao.searchMovie();
		
		return null;
	}

}
