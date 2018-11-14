package com.kh.semi.manager.user.model.service;

import static com.kh.semi.common.JDBCTemplate.close;
import static com.kh.semi.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.kh.semi.manager.user.model.dao.UserDao;
import com.kh.semi.manager.user.model.vo.UserInfo;

public class UserService {

	private UserDao uDao = new UserDao();
	
	public List<UserInfo> selectPartUser(String opt, String keyword, int stNum, int edNum) {
		Connection con = getConnection();
		List<UserInfo> result = uDao.selectPartUser(con, opt, keyword, stNum, edNum);
		close(con);
		return result;
	}
	
	
	
	
}
