package com.kh.semi.user.reviewer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semi.exception.ReviewerViewException;
import com.kh.semi.user.member.model.vo.Member;
import com.kh.semi.user.reviewer.model.service.UReviewerService;

/**
 * Servlet implementation class ReviewerServlet
 */
@WebServlet("/reviewer.do")
public class ReviewerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		Member m=(Member) session.getAttribute("member");
		
		if(m!=null){
			String result=new UReviewerService().selectReviewerStatus(m.getUserId());
			request.setAttribute("list", result);
		}else{
			request.setAttribute("list", "");
		}
		request.getRequestDispatcher("views/movie/movieReviewerView.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
