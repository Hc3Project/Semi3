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

	public ArrayList<Review> reviewList(String rsql) {
		ArrayList<Review> list = new ArrayList<Review>();
		Connection con = getConnection();
		//최신리뷰
		list = rDao.review(con,rsql);
		
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

}
