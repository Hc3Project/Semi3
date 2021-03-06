package com.kh.semi.manager.user.model.service;

import static com.kh.semi.common.JDBCTemplate.close;
import static com.kh.semi.common.JDBCTemplate.commit;
import static com.kh.semi.common.JDBCTemplate.getConnection;
import static com.kh.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.kh.semi.manager.user.model.dao.UserDao;
import com.kh.semi.manager.user.model.vo.CategoryRating;
import com.kh.semi.manager.user.model.vo.UserInfo;

public class UserService {

	private UserDao uDao = new UserDao();
	
	public List<UserInfo> selectPartUser(String opt, String keyword, int stNum, int edNum) {
		Connection con = getConnection();
		List<UserInfo> result = uDao.selectPartUser(con, opt, keyword, stNum, edNum);
		close(con);
		return result;
	}

	public int deleteUser(String userId) {
		Connection con = getConnection();
		int result = uDao.deleteUser(con, userId);
		if(result>0) commit(con);
		else rollback(con);
		close(con);
		return result;
	}

	public List<CategoryRating> selectAllRating() {
		Connection con = getConnection();
		List<CategoryRating> result = uDao.selectAllRating(con);
		close(con);
		return result;
	}
}
