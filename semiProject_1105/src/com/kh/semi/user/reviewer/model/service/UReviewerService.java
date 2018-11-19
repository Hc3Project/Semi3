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

	public String selectReviewerStatus(String userId) throws ReviewerViewException {
		Connection con=getConnection();
		String result=new UReviewerDao().selectReviewerStatus(con,userId);
		close(con);
		return result;
	}

	public int insertReviewerLikes(String userId, String rvrCode) throws ReviewerViewException {
		Connection con=getConnection();
		int result=rrDao.insertReviewerLikes(con,userId,rvrCode);
		if(result>0){
			commit(con);
			close(con);
			return result;
		}else{
			rollback(con);
			close(con);
			throw new ReviewerViewException("좋아요 실패!");
		}
		
	}

	public int deleteReviewerLikes(String userId, String rvrCode) throws ReviewerViewException {
		Connection con=getConnection();
		int result=rrDao.deleteReviewerLikes(con,userId,rvrCode);
		if(result>0){
			commit(con);
			close(con);
			return result;
		}else{
			rollback(con);
			close(con);
			throw new ReviewerViewException("싫어요 실패!");
		}
	}
	
}
