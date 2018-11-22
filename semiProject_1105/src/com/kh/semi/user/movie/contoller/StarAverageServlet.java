package com.kh.semi.user.movie.contoller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.semi.user.movie.model.service.StarRatingService;
import com.kh.semi.user.movie.model.vo.StarRating;

/**
 * Servlet implementation class StarAverageServlet
 */
@WebServlet("/star.avg")
public class StarAverageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StarAverageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mCode=request.getParameter("mCode");
		StarRatingService srs=new StarRatingService();
		StarRating sr=srs.selectStarAvgRating(mCode);
		response.setContentType("application/json; charset=UTF-8");
		new Gson().toJson(sr,response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
