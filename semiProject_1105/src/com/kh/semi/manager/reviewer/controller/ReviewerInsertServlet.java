package com.kh.semi.manager.reviewer.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.manager.reviewer.model.service.ReviewerService;
import com.kh.semi.manager.reviewer.model.vo.ReviewerInfo;

/**
 * Servlet implementation class ReviewerInsertServlet
 */
@WebServlet("/rvrInsert.rvr")
public class ReviewerInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewerInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rvrCode = request.getParameter("rvrCode");
		String rName = request.getParameter("rvrName");
		String profile = request.getParameter("profile");
		
		ReviewerInfo ri = new ReviewerInfo();
		ri.setRvrCode(rvrCode);
		ri.setrName(rName);
		ri.setProfile(profile);
		
		int result = new ReviewerService().insertReviewer(ri);
		
		response.getWriter().print(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
