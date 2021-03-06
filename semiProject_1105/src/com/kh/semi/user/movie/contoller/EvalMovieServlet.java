package com.kh.semi.user.movie.contoller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.kh.semi.manager.video.model.vo.MovieInfo;
import com.kh.semi.user.member.model.vo.Member;
import com.kh.semi.user.movie.model.service.MovieService;

/**
 * Servlet implementation class VisitMovieServlet
 */
@WebServlet("/mEval.do")
public class EvalMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EvalMovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String userId = ((Member) session.getAttribute("member")).getUserId();
		int ePage = Integer.parseInt(request.getParameter("page"));
		String page = "";

		MovieService ms = new MovieService();
		ArrayList<MovieInfo> mlist = new ArrayList<MovieInfo>();

		mlist = ms.evalMovie(userId,ePage);

		response.setContentType("application/json; charset=UTF-8");
		new Gson().toJson(mlist, response.getWriter());

		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
