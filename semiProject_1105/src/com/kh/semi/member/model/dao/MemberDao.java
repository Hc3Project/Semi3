package com.kh.semi.member.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.semi.member.execption.MemberException;
import com.kh.semi.member.model.vo.Member;
import static com.kh.semi.common.JDBCTemplate.*;

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

}
