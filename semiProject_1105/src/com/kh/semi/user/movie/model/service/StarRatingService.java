package com.kh.semi.user.movie.model.service;

import static com.kh.semi.common.JDBCTemplate.*;

import java.sql.Connection;

import com.kh.semi.exception.StarRatingException;
import com.kh.semi.user.movie.model.dao.StarRatingDao;

public class StarRatingService {
	
	private static StarRatingDao srDao=new StarRatingDao();
	
	public int selectStarRating(String userId, String mCode){
		Connection con=getConnection();
		int score=srDao.selectStarRating(con,userId,mCode);
		return score;
	}
	
	public int insertStarRating(String userId, String mCode, int score) throws StarRatingException{
		Connection con=getConnection();
		int result=srDao.insertStarRating(con,userId,mCode,score);
		if(result>0) return result;
		else throw new StarRatingException("별점 등록 실패!");
	}
	
	public int updateStarRating(String userId, String mCode, int score) throws StarRatingException{
		Connection con=getConnection();
		int result=srDao.updateStarRating(con,userId,mCode,score);
		if(result>0) return result;
		else throw new StarRatingException("별점 등록 실패!");
	}

}
