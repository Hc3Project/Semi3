package com.kh.semi.user.reviewer.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semi.exception.ReviewerViewException;
import com.kh.semi.manager.reviewer.model.vo.ReviewerInfo;
import com.kh.semi.user.member.model.vo.Member;
import com.kh.semi.user.review.model.service.ReviewService;
import com.kh.semi.user.reviewer.model.service.UReviewerService;

/**
 * Servlet implementation class ReviewerProfileServlet
 */
@WebServlet("/profile.rvr")
public class ReviewerProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewerProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		Member m=(Member) session.getAttribute("member");
		
		String rvrCode=request.getParameter("rvrCode");
		String prfImg=request.getParameter("prfImg");
		System.out.println("프로파일:"+prfImg);
		try{
			ReviewerInfo ri= new UReviewerService().reviewerDetail(rvrCode);
			
			if(m!=null){
				String result=new UReviewerService().selectReviewerStatus(m.getUserId());
				request.setAttribute("list", result);
			}else{
				request.setAttribute("list", "");
			}
			request.setAttribute("ri", ri);
			request.setAttribute("rvrCode", rvrCode);
			request.setAttribute("prfImg", prfImg);
		
			request.getRequestDispatcher("views/movie/movieReviewerDetailView.jsp").forward(request, response);
		}catch(ReviewerViewException e){
			request.setAttribute("exception", e);
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
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
