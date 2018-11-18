package com.kh.semi.user.review.model.service;

import static com.kh.semi.common.JDBCTemplate.*;


import java.sql.Connection;
import java.util.ArrayList;

import com.kh.semi.exception.DetailViewException;
import com.kh.semi.user.review.model.dao.ReviewDao;
import com.kh.semi.user.review.model.vo.Review;
import com.kh.semi.user.review.model.vo.ReviewInfo;

public class ReviewService {

	private ReviewDao rDao = new ReviewDao();

	public ArrayList<Review> reviewList(String rsql) {
		ArrayList<Review> list = new ArrayList<Review>();
		Connection con = getConnection();
		
		list = rDao.review(con,rsql);
		
		close(con);

		return list;
	}
	public ArrayList<Review> reviewList(String rsql,String mTitle) {
		ArrayList<Review> list = new ArrayList<Review>();
		Connection con = getConnection();
	
		list = rDao.review(con,rsql,mTitle);
		
		
		close(con);

		return list;
	}
	
	
	public ReviewInfo selectReview(String videoId) throws Exception{
		Connection con=getConnection();
		ReviewInfo rv=new ReviewDao().selectReview(con,videoId);
		close(con);
		if(rv==null) throw new DetailViewException("상세보기 실패!");
		return rv;
	}
	public void reviewCount(String videoId,String userId) {
		Connection con=getConnection();
		int result=0;
		try{
			if(userId!=null)result=new ReviewDao().reviewVisit(con,videoId,userId);
			if(result>0){new ReviewDao().reviewCount(con,videoId);
				commit(con);
			}
			
		}catch (Exception e) {
			rollback(con);
		}
		close(con);
		
	}
	public ArrayList<Review> rvrReviewList(String rsql, String rvrCode) {
		ArrayList<Review> list = new ArrayList<Review>();
		Connection con = getConnection();
	
		list = rDao.rvrReviewList(con,rsql,rvrCode);
		
		
		close(con);

		return list;
		
	}
	public ArrayList<Review> rvrReviewAll(String rsql, String rvrCode,int page) {
		ArrayList<Review> list = new ArrayList<Review>();
		Connection con = getConnection();
	
		list = rDao.rvrReviewAll(con,rsql,rvrCode,page);
		
		
		close(con);

		return list;
		
	}
	

}
