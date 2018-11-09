package com.kh.semi.user.movie.model.service;

import static com.kh.semi.common.JDBCTemplate.*;

import java.sql.Connection;

import com.kh.semi.user.movie.model.dao.StarRatingDao;

public class StarRatingService {
	
	private static StarRatingDao srDao=new StarRatingDao();
	
	public int selectStarRating(String userId, String mCode){
		Connection con=getConnection();
		int score=srDao.selectStarRating(con,userId,mCode);
		return score;
	}
	
	public int insertStarRation(){
		return 0;
	}
	
	public int updateStarRation(){
		return 0;
	}

}
