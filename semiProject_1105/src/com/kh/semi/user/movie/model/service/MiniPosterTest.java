package com.kh.semi.user.movie.model.service;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class MiniPosterTest {
	
	public void poster(){
		try {
			Document doc = Jsoup.connect("https://movie.naver.com/movie/bi/mi/basic.nhn?code=156464")
					.header("User-Agent", "Chrome/70.0.3538.77").get();
			System.out.println(doc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
