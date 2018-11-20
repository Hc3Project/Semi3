package com.kh.semi.manager.reviewer.model.service;

import java.sql.Connection;
import java.util.List;

import com.kh.semi.manager.review.model.vo.ReviewInfo;
import com.kh.semi.manager.reviewer.model.dao.ReviewerDao;
import com.kh.semi.manager.reviewer.model.vo.ReviewerInfo;
import static com.kh.semi.common.JDBCTemplate.*;

public class ReviewerService {

	ReviewerDao rDao = new ReviewerDao();
	
	public List<ReviewerInfo> reviewerSelectPart(String keyword) {
		Connection con = getConnection();
		List<ReviewerInfo> result = rDao.reviewerSelectPart(con, keyword);
		close(con);
		
		return result;
	}

	public int updateReviewer(ReviewerInfo ri) {
		Connection con = getConnection();
		int result = rDao.updateReviewer(con, ri);
		
		if(result>0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	public int insertReviewer(ReviewerInfo ri) {
		Connection con = getConnection();
		int result = rDao.insertReviewer(con, ri);
		
		if(result>0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	public List<ReviewerInfo> reviewerSelectPartCnt(List<ReviewerInfo> list) {
		Connection con = getConnection();
		List<ReviewerInfo> result = rDao.reviewerSelectPartCnt(con, list);
		close(con);
		return result;
	}

	public int deleteReviewer(String channelId) {
		Connection con = getConnection();
		int result = rDao.deleteReviewer(con, channelId);
		if(result>0) commit(con);
		else rollback(con);
		close(con);
		return result;
	}

	public int selectReviewerOne(String channelId) {
		Connection con = getConnection();
		int result = rDao.selectReviewerOne(con, channelId);
		close(con);
		return result;
	}

	public List<ReviewerInfo> selectReviewerRank() {
		Connection con = getConnection();
		List<ReviewerInfo> result = rDao.selectReviewerRank(con);
		close(con);
		return result;
	}

}
