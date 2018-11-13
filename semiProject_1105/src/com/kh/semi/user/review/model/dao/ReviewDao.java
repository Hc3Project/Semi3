package com.kh.semi.user.review.model.dao;

import static com.kh.semi.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.semi.user.review.model.vo.Review;
import com.kh.semi.user.review.model.vo.ReviewInfo;

public class ReviewDao {
	private Properties prop = new Properties();

	public ReviewDao(){
		String filePath = 
				ReviewDao.class.getResource("/config/review-query.properties").getPath().replace("%20"," ");

		try {
			prop.load(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}


	public ArrayList<Review> reviewToday(Connection con) {
		ArrayList<Review> list = null;
		Statement stmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("todayList");

		try {
		
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql);
			list = new ArrayList<Review>();
			
			Review review = null;

			while (rset.next()) {
				review = new Review();
				/*
				 * VIDEOID MCODE RVRCODE UPLOADDATE COUNTS
				 */
				review.setVideoid(rset.getString("VIDEOID"));
				review.setReviewer(rset.getString("RNAME"));
				review.setMovie(rset.getString("MTITLE"));
				

				list.add(review);
			}
			System.out.println(list.size());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return list;
	}
	public ArrayList<Review> reviewRecommend(Connection con) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ReviewInfo selectReview(Connection con, String videoId) {
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		ReviewInfo rv=null;
		try {
			pstmt=con.prepareStatement(prop.getProperty("selectReview"));
			pstmt.setString(1, videoId);
			rset=pstmt.executeQuery();
			if(rset.next()){
				rv=new ReviewInfo();
				rv.setVideoid(rset.getString(1));
				rv.setMcode(rset.getString(2));
				rv.setRvrcode(rset.getString(3));
				rv.setUploaddate(rset.getDate(4));
				rv.setCounts(rset.getInt(5));
				rv.setRname(rset.getString(6));
				rv.setProfile(rset.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}
		return rv;
		
	}
//조회수 높은 리뷰
	public ArrayList<Review> reviewTop(Connection con) {
		// TODO Auto-generated method stub
		return null;
	}


}
