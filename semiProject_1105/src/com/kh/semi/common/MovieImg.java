package com.kh.semi.common;

import com.kh.semi.exception.DetailViewException;
import com.kh.semi.user.movie.model.service.MovieService;

public class MovieImg {

	public String moviewImg(String keyword,String mCode) throws DetailViewException,Exception {
		
		String result=new PosterAPI().getPosterResult(keyword);
		
		MovieService dvs = new MovieService();
		String page = "";
		
		if (result.substring(61, 62).equals("1") && !chkNum(result.substring(62, 63)))
			page = dvs.getImage(result,mCode);
		else
			page = dvs.getPowerImage(result, keyword,mCode);
		
		return page;
	}
	
	private boolean chkNum(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	

}
