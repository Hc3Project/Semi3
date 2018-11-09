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
import com.kh.semi.user.movie.model.service.StarRatingService;

/**
 * Servlet implementation class StarRatingUpdateServlet
 */
@WebServlet("/sUpdate.do")
public class StarRatingUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StarRatingUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 별점이 있으면 업데이트한다
		HttpSession session=request.getSession(false);
		String userId=(String)session.getAttribute("userId");
		String mCode=(String)request.getAttribute("mCode");
		int score=(int)request.getAttribute("score");
		
		try{
			new StarRatingService().updateStarRating(userId,mCode,score);
			JSONObject starRating=null;
			
			// 이거 노란줄 왜 생김?
			starRating.put("score", score);
			
			response.setContentType("application/json; charset=UTF-8");
			new Gson().toJson(starRating,response.getWriter());
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
