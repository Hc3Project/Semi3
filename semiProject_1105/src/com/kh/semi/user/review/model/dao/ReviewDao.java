package com.kh.semi.user.review.model.dao;

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

import com.kh.semi.user.review.model.vo.Review;
import com.kh.semi.user.review.model.vo.ReviewInfo;

public class ReviewDao {
	private Properties prop = new Properties();

	public ReviewDao() {
		String filePath = ReviewDao.class.getResource("/config/review-query.properties").getPath().replace("%20", " ");

		try {
			prop.load(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public ArrayList<Review> review(Connection con, String rsql) {
		ArrayList<Review> list = null;
		Statement stmt = null;
		ResultSet rset = null;


		try {

			stmt = con.createStatement();
			rset = stmt.executeQuery(prop.getProperty(rsql));
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
	

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return list;
	}

	public ArrayList<Review> review(Connection con, String rsql, String mTitle) {
		ArrayList<Review> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;


		try {
		
			pstmt = con.prepareStatement(prop.getProperty(rsql));
			pstmt.setString(1, mTitle);
			rset = pstmt.executeQuery();
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
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public ReviewInfo selectReview(Connection con, String videoId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ReviewInfo rv = null;
		try {
			pstmt = con.prepareStatement(prop.getProperty("selectReview"));
			pstmt.setString(1, videoId);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				rv = new ReviewInfo();
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
		} finally {
			close(rset);
			close(pstmt);
		}
		return rv;

	}

	public void reviewCount(Connection con, String videoId) {
		PreparedStatement pstmt =null;
		
		
		try {
			pstmt= con.prepareStatement(prop.getProperty("reviewCount"));
			pstmt.setString(1, videoId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
	}

	public int reviewVisit(Connection con, String videoId, String userId) {
		
		PreparedStatement pstmt =null;
		int result =0;
		
		try {
			pstmt= con.prepareStatement(prop.getProperty("reviewVisit"));
			pstmt.setString(1, videoId);
			pstmt.setString(2, userId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}

		return result;
	}

	public ArrayList<Review> rvrReviewList(Connection con, String rsql, String rvrCode) {
		ArrayList<Review> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
		
			pstmt = con.prepareStatement(prop.getProperty(rsql));
			pstmt.setString(1, rvrCode);
			
			rset = pstmt.executeQuery();
			list = new ArrayList<Review>();
			
			Review review = null;

			while (rset.next()) {
				review = new Review();
				/*
				 * VIDEOID MCODE RVRCODE UPLOADDATE COUNTS
				 */
				
				review.setVideoid(rset.getString("VIDEOID"));
				review.setMovie(rset.getString("MTITLE"));

				list.add(review);
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}public ArrayList<Review> rvrReviewAll(Connection con, String rsql, String rvrCode,int page) {
		ArrayList<Review> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		
		try {
		
			pstmt = con.prepareStatement(prop.getProperty(rsql));
			pstmt.setString(1, rvrCode);
			pstmt.setInt(2, page);
			pstmt.setInt(3, page);
			
			rset = pstmt.executeQuery();
			list = new ArrayList<Review>();
			
			Review review = null;

			while (rset.next()) {
				review = new Review();
				/*
				 * VIDEOID MCODE RVRCODE UPLOADDATE COUNTS
				 */
				
				review.setVideoid(rset.getString("VIDEOID"));
				review.setMovie(rset.getString("MTITLE"));

				list.add(review);
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public List<Review> rvSameGenre(Connection con, String mCode) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Review> result = null;
		String sql = prop.getProperty("rvSameGenre");
		try {
			result = new ArrayList<Review>();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mCode);
			rset = pstmt.executeQuery();
			
			int i = 0;
			while(rset.next()){
				Review rv = new Review();
				rv.setVideoid(rset.getString("videoid"));
				rv.setMovie(rset.getString("mtitle"));
				rv.setReviewer(rset.getString("rname"));

				result.add(rv);
				if(++i>23) break;
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
