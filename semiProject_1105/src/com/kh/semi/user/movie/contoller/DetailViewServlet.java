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
		// 클릭시 받아오는 값 (늘어나면 수정)
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
			// 영화정보와 리뷰정보를 불러옴
			ReviewInfo rv = null;
			MovieDetailInfo mov = null;
			if (videoId != null) {
				rv = rs.selectReview(videoId);
				mCode = rv.getMcode();
			}
			mov = dvs.selectMovieDetail(mCode, userId);
			int score = 0;
			
			// 별점 가져오기
			// 세션에 회원이 로그인한 정보가 있으면 불러오고, 없다면 디폴트 0점
			// 별점은 회원만 메길 수 있어야 하는데 1. 비회원은 별점을 클릭해도 이벤트가 발생하지 않는다
			// 2. 비회원은 별점을 볼 수 없다 등 비회원이 DB에 영향을 끼치지 않도록 생각해봐야함
			// DB RATING 테이블 SCORE 컬럼에 디폴트 0, CHECK 제약조건 달아둠(0~10) 다음에 공유함
			if (userId != null) {
				score = srs.selectStarRating(userId, mCode);
				System.out.println(userId);
			}

			String page = "";
			String keyword = mov.getMtitle();

			// 불러온 정보를 이용해 네이버API로 포스터 클로링
			page= new MovieImg().moviewImg(keyword);

			// 문제가 없다면 보내기
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
