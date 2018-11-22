package com.kh.semi.manager.video.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.semi.common.PosterAPI;
import com.kh.semi.manager.video.model.service.VideoService;
import com.kh.semi.user.movie.model.service.MovieService;

/**
 * Servlet implementation class MovieSynopsisServlet
 */
@WebServlet("/movie.syno")
public class MovieSynopsisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieSynopsisServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mCode=request.getParameter("mCode");
		String mTitle=request.getParameter("mTitle");
		
		String result=new PosterAPI().getPosterResult(mTitle);
		
		MovieService dvs = new MovieService();
		String syno = "";
		try{
			if (result.substring(61, 62).equals("1") && !chkNum(result.substring(62, 63)))
				syno = dvs.getSyno(result,mCode);
			else
				syno = dvs.getPowerSyno(result, mTitle,mCode);
		}
		catch(Exception e){
			request.setAttribute("exception", e);
			request.getRequestDispatcher("views/common/errorPage.jsp");
		}
		new Gson().toJson(syno,response.getWriter());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private boolean chkNum(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
