package com.kh.semi.user.search.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.semi.manager.video.model.vo.MovieInfo;
import com.kh.semi.user.search.model.dao.SearchMovieDao;
import static com.kh.semi.common.JDBCTemplate.*;

public class SearchMovieService {
	
	private SearchMovieDao smDao = new SearchMovieDao();

	public ArrayList<MovieInfo> searchMovie(String movieTitle) {
		Connection con = getConnection();
		ArrayList<MovieInfo> mList = null;
		
		
		// 수정 필요
		mList = smDao.searchMovie(con, movieTitle) ;
		
		return mList;
	}

}
