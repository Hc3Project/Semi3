package com.kh.semi.manager.review.model.service;

import static com.kh.semi.common.JDBCTemplate.close;
import static com.kh.semi.common.JDBCTemplate.commit;
import static com.kh.semi.common.JDBCTemplate.getConnection;
import static com.kh.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.kh.semi.manager.review.model.dao.ReviewDao;
import com.kh.semi.manager.review.model.vo.ReviewInfo;
import com.kh.semi.manager.reviewer.model.vo.ReviewerInfo;
import com.kh.semi.manager.video.model.vo.MovieInfo;

public class ReviewService {
	
	ReviewDao rDao = new ReviewDao();

	public List<ReviewerInfo> selectAllReviewer() {
		Connection con = getConnection();
		List<ReviewerInfo> result = rDao.selectAllReviewer(con);
		close(con);
		return result;
	}

	public List<MovieInfo> selectMovieInfo(String keyword) {
		Connection con = getConnection();
		List<MovieInfo> result = rDao.selectMovie(con, keyword);
		close(con);
		return result;
	}

	public int insertReview(ReviewInfo rvi) {
		Connection con = getConnection();
		int result = rDao.insertReview(con, rvi);
		
		if(result>0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	public int selectOneReview(String videoId) {
		Connection con = getConnection();
		int result = rDao.selectOneReview(con, videoId);
		close(con);
		return result;
	}

	public List<ReviewInfo> selectPartReview(String rvrCode, String keyword) {
		Connection con = getConnection();
		List<ReviewInfo> result = rDao.selectPartReview(con, rvrCode, keyword);
		close(con);
		return result;
	}

	public int deleteReview(String videoId) {
		Connection con = getConnection();
		int result = rDao.deleteReview(con, videoId);
		if(result>0) commit(con);
		else rollback(con);
		return result;
	}
	
}
