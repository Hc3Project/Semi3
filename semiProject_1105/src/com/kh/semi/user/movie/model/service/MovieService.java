package com.kh.semi.user.movie.model.service;

import static com.kh.semi.common.JDBCTemplate.close;
import static com.kh.semi.common.JDBCTemplate.commit;
import static com.kh.semi.common.JDBCTemplate.getConnection;
import static com.kh.semi.common.JDBCTemplate.rollback;

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

	public String getImage(String result) throws Exception {
		String code = "";
		String chk = "";
		List<String> sentence = new ArrayList<>(Arrays.asList(result.split(",")));

		// 결과에서 코드가 있는 컬럼을 따옴
		for (int i = 0; i < sentence.size(); i++) {
			if (sentence.get(i).matches(".*link.*")) {
				chk = sentence.get(i);
				break;
			}
		}

		// 코드를 판별해 가져옴
		Matcher mc = Pattern.compile("[0-9]{5,6}").matcher(chk);
		if (mc.find())
			code = mc.group();
		else
			throw new DetailViewException("상세보기 실패!");

		// 코드를 통해 포스터 페이지에 접속해 크롤링
		Document doc = Jsoup.connect(page + code).header("User-Agent", "Chrome/70.0.3538.77").get();
		Elements img = doc.select("img[src~=.(png|jpe?g)]");
		String imgURL = "";
		for (Element el : img)
			imgURL = String.valueOf(el).substring(27, 110);

		return imgURL;

	}

	public String getPowerImage(String result, String keyword) throws Exception {
		Connection con = getConnection();
		// 여러 결과 중 맞는 내용을 찾기 위해 데이터베이스에서 정보 뽑아오기 (받아오는 정보가 늘어나면 쿼리수정해야함)
		List<PosterInfo> list = new MovieDao().getPowerImage(con, result, keyword);
		close(con);
		String code = "";

		// 맞는 결과를 판별해 코드를 가져오기
		for (PosterInfo pi : list) {
			String director = pi.getDirector();
			String date = pi.getOpendate().toString().substring(0, 4);
			
			System.out.println("감독 : "+director);
			System.out.println("날짜 : "+date);
			
			List<String> sentence = new ArrayList<>(Arrays.asList(result.split(",")));
			String chk = "";

			if (result.matches(".*" + director + ".*") && result.matches(".*" + date + ".*")) {
				
				for (int i = 1; i < sentence.size(); i++) {
					if (sentence.get(i).matches(".*" + director + ".*")
							&& sentence.get(i - 1).matches(".*" + date + ".*")) {
						chk = sentence.get(i - 4);
						break;
					}
				}

				

			}else if(result.matches(".*" + director + ".*")){
				
				for (int i = 1; i < sentence.size(); i++) {
					if (sentence.get(i).matches(".*" + director + ".*")) {
						chk = sentence.get(i - 4);
						break;
					}
				}

				
			}else if(result.matches(".*" + date + ".*")){
				
				for (int i = 1; i < sentence.size(); i++) {
					if (sentence.get(i).matches(".*" + date + ".*")) {
						chk = sentence.get(i - 4);
						break;
					}
				}
			}
			
			Matcher mc = Pattern.compile("[0-9]{5,6}").matcher(chk);

			if (mc.find())
				code = mc.group();
			else
				throw new DetailViewException("상세보기 실패!");

		}
		
		System.out.println("코드 : "+code);

		// 코드를 통해 포스터 페이지에 접속해 크롤링
		Document doc = Jsoup.connect(page + code).header("User-Agent", "Chrome/70.0.3538.77").get();
		Elements img = doc.select("img[src~=.(png|jpe?g)]");
		String imgURL = "";
		for (Element el : img) {
			imgURL = String.valueOf(el);
			imgURL = imgURL.substring(27, 110);
			System.out.println(imgURL);
		}
		
		System.out.println("주소 : "+imgURL);
		return imgURL;

	}

	public MovieDetailInfo selectMovieDetail(String mCode, String userId) throws Exception {
		Connection con = getConnection();
		MovieDetailInfo mov = new MovieDao().selectMovieDetail(con, mCode);

		int resultV = 0;
		int resultC = 0;

		if (mov == null) {
			throw new DetailViewException("상세보기 실패!");
		}
		// 게시물 조회 기록
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

	public ArrayList<MovieInfo> visitMovie(String userId) {
		 ArrayList<MovieInfo> list = new ArrayList<MovieInfo>();
		 Connection con =getConnection();
		 list = new MovieDao().visitMovie(con,userId);
		 
		 close(con);
		 
		return list;
	}

}
