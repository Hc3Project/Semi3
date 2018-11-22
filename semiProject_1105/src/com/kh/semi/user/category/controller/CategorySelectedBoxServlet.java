package com.kh.semi.user.category.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.kh.semi.common.MovieImg;
import com.kh.semi.manager.video.model.vo.MovieInfo;
import com.kh.semi.user.category.model.service.CategoryService;

/**
 * Servlet implementation class CategorySelectedBoxServlet
 */
@WebServlet("/csBox.ca")
public class CategorySelectedBoxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategorySelectedBoxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CategoryService cs = new CategoryService();
		
		String msql = request.getParameter("msql");
		String gCode = request.getParameter("gCode");
		String nCode = request.getParameter("nCode");
		String rvrCode = request.getParameter("rvrCode");
		int mPage = Integer.parseInt(request.getParameter("page"));
		ArrayList<MovieInfo> mList = new ArrayList<MovieInfo>();
		
		mList = cs.selectMovieList(msql, gCode, nCode, rvrCode,mPage); // 무비 리스트 가져오는 cs
		
		
		response.setContentType("application/json; charset=UTF-8");

		JSONArray result = new JSONArray();
		JSONObject movieIf = null;

		for (MovieInfo movie : mList) {
			movieIf = new JSONObject();

			movieIf.put("mTitle", movie.getmTitle());
			movieIf.put("mCode", movie.getmCode());

			try {
				
				movieIf.put("mPage", new MovieImg().moviewImg(movie.getmTitle(),movie.getmCode()));
			} catch (Exception e) {
				request.setAttribute("exception", e);
				
			}

			result.add(movieIf);
		}
		response.getWriter().print(result.toJSONString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
