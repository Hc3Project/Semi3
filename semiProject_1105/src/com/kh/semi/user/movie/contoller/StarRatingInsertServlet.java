package com.kh.semi.user.movie.contoller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.kh.semi.exception.StarRatingException;
import com.kh.semi.user.member.model.vo.Member;
import com.kh.semi.user.movie.model.service.StarRatingService;

/**
 * Servlet implementation class StarRatingServlet
 */
@WebServlet("/sInsert.do")
public class StarRatingInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StarRatingInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession(false);
		String userId=((Member)session.getAttribute("member")).getUserId();
		String mCode=(String)request.getParameter("mCode");
		int score=Integer.parseInt((String)request.getParameter("score"));
		
		try{
			new StarRatingService().insertStarRating(userId,mCode,score);
			
			response.setContentType("application/json; charset=UTF-8");
			new Gson().toJson(score,response.getWriter());
		}catch(StarRatingException e){
			request.setAttribute("exception", e);
			request.getRequestDispatcher("views/commom/errorPage.jsp").forward(request, response);
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
