package com.kh.semi.manager.review.model.service;

import static com.kh.semi.common.JDBCTemplate.close;
import static com.kh.semi.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.kh.semi.manager.review.model.dao.ReviewDao;
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
	
}
