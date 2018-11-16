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
		
		// 별점이 없는 경우 회원의 별점을 새로 테이블에 인서트한다
		HttpSession session=request.getSession(false);
		String userId=((Member)session.getAttribute("member")).getUserId();
		String mCode=(String)request.getAttribute("mCode");
		System.out.println(mCode);
		System.out.println((String)request.getAttribute("score"));
		int score=Integer.parseInt((String)request.getAttribute("score"));
		
		try{
			int result=new StarRatingService().insertStarRating(userId,mCode,score);
			
			response.setContentType("application/json; charset=UTF-8");
			new Gson().toJson(result,response.getWriter());
		}catch(Exception e){
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
