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
import com.kh.semi.user.reviewer.model.vo.ReviewerLikes;

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
		try {
			if(m!=null){
				// 회원정보가 있을 경우
				String result=new UReviewerService().selectReviewerStatus(m.getUserId());
				request.setAttribute("list", result);
				request.getRequestDispatcher("views/movie/movieReviewerView.jsp").forward(request, response);
			}else{
				// 회원 정보가 없을 경우
				request.setAttribute("list", "");
				request.getRequestDispatcher("views/movie/movieReviewerView.jsp").forward(request, response);
			}
		}catch (ReviewerViewException e) {
			request.setAttribute("exception", e);
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
