package com.kh.semi.user.member.model.dao;

import static com.kh.semi.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.semi.user.category.model.vo.CategoryInfo;
import com.kh.semi.user.member.execption.MemberException;
import com.kh.semi.user.member.model.vo.Member;

public class MemberDao {
	private Properties prop;
	
	public MemberDao(){
		prop = new Properties();
		
		String filePath = MemberDao.class.getResource("/config/member-query.properties").getPath().replace("%20", " ");
		
		try {
			prop.load(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public int insertMember(Connection con, Member m) throws MemberException{
		int result =0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertMember");
		System.out.println(sql);
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getPassword());
			pstmt.setString(3, m.getEmail());
			System.out.println("email"+ m.getEmail());
			
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	public Member selectMember(Connection con, Member m) throws MemberException{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member result = null;
		
		String sql = prop.getProperty("selectMember");
		
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getPassword());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				result = new Member();
				
				result.setUserId(rset.getString("USERID"));
				result.setPassword(rset.getString("USERPWD"));
				result.setEmail(rset.getString("EMAIL"));
			}
		} catch (SQLException e) {
			
			//e.printStackTrace();
			throw new MemberException(e.getMessage());
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}
	public int updateMember(Connection con, Member m) throws MemberException{
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateMember");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, m.getEmail());
			pstmt.setString(2, m.getPassword());
			pstmt.setString(3, m.getUserId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
			throw new MemberException(e.getMessage());
		} finally {
			close(pstmt);
		}
		return result;
	}
	public int deleteMember(Connection con, String userId) throws MemberException{
		int result =0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteMember");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			
			//e.printStackTrace();
			
			throw new MemberException(e.getMessage());
			
		} finally {
			close(pstmt);
		}
		
		
		return result;

 }
	public int idDupCheck(Connection con, String id) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int result =0;
		
		String sql = prop.getProperty("idDupCheck");
		System.out.println(sql);
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			rset = pstmt.executeQuery();
			
			if(rset.next()) result = rset.getInt(1);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}
	
	// 추천용
	public int selectUserIdx(Connection con, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = -1;
		String sql = prop.getProperty("selectUserIdx");
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			if(rset.next()) result = rset.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}
	public ArrayList<String> selectUserNum(Connection con, String opt) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<String> result = null;
		String sql = prop.getProperty("selectIdxList");
		sql = sql.replace("condition", opt);
		try {
			result = new ArrayList<String>();
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			while(rset.next()) {
				result.add(rset.getString(opt));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public int[][] selectRating(Connection con, int uLen, int iLen) {
		Statement stmt = null;
		ResultSet rset = null;
		int[][] result = null;
		String sql = prop.getProperty("selectItemMatrix");
		try {
			result = new int[uLen][iLen];
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			while(rset.next()) {
				result[rset.getInt("useridx")][rset.getInt("itemidx")] = rset.getInt("score");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public List<CategoryInfo> selectGenreCnt(Connection con, String gCode) {
		Statement stmt = null;
		ResultSet rset = null;
		List<CategoryInfo> result = null;
		String sql = prop.getProperty("selectGenreCnt");
		sql = sql.replace("condition", gCode);
		try {
			result = new ArrayList<CategoryInfo>();
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			while(rset.next()) {
				CategoryInfo ci = new CategoryInfo();
				ci.setName(rset.getString("gname"));
				ci.setCnt(rset.getInt("gcnt"));
				
				result.add(ci);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
