package com.kh.semi.user.reviewer.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.manager.reviewer.model.vo.ReviewerInfo;
import com.kh.semi.user.reviewer.model.service.UReviewerService;


/**
 * Servlet implementation class ReviewerDetailServlet
 */
@WebServlet("/rDetail.rvr")
public class ReviewerDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewerDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String rvrCode = request.getParameter("rvrCode");
		System.out.println(rvrCode);
		UReviewerService rvr = new UReviewerService();
		
		ReviewerInfo ri = new ReviewerInfo();
		ri= rvr.reviewerDetail(rvrCode);
		
		System.out.println("전달 받은 리뷰어 정보 : "+ri);
		
		String page= "";
		
		if(ri != null){
			page = "views/movie/movieReviewerDetailView.jsp";
			request.setAttribute("ri", ri);
		} else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "상세페이지 불러오기 실패!");
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
