package com.kh.semi.user.reviewer.model.service;

import java.sql.Connection;
import static com.kh.semi.common.JDBCTemplate.*;

import com.kh.semi.manager.reviewer.model.vo.ReviewerInfo;
import com.kh.semi.user.reviewer.model.dao.UReviewerDao;


public class UReviewerService {
	private UReviewerDao rrDao = new UReviewerDao();

	public ReviewerInfo reviewerDetail(String rvrCode) {
		
		Connection con = getConnection();
		ReviewerInfo rin = new ReviewerInfo();
		
		rin = rrDao.reviewerDetail(con, rvrCode);
		return rin;
	}
	
}
