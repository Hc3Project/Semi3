package com.kh.semi.manager.review.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.manager.review.model.service.ReviewService;
import com.kh.semi.manager.reviewer.model.vo.ReviewerInfo;

/**
 * Servlet implementation class ReviewerSelectAllServlet
 */
@WebServlet("/rvrSelectAll.rv")
public class ReviewerSelectAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewerSelectAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String toPath = request.getParameter("opt");
		ReviewService rs = new ReviewService();
		List<ReviewerInfo> result = rs.selectAllReviewer();
		
		String page = "";
		if(result != null) {
			page = "/views/manager/addReview.jsp?opt=" + toPath;
			request.setAttribute("rvrList", result);
		} else {
			// 리뷰어가 하나도 없을 경우
			// 차후 에러 페이지 보내기
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
