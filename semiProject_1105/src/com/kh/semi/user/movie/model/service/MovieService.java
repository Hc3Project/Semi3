package com.kh.semi.user.movie.model.service;

import static com.kh.semi.common.JDBCTemplate.close;
import static com.kh.semi.common.JDBCTemplate.commit;
import static com.kh.semi.common.JDBCTemplate.getConnection;
import static com.kh.semi.common.JDBCTemplate.rollback;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.kh.semi.exception.DetailViewException;
import com.kh.semi.manager.video.model.vo.MovieInfo;
import com.kh.semi.user.movie.model.dao.MovieDao;
import com.kh.semi.user.movie.model.vo.MovieDetailInfo;
import com.kh.semi.user.movie.model.vo.PosterInfo;

public class MovieService {

	private static String page = "https://movie.naver.com/movie/bi/mi/photoViewPopup.nhn?movieCode=";
	private static String smallpage= "https://movie.naver.com/movie/bi/mi/basic.nhn?code=";

	public String getImage(String result,String mCode) throws Exception {
		String code=singleCode(result);

		Document doc = Jsoup.connect(page + code).header("User-Agent", "Chrome/70.0.3538.77").get();
		Elements img = doc.select("img[src~=.(png|jpe?g)]");
		String imgURL = "";
		for (Element el : img){
			imgURL = String.valueOf(el).substring(27, 110);
			if(imgURL.endsWith("p")) imgURL+="g";
		}

		return imgURL;

	}

	public String getPowerImage(String result, String keyword,String mCode) throws Exception {
		String code=multiCode(result,keyword,mCode);
		
		Document doc = Jsoup.connect(page + code).header("User-Agent", "Chrome/70.0.3538.77").get();
		Elements img = doc.select("img[src~=.(png|jpe?g)]");
		String imgURL = "";
		for (Element el : img) {
			imgURL = String.valueOf(el).substring(27, 110);
			if(imgURL.endsWith("p")) imgURL+="g";
		}
		
		return imgURL;

	}

	public MovieDetailInfo selectMovieDetail(String mCode, String userId) throws Exception {
		Connection con = getConnection();
		MovieDetailInfo mov = new MovieDao().selectMovieDetail(con, mCode);

		int resultV = 0;
		int resultC = 0;

		if (mov == null) {
			throw new DetailViewException("리뷰 페이지를 가져오는데 문제가 발생했습니다!");
		}

		if (userId != null) {
			resultV = new MovieDao().MovieVisit(con, mCode, userId);
			if (resultV > 0)
				commit(con);
			else
				rollback(con);
		}
		resultC = new MovieDao().MovieCount(con, mCode);
		if (resultC > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return mov;
	}

	public ArrayList<MovieInfo> visitMovie(String userId,int page) {
		 Connection con =getConnection();
		 ArrayList<MovieInfo> list = new MovieDao().visitMovie(con,userId,page);
		 
		 close(con);
		 
		return list;
	}
	public ArrayList<MovieInfo> evalMovie(String userId,int page) {
		 ArrayList<MovieInfo> list = new ArrayList<MovieInfo>();
		 Connection con =getConnection();
		 list = new MovieDao().evalMovie(con,userId,page);
		 
		 close(con);
		 
		return list;
	}
	
	public String findCode(String result, String director, String date, List<String> sentence){
		for (int i = 3; i < sentence.size(); i++) {
				if (sentence.get(i).matches(".*" + director + ".*")
						&& sentence.get(i - 1).matches(".*" + date + ".*")) {
					return sentence.get(i - 4);
				}

			}
		for(int i=3;i<sentence.size();i++){
			if (sentence.get(i).matches(".*" + director + ".*")) {
					return sentence.get(i - 4);
				
			}
		}
		for(int i=3;i<sentence.size();i++){
			if (sentence.get(i-1).matches(".*" + date + ".*")) {
					return sentence.get(i - 4);
				
			}
		}
		return "";

		}

	public String getSmallImage(String result, String mCode) throws Exception {
		String code=singleCode(result);
		
		Document doc = Jsoup.connect(smallpage+code).header("User-Agent", "Chrome/70.0.3538.77").get();
		
		Elements img = doc.select("div.poster a img[src*=.jpg?type=m2]");
		String imgURL = "";
		for (Element el : img) {

			
			String url=String.valueOf(el);
			int endIdx=url.indexOf("alt");
			
			imgURL=url.substring(10, endIdx-2);

		}
		return imgURL;
		
	}

	public String getPowerSmallImage(String result, String keyword, String mCode) throws Exception{
		
		String code=multiCode(result,keyword,mCode);
		
		Document doc = Jsoup.connect(smallpage+code).header("User-Agent", "Chrome/70.0.3538.77").get();
		
		Elements img = doc.select("div.poster a img[src*=.jpg?type=m2]");
		String imgURL = "";
		for (Element el : img) {
			String url=String.valueOf(el);
			int endIdx=url.indexOf("alt");
			imgURL=url.substring(10, endIdx-2);
		}
		return imgURL;
		
	}
	
	public String singleCode(String result) throws Exception{
		String code = "";
		String chk = "";
		List<String> sentence = new ArrayList<>(Arrays.asList(result.split(",")));

		for (int i = 0; i < sentence.size(); i++) {
			if (sentence.get(i).matches(".*link.*")) {
				chk = sentence.get(i);
				break;
			}
		}

		Matcher mc = Pattern.compile("[0-9]{5,6}").matcher(chk);
		if (mc.find()){
			code = mc.group();
			return code;
		}
		else
			throw new DetailViewException("리뷰 페이지를 가져오는데 문제가 발생했습니다!");
	}
		
	public String multiCode(String result,String keyword,String mCode) throws Exception{
		Connection con = getConnection();

		List<PosterInfo> list = new MovieDao().getPowerImage(con, result, keyword,mCode);
		close(con);
		String code = "";

		for (PosterInfo pi : list) {
			String director = pi.getDirector();
			String date = pi.getOpendate().toString().substring(0, 4);
			
			List<String> sentence = new ArrayList<>(Arrays.asList(result.split(",")));
			String chk = "";

			chk=findCode(result,director,date,sentence);
			if(chk==null||chk.length()<1) {
				date=String.valueOf((Integer.parseInt(date)-1));
				chk=findCode(result,director,date,sentence);
			}
			
			
			Matcher mc = Pattern.compile("[0-9]{5,6}").matcher(chk);

			if (mc.find()){
				code = mc.group();
			}
			else
			{	
				throw new DetailViewException("리뷰 페이지를 가져오는데 문제가 발생했습니다!");
			}
			
		}
		
		return code;
	}

	public String getSyno(String result, String mCode) throws Exception {
		String code=singleCode(result);
		
		Document doc = Jsoup.connect(smallpage+code).header("User-Agent", "Chrome/70.0.3538.77").get();
			
		String syno = doc.select("p.con_tx").text();
		
		System.out.println(syno);
		
		return syno;
	}

	public String getPowerSyno(String result, String mTitle, String mCode) throws Exception {
		String code=multiCode(result,mTitle,mCode);
		
		Document doc = Jsoup.connect(smallpage+code).header("User-Agent", "Chrome/70.0.3538.77").get();
		
		String syno = doc.select("p.con_tx").text();
		
		System.out.println(syno);
		
		return syno;
	}

}