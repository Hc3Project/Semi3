package com.kh.semi.user.search.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.kh.semi.common.MovieSmallImg;
import com.kh.semi.exception.DetailViewException;
import com.kh.semi.manager.video.model.vo.MovieInfo;
import com.kh.semi.user.search.model.service.SearchMovieService;

/**
 * Servlet implementation class SearchMovieServlet
 */
@WebServlet("/sMovie.sc")
public class SearchMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchMovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 영화 제목 전달받음
		String movieTitle = request.getParameter("MovieTitle");
		
		// 2. 검색할 영화 리스트 담을 공간 생성
		ArrayList<MovieInfo> mList = new ArrayList<MovieInfo>();
		
		SearchMovieService sms = new SearchMovieService();
		String page="";
		// 3. 리스트에 서비스에서 실행되는 검색 메소드 실행
		try {
			mList = sms.searchMovie(movieTitle);
			page= "views/movie/searchCategory.jsp";
			request.setAttribute("search", movieTitle);
			request.setAttribute("sList", mList);
		} catch (Exception e) {
			page="views/common/errorPage.jsp";
			e.printStackTrace();
		}
		
		// 4. 
		
		
		request.getRequestDispatcher(page).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
