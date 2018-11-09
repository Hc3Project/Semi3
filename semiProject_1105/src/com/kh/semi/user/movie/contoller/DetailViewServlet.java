package com.kh.semi.user.movie.contoller;

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

import com.kh.semi.user.movie.model.service.DetailViewService;
import com.kh.semi.user.movie.model.vo.MovieDetailInfo;
import com.kh.semi.user.movie.model.vo.ReviewInfo;
import com.kh.semi.user.review.model.service.ReviewService;



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
		// api에 검색한 내용
		String keyword = request.getParameter("txt");
		
		String clientId = "f1lI5BaAwEDWvf6UPMiK";
		String clientSecret = "flUGLrhsdJ";
		
		try {
			String apiURL = "https://openapi.naver.com/v1/search/movie.json?query=" + URLEncoder.encode(keyword, "utf-8");
			
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();

			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);

			int responseCode = con.getResponseCode();

			BufferedReader br = null;

			if(responseCode == 200) br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			else br = new BufferedReader(new InputStreamReader(con.getErrorStream()));

			String inStr = "";
			StringBuffer sb = new StringBuffer();
			while((inStr=br.readLine())!=null) {
				sb.append(inStr);
			}
			String result=sb.toString();
			
			br.close();
			String page="";
			DetailViewService dvs=new DetailViewService();
			ReviewService rs=new ReviewService();
			
			try{
				// 검색 결과 갯수에 따라 다른 메서드로 보냄
				if(result.substring(61,62).equals("1")&&!chkNum(result.substring(62,63))) page=dvs.getImage(result);
				else page=dvs.getPowerImage(result,keyword);
				
				// 영화 상세정보
				MovieDetailInfo mov=dvs.selectMovieDetail(keyword);
				
				// 리뷰 정보
				ReviewInfo rv=rs.selectReview(keyword);
				
				request.setAttribute("page",page);
				request.setAttribute("mov", mov);
				request.setAttribute("rv", rv);
					
				request.getRequestDispatcher("views/detail/DetailView3.jsp").forward(request, response);
			}catch(Exception e){
				request.setAttribute("exception", e);
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			request.setAttribute("exception", e);
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
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
		// 숫자인지 아닌지 구별
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
