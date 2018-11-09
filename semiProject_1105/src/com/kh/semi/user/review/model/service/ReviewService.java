package com.kh.semi.user.review.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.semi.user.movie.model.dao.DetailViewDao;
import com.kh.semi.user.movie.model.vo.ReviewInfo;
import com.kh.semi.user.review.model.dao.ReviewDao;
import com.kh.semi.user.review.model.vo.Review;
import static com.kh.semi.common.JDBCTemplate.*;

public class ReviewService {

	private ReviewDao rDao = new ReviewDao();

	public ArrayList<Review> reviewToday() {
		ArrayList<Review> list = new ArrayList<Review>();
		Connection con = getConnection();

		list = rDao.reviewToday(con);
		
		close(con);

		return list;
	}
	
	public ReviewInfo selectReview(String keyword) {
		Connection con=getConnection();
		ReviewInfo rv=new ReviewDao().selectReview(con,keyword);
		close(con);
		// 예외 던져주기
		return rv;
	}

}
