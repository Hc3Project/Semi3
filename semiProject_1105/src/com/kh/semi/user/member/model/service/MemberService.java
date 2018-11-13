package com.kh.semi.user.member.model.service;

import com.kh.semi.user.member.execption.MemberException;
import com.kh.semi.user.member.model.dao.MemberDao;
import com.kh.semi.user.member.model.vo.Member;


import static com.kh.semi.common.JDBCTemplate.*;

import java.sql.Connection;


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
	
	
}