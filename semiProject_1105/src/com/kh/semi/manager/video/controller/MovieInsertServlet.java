package com.kh.semi.manager.video.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.manager.video.model.service.VideoService;
import com.kh.semi.manager.video.model.vo.MovieInfo;

/**
 * Servlet implementation class MovieInsertServlet
 */
@WebServlet("/mInsert.vi")
public class MovieInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MovieInfo mi = new MovieInfo();
		
		mi.setmCode(request.getParameter("mCode"));
		mi.setmTitle(request.getParameter("mTitle"));
		mi.setDirector(request.getParameter("director"));
		mi.setActor(request.getParameter("actor"));
		mi.setShowTime(Integer.parseInt(request.getParameter("showTime")));
		String tmpDate = request.getParameter("openDate");
		mi.setOpenDate(Date.valueOf(tmpDate.substring(0, 4) + "-" + tmpDate.substring(4, 6) + "-" + tmpDate.substring(6, 8)));
		mi.setSyno(request.getParameter("syno"));
		
		String genre1 = request.getParameter("genre1");
		String genre2 = request.getParameter("genre2");
		String nation = request.getParameter("nation");
		
		VideoService vs = new VideoService();
		
		mi.setgCode1(vs.selectGenreCode(genre1));
		mi.setgCOde2(vs.selectGenreCode(genre2));
		mi.setnCode(vs.selectNationCode(nation));
		
		int result = vs.insertMovie(mi);
		
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
