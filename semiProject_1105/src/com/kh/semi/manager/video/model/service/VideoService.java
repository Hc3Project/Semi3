package com.kh.semi.manager.video.model.service;

import static com.kh.semi.common.JDBCTemplate.close;
import static com.kh.semi.common.JDBCTemplate.commit;
import static com.kh.semi.common.JDBCTemplate.getConnection;
import static com.kh.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

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

	public int insertMovie(MovieInfo mi) {
		Connection con = getConnection();
		int result1 = vDao.insertMovie(con, mi);
		int result2 = 0;
		if(result1>0) {
			result2 = vDao.insertDetail(con, mi);
			if(result2>0) commit(con);
			else rollback(con);
		}else rollback(con);
		
		close(con);
		
		return result2;
	}

	public int selectDup(String mCode) {
		Connection con = getConnection();
		int result = vDao.selectDup(con, mCode);
		
		if(result>0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	public List<MovieInfo> selectPart(String sel, String keyword) {
		Connection con = getConnection();
		List<MovieInfo> result = vDao.selectPart(con, sel, keyword);
		close(con);
		return result;
	}

	public int deleteMovie(String mCode) {
		Connection con = getConnection();
		int result = vDao.deleteMovie(con, mCode);
		
		if(result>0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	public int updateMovie(MovieInfo mi) {
		Connection con = getConnection();
		int result = vDao.updateMovieInfo(con, mi);
		int result1 = 0;
		
		if(result>0) {
			result1 = vDao.updateMovieDetail(con, mi);
			if(result1>0) commit(con);
			else rollback(con);
		}
		else rollback(con);
		
		close(con);
		
		return result1;
	}

}
