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
import com.kh.semi.user.category.model.vo.CategoryInfo;

/**
 * Servlet implementation class CategoryListServlet
 */
@WebServlet("/cList.ca")
public class CategoryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("servlet");
		String csql = request.getParameter("csql");
		

		ArrayList<CategoryInfo> cList = new ArrayList<CategoryInfo>();

		
		cList = new CategoryService().selectCategoryList(csql); // 카테고리 리스트 가져오는 cs

		response.setContentType("application/json; charset=UTF-8");
		
		new Gson().toJson(cList, response.getWriter());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
