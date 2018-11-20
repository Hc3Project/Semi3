package com.kh.semi.user.category.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
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
		
		ArrayList<MovieInfo> mList = new ArrayList<MovieInfo>();
		
		mList = cs.selectMovieList(msql, gCode, nCode, rvrCode); // 무비 리스트 가져오는 cs
		
		response.setContentType("application/json; charset=UTF-8");
		
		new Gson().toJson(mList, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
