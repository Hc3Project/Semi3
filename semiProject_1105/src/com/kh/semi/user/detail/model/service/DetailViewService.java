package com.kh.semi.user.detail.model.service;

import java.sql.Connection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.kh.semi.common.JDBCTemplate.*;

public class DetailViewService {
	
	private static String page="https://movie.naver.com/movie/bi/mi/photoViewPopup.nhn?movieCode=";

	public String getImage(String result) throws Exception {
		// DOM(문서 객체 모델) 형식 문서를 담을 Document 클래스의 객체 doc
		Document doc = null;

		// DOM 방식이라 한 페이지를 다 가져옴
		// System.out.println(doc);

		int idx = result.indexOf("=");

		String code = "";
		if (chkNum(result.substring(idx + 6, idx + 7))) {
			code = result.substring(idx + 1, idx + 7);
		} else {
			code = result.substring(idx + 1, idx + 6);
		}
		System.out.println("최종 코드 : " + code);

		String address = page + code;
		System.out.println(address);
		// Jsoup.connect("연결할 주소").header("User-Agent", "사용자의 브라우저 정보").get();
		// <-get방식(post는 post();)
		doc = Jsoup.connect(address).header("User-Agent", "Chrome/70.0.3538.77").get();
		Elements img = doc.select("img[src~=.(png|jpe?g)]");
		String s = "";
		for (Element el : img) {
			s = String.valueOf(el);
			s = s.substring(27, 110);
			System.out.println(s);
		}

		return s;

		// <!doctype html>
		// <html lang="ko">
		// <head>
		// <meta charset="utf-8">
		// <meta http-equiv="X-UA-Compatible" content="IE=edge">
		// <meta http-equiv="imagetoolbar" content="no">
		// <title>네이버 영화</title>
		// <link rel="shortcut icon"
		// href="https://ssl.pstatic.net/static/m/movie/icons/naver_movie_favicon.ico"
		// type="image/x-icon">
		// <style type="text/css">
		// body {margin:0; padding:0;}
		// </style>
		// <script type="text/javascript"
		// src="/js/deploy/movie.all.js?20181031144347"></script>
		// </head>
		// <body>
		// <div id="page_content" style="position:absolute; left:0; top:0;">
		// <a href="#" onclick="self.close();"><img id="targetImage"
		// src="https://movie-phinf.pstatic.net/20111222_69/1324541836762R8tql_JPEG/movie_image.jpg"
		// alt="가타카"></a>
		// </div>
		// <script type="text/javascript" src="/js/popUpResize.js"></script>
		// <script type="text/javascript">
		//
		// jindo.$Fn(function() {
		// resizeToPopupContent();
		// }).attach(window, "load");
		//
		// </script>
		// <script type="text/javascript">
		// try{ lcs_do(); } catch(e){}
		//
		// //nClick 초기화 영역
		// //클릭로그 집계 코드 추가
		// var ccsrv="cc.naver.com";
		// var nclk_evt = 1;
		//
		// nclk_do();
		// //nClick 초기화 영역 끝
		//
		// </script>
		// </body>
		// </html>

		// String h1=doc.select("h1").text(); // h1태그의 내용만을 추출
		// String h2=doc.select("h2").eq(1).text(); // 1번째 인덱스에 위치한 h2태그의 내용만을
		// 추출
		// Elements contents=doc.select("p"); // p태그의 내용은 여러개이기 때문에 Elements 객체에
		// 우선 담는다
		//
		// System.out.println(h1);
		// System.out.println(h2);
		//
		// // 라인이 몇째줄인지
		// int idx=0;
		// for(Element element:contents){
		// if(0<idx&&idx<5){
		// // p태그의 내용만을 추출하기 위해 text사용
		// System.out.println(element.text());
		// }
		// idx++;
		//
		// }
	}

	private boolean chkNum(String substring) {
		boolean result = false;
		try {
			Integer.parseInt(substring);
			result = true;
			return result;
		} catch (NumberFormatException e) {
			return result;
		}
	}

}
