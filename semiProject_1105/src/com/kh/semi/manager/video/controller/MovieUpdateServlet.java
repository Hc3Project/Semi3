package com.kh.semi.manager.video.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.manager.video.model.service.VideoService;
import com.kh.semi.manager.video.model.vo.MovieInfo;

/**
 * Servlet implementation class MovieUpdateServlet
 */
@WebServlet("/mUpdate.vi")
public class MovieUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mCode = request.getParameter("mCode");
		String mTitle = request.getParameter("mTitle");
		String director = request.getParameter("director");
		String actor = request.getParameter("actor");
		String syno = request.getParameter("syno");
		
		MovieInfo mi = new MovieInfo();
		mi.setmCode(mCode);
		mi.setmTitle(mTitle);
		mi.setDirector(director);
		mi.setActor(actor);
		mi.setSyno(syno);
		
		int result = new VideoService().updateMovie(mi);
		
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
