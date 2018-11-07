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
 * Servlet implementation class ReviewerUpdateServlet
 */
@WebServlet("/rUpdate.rvr")
public class ReviewerUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewerUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rvrCode = request.getParameter("channelId");
		String rName = request.getParameter("rvrName");
		String profile = request.getParameter("profile");
		ReviewerService rs = new ReviewerService();
		ReviewerInfo ri = new ReviewerInfo();
		ri.setRvrCode(rvrCode);
		ri.setrName(rName);
		ri.setProfile(profile);
		
		int result = rs.updateReviewer(ri);
		
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
