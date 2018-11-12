package com.kh.semi.user.category.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.manager.video.model.vo.MovieInfo;
import com.kh.semi.user.category.model.service.CategoryService;

/**
 * Servlet implementation class CategorySelectServlet
 */
@WebServlet("/sCategory.se")
public class CategorySelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategorySelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 쿼리스트링에서 카테고리 코드 받아오기
		String cCode = request.getParameter("cCode");
		
		// 2.카테고리 코드에 따른 영화 정보 list로 받아오기
		ArrayList<MovieInfo> mList = new ArrayList<MovieInfo>();
		
		CategoryService cs = new CategoryService();
		
		mList = cs.selectCategory(cCode);
		
		System.out.println("영화코드 확인  : " + cCode);
		
		String page="";
		
		if(mList!=null){
			page="/views/movie/movieCategory.jsp";
			request.setAttribute("cCode", cCode);
		}else{
			page="/views/common/errorPage.jsp";
			request.setAttribute("msg", "해당 카테고리 영화가 없습니다!");
		}
		
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
