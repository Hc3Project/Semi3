package com.kh.semi.user.review.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.semi.user.movie.model.vo.ReviewInfo;
import com.kh.semi.user.review.model.vo.Review;
import static com.kh.semi.common.JDBCTemplate.*;

public class ReviewDao {
	private Properties prop = new Properties();

	public ReviewDao() {
		String filePath = ReviewDao.class.getResource("/config/review-query.properties").getPath();
		try {
			prop.load(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
System.out.println(sql);
			Review review = null;

			while (rset.next()) {
				review = new Review();
				/*
				 * VIDEOID MCODE RVRCODE UPLOADDATE COUNTS
				 */
				review.setVideoid(rset.getString("VIDEOID"));
				review.setMcode(rset.getString("MCODE"));
				review.setRvrcode(rset.getString("RVRCODE"));
				review.setUploaddate(rset.getDate("UPLOADDATE"));
				review.setCounts(rset.getInt("COUNTS"));
				System.out.println(review);

				list.add(review);
				System.out.println(list.size());
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
	public ArrayList<Review> reviewRecommend(Connection con) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ReviewInfo selectReview(Connection con, String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Review> reviewTop(Connection con) {
		// TODO Auto-generated method stub
		return null;
	}


}
