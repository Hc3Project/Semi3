package com.kh.semi.user.detail.model.dao;

import static com.kh.semi.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.semi.user.detail.model.vo.PosterInfo;

public class DetailViewDao {
	
	private Properties prop = new Properties();
	
	public DetailViewDao(){
		String filePath = DetailViewDao.class.getResource("/config/view-query.properties").getPath();
		try {
			prop.load(new FileReader(filePath));
		} catch (IOException e) {
		}
	}

	public List<PosterInfo> getPowerImage(Connection con, String result, String keyword) {
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		List<PosterInfo> list=null;
		String sql=prop.getProperty("findCorrectMovie");
		System.out.println("쿠어리 : "+sql);
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, keyword);
			rset=pstmt.executeQuery();
			list=new ArrayList<>();
			while(rset.next()){
				PosterInfo pi=new PosterInfo();
				pi.setDirector(rset.getString(1));
				pi.setOpendate(rset.getDate(2));
				list.add(pi);
			}
		} catch (SQLException e) {
		}finally{
			close(rset);
			close(pstmt);
		}
		return list;
	}

}
