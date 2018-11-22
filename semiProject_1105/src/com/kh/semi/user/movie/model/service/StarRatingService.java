package com.kh.semi.user.movie.model.service;

import static com.kh.semi.common.JDBCTemplate.*;

import java.sql.Connection;

import com.kh.semi.exception.StarRatingException;
import com.kh.semi.user.movie.model.dao.StarRatingDao;
import com.kh.semi.user.movie.model.vo.StarRating;

public class StarRatingService {
	
	private static StarRatingDao srDao=new StarRatingDao();
	
	public int selectStarRating(String userId, String mCode){
		Connection con=getConnection();
		int score=srDao.selectStarRating(con,userId,mCode);
		close(con);
		return score;
	}
	
	public int insertStarRating(String userId, String mCode, int score) throws StarRatingException{
		Connection con=getConnection();
		int result=srDao.insertStarRating(con,userId,mCode,score);
		if(result>0) {
			commit(con);
			close(con);
			return result;
		}else {
			rollback(con);
			close(con);
			throw new StarRatingException("별점 등록 실패!");
		}
	}

	public StarRating selectStarAvgRating(String mCode) {
		Connection con=getConnection();
		StarRating result=srDao.selectStarAvgRating(con,mCode);
		close(con);
		return result;
	}
}
