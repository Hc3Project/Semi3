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

	public String getImage(String result,String mCode) throws Exception {
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

	public String getPowerImage(String result, String keyword,String mCode) throws Exception {
		Connection con = getConnection();
		// 여러 결과 중 맞는 내용을 찾기 위해 데이터베이스에서 정보 뽑아오기 (받아오는 정보가 늘어나면 쿼리수정해야함)
		List<PosterInfo> list = new MovieDao().getPowerImage(con, result, keyword,mCode);
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

			chk=findCode(result,director,date,sentence);
			System.out.println("1차 check : "+chk);
			if(chk==null||chk.length()<1) {
				date=String.valueOf((Integer.parseInt(date)-1));
				System.out.println("2차 date : "+date);
				chk=findCode(result,director,date,sentence);
				System.out.println("2차 check : "+chk);
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

	public ArrayList<MovieInfo> visitMovie(String userId,int page) {
		 ArrayList<MovieInfo> list = new ArrayList<MovieInfo>();
		 Connection con =getConnection();
		 list = new MovieDao().visitMovie(con,userId,page);
		 
		 close(con);
		 
		return list;
	}
	
	public String findCode(String result, String director, String date, List<String> sentence){
		for (int i = 3; i < sentence.size(); i++) {
				if (sentence.get(i).matches(".*" + director + ".*")
						&& sentence.get(i - 1).matches(".*" + date + ".*")) {
					System.out.println("감날");
					return sentence.get(i - 4);
				}

			}
		for(int i=3;i<sentence.size();i++){
			if (sentence.get(i).matches(".*" + director + ".*")) {
				System.out.println("감");
					return sentence.get(i - 4);
				
			}
		}
		for(int i=3;i<sentence.size();i++){
			if (sentence.get(i-1).matches(".*" + date + ".*")) {
				System.out.println("날");
					return sentence.get(i - 4);
				
			}
		}
		return "";

		}
		
		

}

/*
{"lastBuildDate": "Mon, 19 Nov 2018 09:37:47 +0900","total": 1
0,"start": 1,"display": 10,"items": [{"title": "<b>유전</b>","link": 
"https://movie.naver.com/movie/bi/mi/basic.nhn?code=172420","image": "htt
ps://ssl.pstatic.net/imgmovie/mdi/mit110/1724/172420_P11_102917.jpg","subtitle":
 "Hereditary","pubDate": "2017","director": "아리 에스터|","actor": "토니 콜렛|가브
 리엘 번|알렉스 울프|밀리 샤피로|","userRating": "7.11"},{"title": "<b>유전</b>자 과일
 ","link": "https://movie.naver.com/movie/bi/mi/basic.nhn?code=165662","imag
 e": "https://ssl.pstatic.net/imgmovie/mdi/mit110/1656/165662_P01_111704.jpg"
 ,"subtitle": "Who Stole FIFI's Fruit-eating Gene?","pubDate": "2016","director
 ": "창 자이안|","actor": "","userRating": "0.00"},{"title": "취향의 <b>유전</b>","li
 nk": "https://movie.naver.com/movie/bi/mi/basic.nhn?code=54454","image": "https
 ://ssl.pstatic.net/imgmovie/mdi/mit110/0544/54454_P00_104643.jpg","subtitle": "Here
 dity Of Taste","pubDate": "2009","director": "김진영|","actor": "나은선|이새별|김훈만|","us
 erRating": "10.00"},{"title": "지리산 제3부 <b>유전</b> 자원의 보고, 왕등재 습지","link": "https
 ://movie.naver.com/movie/bi/mi/basic.nhn?code=53228","image": "https://ssl.pstatic.n
 et/imgmovie/mdi/mit110/0532/53228_P00_164630.jpg","subtitle": "Jirisan-Highland Swamp
 land, Treasury Of Genetic Resources","pubDate": "2008","director": "배상효|","actor":
  "","userRating": "0.00"},{"title": "기분 나쁜 <b>유전</b>자","link": "https://movie.naver.c
  om/movie/bi/mi/basic.nhn?code=68300","image": "","subtitle": "不機嫌なジ?ン","pubDate":
   "2005","director": "사와다 켄사쿠|히라이 히데키|","actor": "다케우치 유코|우치노 마사아키|","userRa
   ting": "8.00"},{"title": "핑크빛 <b>유전</b>자","link": "https://movie.naver.com/movie/bi
   /mi/basic.nhn?code=47610","image": "","subtitle": "Pinkの遺傳子","pubDate": "2005","di
    * rector": "쿠사노 요카|","actor": "콘노 나루미|나카도이 히로키|사카모토 마코토|","userRating": "0.
    * 00"},{"title": "X 파일 - TV시리즈","link": "https://movie.naver.com/movie/bi/mi/basi
    * c.nhn?code=17984","image": "https://ssl.pstatic.net/imgmovie/mdi/mit110/0179/A7984-
    * 01.jpg","subtitle": "The X-Files","pubDate": "1993","director": "클리프 볼|롭 보우먼|크리스 카터|짐 찰스튼|제임스 A. 콘트너|앨런 콜터|데이비드 듀코브니|제롤드 프리드먼|터커 게이츠|프레드 거버|R.W. 굿윈|윌리암 A 그라함|랠프 헤메커|마이클 카틀러먼|마이클 랭|로버트 라이버먼|해리 롱스트리트|로버트 맨델|킴 매너스|닉 마크|피터 마클|조 나폴리타노|데이빗 너터|윈 펠프스|다니엘 색하임|래리 쇼우|브라이언 스파이서|스티븐 서직|마이클 베자|마이클 W. 앳킨스|제임스 위트모어 주니어|황예유|토머스 J. 라이트|","actor": "데이비드 듀코브니|질리언 앤더슨|","userRating": "9.58"},{"title": "오클라호마 <b>유전</b>","link": "https://movie.naver.com/movie/bi/mi/basic.nhn?code=10461","image": "","subtitle": "Oklahoma Crude","pubDate": "1973","director": "스탠리 크레이머|","actor": "조지 C. 스콧|페이 더너웨이|존 밀스|잭 팰런스|","userRating": "0.00"},{"title": "<b>유전</b>의 애수","link": "https://movie.naver.com/movie/bi/mi/basic.nhn?code=22574","image": "","subtitle": "","pubDate": "1956","director": "유현목|","actor": "최무룡|백성희|문정숙|최남현|","userRating": "0.00"},{"title": "천국의 아이들","link": "https://movie.naver.com/movie/bi/mi/basic.nhn?code=20336","image": "https://ssl.pstatic.net/imgmovie/mdi/mit110/0203/B0336-01.jpg","subtitle": "Children Of Paradise","pubDate": "1945","director": "마르셀 까르네|","actor": "아를레티|쟝 루이스 바롤트|피에르 브라소|피에르 르누아르|","userRating": "9.14"}]}
{"lastBuildDate": "Mon, 19 Nov 2018 10:
3:26 +0900","total": 36,"start": 1,"display": 10,"items": [{
"title": "<b>그것</b>: 챕터 2","link": "https://movie.naver.com/movie/
bi/mi/basic.nhn?code=167560","image": "","subtitle": "It: Chapter Two","
pubDate": "2018","director": "안드레스 무시에티|","actor": "빌 스카스가드
|제임스 맥어보이|","userRating": "8.96"},{"title": "<b>그것</b>이 <b>그것</b>이 온다면
","link": "https://movie.naver.com/movie/bi/mi/basic.nhn?code=172183","image": 
"","subtitle": "それ それがやって&amp;#26469;たら","pubDate": "2018","director": "오키타
 히카루|","actor": "히라마츠 카나코|","userRating": "0.00"},{"title": "<b>그것</b>만이 내
  세상","link": "https://movie.naver.com/movie/bi/mi/basic.nhn?code=158180","image": "h
  ttps://ssl.pstatic.net/imgmovie/mdi/mit110/1581/158180_P104_110500.jpg","subtitle": 
  "Keys to the Heart","pubDate": "2017","director": "최성현|","actor": "이병헌|윤여정|박정민|"
  ,"userRating": "8.91"},{"title": "<b>그것</b>","link": "https://movie.naver.com/mov
  ie/bi/mi/basic.nhn?code=154668","image": "https://ssl.pstatic.net/imgmovie/mdi/mit
  110/1546/154668_P07_101413.jpg","subtitle": "It","pubDate": "2017","direc
  tor": "안드레스 무시에티|","actor": "빌 스카스가드|제이든 리버허|","userRating": "6.96"},{"title": "<b>그것</b>: 광대의 저주","link": "https://movie.naver.com/movie/bi/mi/basic.nhn?code=166501","image": "https://ssl.pstatic.net/imgmovie/mdi/mit110/1665/166501_P01_145248.jpg","subtitle": "Clowntergeist","pubDate": "2017","director": "아론 미르테스|","actor": "아론 미르테스|버트 컬버|","userRating": "3.86"},{"title": "우리동네 기부짱!! <b>그것</b>이 알고싶다.","link": "https://movie.naver.com/movie/bi/mi/basic.nhn?code=169953","image": "","subtitle": "","pubDate": "2017","director": "조민지|","actor": "","userRating": "0.00"},{"title": "아내의 욕망:거대한 <b>그것</b>","link": "https://movie.naver.com/movie/bi/mi/basic.nhn?code=166151","image": "https://ssl.pstatic.net/imgmovie/mdi/mit110/1661/166151_P01_141604.jpg","subtitle": "dameoyaji","pubDate": "2016","director": "토미죠 타로|","actor": "","userRating": "0.00"},{"title": "<b>그것</b>이 알고싶다, 싸우는 모녀","link": "https://movie.naver.com/movie/bi/mi/basic.nhn?code=154760","image": "https://ssl.pstatic.net/imgmovie/mdi/mit110/1547/154760_P01_141526.jpg","subtitle": "Matter of Course","pubDate": "2016","director": "전혜진|","actor": "","userRating": "0.00"},{"title": "여자는 <b>그것</b>을 용서하지 않아","link": "https://movie.naver.com/movie/bi/mi/basic.nhn?code=129206","image": "https://ssl.pstatic.net/imgmovie/mdi/mit110/1292/129206_P01_101935.jpg","subtitle": "女はそれを許さない","pubDate": "2014","director": "쿠마자와 나오토|타케무라 켄타로|","actor": "후카다 쿄코|테라지마 시노부|미조바타 준페이|요시자와 히사시|가토 마사야|다케나카 나오토|마츠시게 유타카|카미카와 타카야|","userRating": "0.00"},{"title": "당신이 원하는 <b>그것</b>","link": "https://movie.naver.com/movie/bi/mi/basic.nhn?code=115714","image": "https://ssl.pstatic.net/imgmovie/mdi/mit110/1157/115714_P05_165555.jpg","subtitle": "That Thing You Love","pubDate": "2013","director": "알바로 벨라르데|","actor": "카를로스 벨로소|엘레나 로메로|","userRating": "8.00"}]}


*/
