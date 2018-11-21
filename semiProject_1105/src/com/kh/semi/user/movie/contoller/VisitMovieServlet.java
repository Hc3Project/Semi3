
package com.kh.semi.user.movie.contoller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.kh.semi.common.MovieImg;
import com.kh.semi.common.MovieSmallImg;
import com.kh.semi.exception.DetailViewException;
import com.kh.semi.manager.video.model.vo.MovieInfo;
import com.kh.semi.user.member.model.vo.Member;
import com.kh.semi.user.movie.model.service.MovieService;

/**
 * Servlet implementation class VisitMovieServlet
 */
@WebServlet("/mVisit.do")
public class VisitMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisitMovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String userId = ((Member) session.getAttribute("member")).getUserId();
		int mPage = Integer.parseInt(request.getParameter("page"));
		String page = "";

		MovieService ms = new MovieService();
		ArrayList<MovieInfo> mlist = new ArrayList<MovieInfo>();

		mlist = ms.visitMovie(userId,mPage);

		response.setContentType("application/json; charset=UTF-8");

		JSONArray result = new JSONArray();
		JSONObject movieIf = null;

		for (MovieInfo movie : mlist) {
			movieIf = new JSONObject();

			movieIf.put("mTitle", movie.getmTitle());
			movieIf.put("mCode", movie.getmCode());

			try {
				movieIf.put("mPage", new MovieSmallImg().movieSmallImg(movie.getmTitle(),movie.getmCode()));
			} catch (Exception e) {
				request.setAttribute("exception", e);
				
			}

			result.add(movieIf);
		}
		response.getWriter().print(result.toJSONString());

		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

