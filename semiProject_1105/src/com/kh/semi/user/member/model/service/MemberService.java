package com.kh.semi.user.member.model.service;

import static com.kh.semi.common.JDBCTemplate.close;
import static com.kh.semi.common.JDBCTemplate.commit;
import static com.kh.semi.common.JDBCTemplate.getConnection;
import static com.kh.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.kh.semi.user.category.model.vo.CategoryInfo;
import com.kh.semi.user.member.execption.MemberException;
import com.kh.semi.user.member.model.dao.MemberDao;
import com.kh.semi.user.member.model.vo.Member;


public class MemberService {
	private MemberDao mDao = new MemberDao();
	
	public int insertMember(Member m) throws MemberException {
		Connection con = getConnection();
		System.out.println(con);
		int result = mDao.insertMember(con, m);
		
		if(result>0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
		
	}

	public Member selectMember(Member m) throws MemberException{
		
		Connection con = getConnection();
		
		Member result = mDao.selectMember(con, m);
		
		close(con);
		
		if(result==null) throw new MemberException("아이디나 비밀번호가 일치하는 회원 없음");
		
		return result;
	}

	public int updateMember(Member m) throws MemberException{
		Connection con = getConnection();
		
		int result = mDao.updateMember(con, m);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
	    return result;
	}

	public int deleteMember(String userId) throws MemberException{
		Connection con = getConnection();
		
		int result = mDao.deleteMember(con, userId);
		
		if(result>0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}
	
	public int idDupCheck(String id) {
		Connection con = getConnection();
		
		int result = mDao.idDupCheck(con, id);
		
		close(con);
		
		return result;
	}
	
	// 추천용
	public int selectUserIdx(String userId) {
		Connection con = getConnection();
		int result = mDao.selectUserIdx(con, userId);
		close(con);
		return result;
	}

	public ArrayList<String> selectUserNum(String opt) {
		Connection con = getConnection();
		ArrayList<String> result = mDao.selectUserNum(con, opt);
		close(con);
		return result;
	}
	
	public int[][] selectRating(int uLen, int iLen) {
		Connection con = getConnection();
		int[][] result = mDao.selectRating(con, uLen, iLen);
		close(con);
		return result;
	}
	
}
