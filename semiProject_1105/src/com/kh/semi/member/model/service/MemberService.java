package com.kh.semi.member.model.service;

import com.kh.semi.member.execption.MemberException;
import com.kh.semi.member.model.dao.MemberDao;
import com.kh.semi.member.model.vo.Member;
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
}
