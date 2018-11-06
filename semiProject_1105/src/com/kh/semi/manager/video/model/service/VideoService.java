package com.kh.semi.manager.video.model.service;

import static com.kh.semi.common.JDBCTemplate.close;
import static com.kh.semi.common.JDBCTemplate.commit;
import static com.kh.semi.common.JDBCTemplate.getConnection;
import static com.kh.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.kh.semi.manager.video.model.dao.VideoDao;
import com.kh.semi.manager.video.model.vo.MovieInfo;

public class VideoService {
	
	VideoDao vDao = new VideoDao();
	
	public String selectGenreCode(String genre) {
		Connection con = getConnection();
		String result = vDao.selectGenreCode(con, genre);
		
		close(con);
		
		return result;
	}

	public String selectNationCode(String nation) {
		Connection con = getConnection();
		String result = vDao.selectNationCode(con, nation);
		
		close(con);
		
		return result;
	}

	public void insertMovie(MovieInfo mi) {
		Connection con = getConnection();
		int result1 = vDao.insertMovie(con, mi);
		int result2 = 0;
		if(result1>0) {
			result2 = vDao.insertDetail(con, mi);
			if(result2>0) commit(con);
			else rollback(con);
		}else rollback(con);
		
		close(con);
	}

	public int selectDup(String mCode) {
		Connection con = getConnection();
		int result = vDao.selectDup(con, mCode);
		
		if(result>0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

}
