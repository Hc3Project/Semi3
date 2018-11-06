package com.kh.semi.manager.video.service;

import java.sql.Connection;

import static com.kh.semi.common.JDBCTemplate.*;

public class VideoService {
	
	VideoDao vDao = new VideoDao();
	
	public String selectCode(String genre) {
		Connection con = getConnection();
		String result = vDao.selectCode(con, genre);
		
		if(result!=null) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

}
