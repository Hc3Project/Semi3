package com.kh.semi.user.detail.contoller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.user.detail.model.service.DetailViewService;
import com.kh.semi.user.detail.model.vo.MovieInfo;



/**
 * Servlet implementation class DetailViewServlet
 */
@WebServlet("/gPoster.do")
public class DetailViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("txt");
//		String keyword = "iron";
		System.out.println(keyword);
		String saveKey=keyword;
		System.out.println(URLEncoder.encode(keyword, "utf-8"));
		
		String clientId = "f1lI5BaAwEDWvf6UPMiK";
		String clientSecret = "flUGLrhsdJ";
		
		try {
			String apiURL = "https://openapi.naver.com/v1/search/movie.json?query=" + URLEncoder.encode(keyword, "utf-8");
			
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();

			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
//			con.setRequestProperty("query", keyword);
//			System.out.println(con.toString());

			int responseCode = con.getResponseCode();

			BufferedReader br = null;

			if(responseCode == 200) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}

			String inStr = "";
			StringBuffer sb = new StringBuffer();
			while((inStr=br.readLine())!=null) {
				sb.append(inStr);
			}
			String result=sb.toString();
			System.out.println(result);
			
//			{"lastBuildDate": "Mon, 05 Nov 2018 18:42:00 +0900",
//				"total": 1,"start": 1,"display": 1,
//				"items": [{"title": "<b>가타카</b>",
//					"link": "https://movie.naver.com/movie/bi/mi/basic.nhn?code=19074",
//					"image": "https://ssl.pstatic.net/imgmovie/mdi/mit110/0190/A9074-00.jpg",
//					"subtitle": "Gattaca","pubDate": "1997",
//					"director": "앤드류 니콜|","actor": "에단 호크|우마 서먼|","userRating": "9.23"}]}
			
			
			
			String page="";
			DetailViewService dvs=new DetailViewService();
			
			if(result.substring(61,62).equals("1")&&!chkNum(result.substring(62,63))){
				// 결과가 하나밖에 안나오는 경우
				System.out.println("검색 결과가 단 한 개");
				
				
				page=dvs.getImage(result);
				
			}else{
				// 결과가 여러개 나오는 경우
				System.out.println("검색 결과가 둘 이상");
				
				page=dvs.getPowerImage(result,saveKey);
				
			}
			
			
			br.close();
			
			System.out.println("값 넘어가냐? : "+page);
			
			MovieInfo mov=dvs.selectMovieDetail(saveKey);
			
			if(page!=null&&page.length()>0&&mov!=null){
				request.setAttribute("page",page);
				request.setAttribute("mov", mov);
				
				request.getRequestDispatcher("views/detail/DetailView3.jsp").forward(request, response);
			}else{
				request.setAttribute("msg", "영화 정보를 불러오는 중 문제가 발생");
				
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private boolean chkNum(String s) {
		boolean result = false;
		try {
			Integer.parseInt(s);
			result = true;
			return result;
		} catch (NumberFormatException e) {
			return result;
		}
	}

}
