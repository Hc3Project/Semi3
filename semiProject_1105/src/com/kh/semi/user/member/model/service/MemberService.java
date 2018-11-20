package com.kh.semi.user.member.model.service;

import static com.kh.semi.common.JDBCTemplate.close;
import static com.kh.semi.common.JDBCTemplate.commit;
import static com.kh.semi.common.JDBCTemplate.getConnection;
import static com.kh.semi.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.kh.semi.exception.MemberException;
import com.kh.semi.user.category.model.vo.CategoryInfo;
import com.kh.semi.user.member.model.dao.MemberDao;
import com.kh.semi.user.member.model.vo.Member;


public class MemberService {
	private MemberDao mDao = new MemberDao();
	
	public int insertMember(Member m) throws MemberException {
		Connection con = getConnection();
		System.out.println(con);
		int result = mDao.insertMember(con, m);
		
		if(result>0) {
			commit(con);
			close(con);
			return result;
		}else {
			rollback(con);
			close(con);
			throw new MemberException("회원 가입 도중 문제가 발생했습니다!");
		}
		
		
		
	}

	public Member selectMember(Member m) throws MemberException{
		
		Connection con = getConnection();
		
		Member result = mDao.selectMember(con, m);
		
		close(con);
		
		if(result==null) throw new MemberException("아이디 혹은 비밀번호가 잘못되었습니다!");
		
		return result;
	}

	public int updateMember(Member m) throws MemberException{
		Connection con = getConnection();
		
		int result = mDao.updateMember(con, m);
		
		if(result > 0) {
			commit(con);
			close(con);
		    return result;
		}else {
			rollback(con);
			close(con);
			throw new MemberException("회원 정보 수정 중 문제가 발생했습니다!");
		}
		
		
	}

	public int deleteMember(String userId) throws MemberException{
		Connection con = getConnection();
		
		int result = mDao.deleteMember(con, userId);
		
		if(result>0) {
			commit(con);
			close(con);
			return result;
		}else{
			rollback(con);
			close(con);
			throw new MemberException("회원 탈퇴 도중 문제가 발생했습니다!");
		}
		
		
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

	public List<String> selectLikesReviewer(String userId) {
		Connection con = getConnection();
		List<String> result = mDao.selectLikesReviewer(con, userId);
		close(con);
		return result;
	}

	public String selectMovieTitle(String mCode) {
		Connection con = getConnection();
		String result = mDao.selectMovieTitle(con, mCode);
		close(con);
		return result;
	}

	public List<Integer> selectRatingCnt(String userId) {
		Connection con = getConnection();
		List<Integer> result = mDao.selectRatingCnt(con, userId);
		close(con);
		return result;
	}

	public List<CategoryInfo> selectGenreStat(String userId, String col) {
		Connection con = getConnection();
		List<CategoryInfo> result = mDao.selectGenreStat(con, userId, col);
		close(con);
		return result;
	}
	
}
