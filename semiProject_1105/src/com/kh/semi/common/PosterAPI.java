package com.kh.semi.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;


public class PosterAPI {
	
	public String getPosterResult(String keyword) throws MalformedURLException, IOException{
		
		
		String clientId = "f1lI5BaAwEDWvf6UPMiK";
		String clientSecret = "flUGLrhsdJ";

		String apiURL = "https://openapi.naver.com/v1/search/movie.json?query=" + URLEncoder.encode(keyword, "utf-8");

		HttpURLConnection con = (HttpURLConnection) new URL(apiURL).openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("X-Naver-Client-Id", clientId);
		con.setRequestProperty("X-Naver-Client-Secret", clientSecret);

		BufferedReader br = null;

		if (con.getResponseCode() == 200)
			br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		else
			br = new BufferedReader(new InputStreamReader(con.getErrorStream()));

		String inStr = "";
		StringBuffer sb = new StringBuffer();
		while ((inStr = br.readLine()) != null) sb.append(inStr);
		String result = sb.toString();
		
		br.close();
		return result;
	}
}
