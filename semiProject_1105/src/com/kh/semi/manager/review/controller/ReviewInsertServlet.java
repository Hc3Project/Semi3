package com.kh.semi.manager.review.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.manager.review.model.vo.ReviewInfo;
import com.kh.semi.manager.review.model.service.ReviewService;

/**
 * Servlet implementation class ReviewInsertServlet
 */
@WebServlet("/rvInsert.rv")
public class ReviewInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rvrCode = request.getParameter("rvrCode");
		String videoId = request.getParameter("videoId");
		String mCode = request.getParameter("mCode");
		Date uploadDate = Date.valueOf(request.getParameter("pDate").replaceAll("T.*", ""));
		
		ReviewInfo rvi = new ReviewInfo();
		rvi.setVideoId(videoId);
		rvi.setmCode(mCode);
		rvi.setRvrCode(rvrCode);
		rvi.setUploadDate(uploadDate);
		
		ReviewService rs = new ReviewService();
		int result = rs.insertReview(rvi);
		
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
