package com.kh.semi.common;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import com.kh.semi.exception.DetailViewException;
import com.kh.semi.user.movie.model.service.MovieService;

public class MovieImg {

	public String moviewImg(String keyword) throws DetailViewException,Exception {
		MovieService dvs = new MovieService();
		String page = "";
		
	
		// 불러온 정보를 이용해 네이버API로 포스터 클로링
		String clientId = "f1lI5BaAwEDWvf6UPMiK";
		String clientSecret = "flUGLrhsdJ";

		String apiURL = "https://openapi.naver.com/v1/search/movie.json?query=" + URLEncoder.encode(keyword, "utf-8");

		URL url = new URL(apiURL);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		System.out.println(url);
		con.setRequestMethod("GET");
		con.setRequestProperty("X-Naver-Client-Id", clientId);
		con.setRequestProperty("X-Naver-Client-Secret", clientSecret);

		int responseCode = con.getResponseCode();

		BufferedReader br = null;

		if (responseCode == 200)
			br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		else
			br = new BufferedReader(new InputStreamReader(con.getErrorStream()));

		String inStr = "";
		StringBuffer sb = new StringBuffer();
		while ((inStr = br.readLine()) != null)
			sb.append(inStr);
		String result = sb.toString();

		br.close();

		if (result.substring(61, 62).equals("1") && !chkNum(result.substring(62, 63)))
			page = dvs.getImage(result);
		else
			page = dvs.getPowerImage(result, keyword);
		
		return page;
	}
	private boolean chkNum(String s) {
		// 숫자인지 아닌지 구별
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	

}
