package com.kh.semi.user.review.model.service;

import static com.kh.semi.common.JDBCTemplate.*;


import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.kh.semi.exception.DetailViewException;
import com.kh.semi.user.review.model.dao.ReviewDao;
import com.kh.semi.user.review.model.vo.Review;
import com.kh.semi.user.review.model.vo.ReviewInfo;

public class ReviewService {

	private ReviewDao rDao = new ReviewDao();

	public ArrayList<Review> reviewList(String rsql) {
		Connection con = getConnection();

		ArrayList<Review> list = rDao.review(con,rsql);

		close(con);

		return list;
	}
	public ArrayList<Review> reviewList(String rsql,String mTitle) {
		Connection con = getConnection();

		ArrayList<Review> list = rDao.review(con,rsql,mTitle);


		close(con);

		return list;
	}


	public ReviewInfo selectReview(String videoId) throws Exception{
		Connection con=getConnection();
		ReviewInfo rv=rDao.selectReview(con,videoId);
		close(con);
		if(rv==null) throw new DetailViewException("리뷰 페이지를 가져오는데 문제가 발생했습니다!");
		return rv;
	}
	public void reviewCount(String videoId,String userId) {
		Connection con=getConnection();
		int result=0;
		try{
			if(userId!=null)result=rDao.reviewVisit(con,videoId,userId);
			if(result>0){rDao.reviewCount(con,videoId);
			commit(con);
			}

		}catch (Exception e) {
			rollback(con);
		}
		close(con);

	}
	public ArrayList<Review> rvrReviewList(String rsql, String rvrCode) {
		Connection con = getConnection();

		ArrayList<Review> list = rDao.rvrReviewList(con,rsql,rvrCode);


		close(con);

		return list;

	}
	public ArrayList<Review> rvrReviewAll(String rsql, String rvrCode,int page) {
		Connection con = getConnection();

		ArrayList<Review> list = rDao.rvrReviewAll(con,rsql,rvrCode,page);


		close(con);

		return list;

	}
	public List<Review> reviewSameGenre(String mCode) {
		Connection con = getConnection();
		List<Review> result = rDao.rvSameGenre(con, mCode);
		close(con);
		return result;
	}
}
