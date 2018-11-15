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
		
		if(toPath.equals("add")) {
			page = "/views/manager/addReview.jsp?";
			request.setAttribute("rvrList", result);
		} else if(toPath.equals("del")) {
			page = "/views/manager/deleteReview.jsp?";
			request.setAttribute("rvrList", result);
		} else {
			// 해당 매개변수가 아닐 때 즉 잘못된 경로로 들어왔을 때
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "회원 가입 중 에러가 발생하였습니다.");
			request.setAttribute ("exception", new Exception("잘못 된 변수 선언"));
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
