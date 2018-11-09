package com.kh.semi.user.review.model.service;

import static com.kh.semi.common.JDBCTemplate.close;
import static com.kh.semi.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.semi.exception.DetailViewException;
import com.kh.semi.user.review.model.dao.ReviewDao;
import com.kh.semi.user.review.model.vo.Review;
import com.kh.semi.user.review.model.vo.ReviewInfo;

public class ReviewService {

	private ReviewDao rDao = new ReviewDao();

	public ArrayList<Review> reviewToday() {
		ArrayList<Review> list = new ArrayList<Review>();
		Connection con = getConnection();

		list = rDao.reviewToday(con);
		
		close(con);

		return list;
	}
	public ArrayList<Review> reviewRecommend() {
		ArrayList<Review> list = new ArrayList<Review>();
		Connection con = getConnection();

		list = rDao.reviewRecommend(con);
		
		close(con);

		return list;
	}
	public ArrayList<Review> reviewTop() {
		ArrayList<Review> list = new ArrayList<Review>();
		Connection con = getConnection();

		list = rDao.reviewTop(con);
		
		close(con);

		return list;
	}
	
	public ReviewInfo selectReview(String videoId, String mCode) throws Exception{
		Connection con=getConnection();
		ReviewInfo rv=new ReviewDao().selectReview(con,videoId,mCode);
		close(con);
		if(rv!=null) return rv;
		else throw new DetailViewException("상세보기 실패!");
	}

}
