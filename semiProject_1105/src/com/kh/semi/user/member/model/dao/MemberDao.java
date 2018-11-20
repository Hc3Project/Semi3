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

import com.kh.semi.exception.MemberException;
import com.kh.semi.user.category.model.vo.CategoryInfo;
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
	public int insertMember(Connection con, Member m) {
		int result =0;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement(prop.getProperty("insertMember"));
			
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
	public Member selectMember(Connection con, Member m) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member result = null;
		
		try {
			
			pstmt = con.prepareStatement(prop.getProperty("selectMember"));
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
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}
	public int updateMember(Connection con, Member m) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		
		try {
			pstmt = con.prepareStatement(prop.getProperty("updateMember"));
			
			pstmt.setString(1, m.getEmail());
			pstmt.setString(2, m.getPassword());
			pstmt.setString(3, m.getUserId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	public int deleteMember(Connection con, String userId) {
		int result =0;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement(prop.getProperty("deleteMember"));
			pstmt.setString(1, userId);
			
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;

 }
	public int idDupCheck(Connection con, String id) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int result =0;
		
		try {
			pstmt = con.prepareStatement(prop.getProperty("idDupCheck"));
			
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
		try {
			pstmt = con.prepareStatement(prop.getProperty("selectUserIdx"));
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
		
		try {
			result = new ArrayList<String>();
			stmt = con.createStatement();
			rset = stmt.executeQuery(prop.getProperty("selectIdxList").replace("condition", opt));
			while(rset.next()) {
				result.add(rset.getString(opt));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return result;
	}
	public int[][] selectRating(Connection con, int uLen, int iLen) {
		Statement stmt = null;
		ResultSet rset = null;
		int[][] result = null;
		try {
			result = new int[uLen][iLen];
			stmt = con.createStatement();
			rset = stmt.executeQuery(prop.getProperty("selectItemMatrix"));
			while(rset.next()) {
				result[rset.getInt("useridx")][rset.getInt("itemidx")] = rset.getInt("score");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return result;
	}
	public List<String> selectLikesReviewer(Connection con, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<String> result = null;
		try {
			result = new ArrayList<String>();
			pstmt = con.prepareStatement(prop.getProperty("selectLikesReviewer"));
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				result.add(rset.getString("rvrcode"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}
	public String selectMovieTitle(Connection con, String mCode) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String result = null;
		try {
			result = "";
			pstmt = con.prepareStatement(prop.getProperty("selectMovieTitle"));
			pstmt.setString(1, mCode);
			rset = pstmt.executeQuery();
			if(rset.next()) result = rset.getString("mTitle");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}
	public int[] selectRatingCnt(Connection con, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int[] result = null;
		try {
			result = new int[5];
			pstmt = con.prepareStatement(prop.getProperty("selectScoreCnt"));
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result[0] = rset.getInt("s1");
				result[1] = rset.getInt("s2");
				result[2] = rset.getInt("s3");
				result[3] = rset.getInt("s4");
				result[4] = rset.getInt("s5");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}
	
}
