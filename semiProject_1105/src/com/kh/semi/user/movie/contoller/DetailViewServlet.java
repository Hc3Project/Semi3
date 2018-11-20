package com.kh.semi.user.movie.contoller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semi.common.MovieImg;
import com.kh.semi.user.member.model.vo.Member;
import com.kh.semi.user.movie.model.service.MovieService;
import com.kh.semi.user.movie.model.service.StarRatingService;
import com.kh.semi.user.movie.model.vo.MovieDetailInfo;
import com.kh.semi.user.review.model.service.ReviewService;
import com.kh.semi.user.review.model.vo.ReviewInfo;

/**
 * Servlet implementation class DetailViewServlet
 */
@WebServlet("/dView.do")
public class DetailViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DetailViewServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String videoId = request.getParameter("videoId");
		String mCode = request.getParameter("mCode");
		String userId = null;

		MovieService dvs = new MovieService();
		ReviewService rs = new ReviewService();
		StarRatingService srs = new StarRatingService();
		HttpSession session = request.getSession(false);

		Member m = (Member) session.getAttribute("member");
		if (m != null) {
			userId = m.getUserId();
		}
		try {
			ReviewInfo rv = null;
			MovieDetailInfo mov = null;
			if (videoId != null) {
				rv = rs.selectReview(videoId);
				mCode = rv.getMcode();
			}
			mov = dvs.selectMovieDetail(mCode, userId);
			int score = 0;
			
			if (userId != null) {
				
				score = srs.selectStarRating(userId, mCode);
			}

			String page = "";
			String keyword = mov.getMtitle();

			page= new MovieImg().moviewImg(keyword,mCode);
			
			request.setAttribute("page", page);
			request.setAttribute("mov", mov);
			request.setAttribute("rv", rv);
			request.setAttribute("score", score);

			request.getRequestDispatcher("views/movie/movieDetailView.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("exception", e);
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


}
