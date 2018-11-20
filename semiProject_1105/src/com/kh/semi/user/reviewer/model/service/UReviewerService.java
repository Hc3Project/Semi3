package com.kh.semi.user.reviewer.model.service;

import java.sql.Connection;
import java.util.List;

import static com.kh.semi.common.JDBCTemplate.*;

import com.kh.semi.exception.ReviewerViewException;
import com.kh.semi.manager.reviewer.model.vo.ReviewerInfo;
import com.kh.semi.user.reviewer.model.dao.UReviewerDao;


public class UReviewerService {
	private UReviewerDao rrDao = new UReviewerDao();

	public ReviewerInfo reviewerDetail(String rvrCode) throws ReviewerViewException {
		
		Connection con = getConnection();
		
		ReviewerInfo rin = rrDao.reviewerDetail(con, rvrCode);
		close(con);
		if(rin!=null) return rin;
		else throw new ReviewerViewException("리뷰어 페이지를 불러오는데 문제가 발생했습니다!");
	}

	public String selectReviewerStatus(String userId) {
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
			throw new ReviewerViewException("좋아요 기능에 문제가 발생했습니다!");
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
			throw new ReviewerViewException("좋아요 기능에 문제가 발생했습니다!!");
		}
	}
	
}
