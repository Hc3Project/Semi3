package com.kh.semi.user.reviewer.model.service;

import java.sql.Connection;
import java.util.List;

import static com.kh.semi.common.JDBCTemplate.*;

import com.kh.semi.exception.ReviewerViewException;
import com.kh.semi.manager.reviewer.model.vo.ReviewerInfo;
import com.kh.semi.user.reviewer.model.dao.UReviewerDao;
import com.kh.semi.user.reviewer.model.vo.ReviewerLikes;


public class UReviewerService {
	private UReviewerDao rrDao = new UReviewerDao();

	public ReviewerInfo reviewerDetail(String rvrCode) {
		
		Connection con = getConnection();
		ReviewerInfo rin = new ReviewerInfo();
		
		rin = rrDao.reviewerDetail(con, rvrCode);
		return rin;
	}

	public List<ReviewerLikes> selectReviewerStatus(String userId) throws ReviewerViewException {
		Connection con=getConnection();
		List<ReviewerLikes> list=new UReviewerDao().selectReviewerStatus(con,userId);
		close(con);
		return list;
	}
	
}
