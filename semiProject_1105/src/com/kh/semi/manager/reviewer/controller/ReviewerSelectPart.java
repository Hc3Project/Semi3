package com.kh.semi.manager.reviewer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.semi.manager.reviewer.model.service.ReviewerService;
import com.kh.semi.manager.reviewer.model.vo.ReviewerInfo;

/**
 * Servlet implementation class ReviewerSelectPart
 */
@WebServlet("/rSelectPart.rvr")
public class ReviewerSelectPart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewerSelectPart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		
		ReviewerService rs = new ReviewerService();
		
		List<ReviewerInfo> result = rs.reviewerSelectPartCnt(rs.reviewerSelectPart(keyword));
		response.setContentType("application; charset=utf-8");
		new Gson().toJson(result, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
