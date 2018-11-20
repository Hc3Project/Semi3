package com.kh.semi.user.member.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semi.common.CollaborativeFiltering;
import com.kh.semi.user.member.model.service.MemberService;
import com.kh.semi.user.member.model.vo.Member;

/**
 * Servlet implementation class MemberRecServlect
 */
@WebServlet("/mRecommend.me")
public class MemberRecServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberRecServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Integer> scoreCnt = null;
		List<String> likes = null;
		
		MemberService ms = new MemberService();
		
		HttpSession session = request.getSession();
		Member m = (Member)session.getAttribute("member");
		
		String page = "";
		if(m!=null) {
			// 평점 분포 배열
			scoreCnt = ms.selectRatingCnt(m.getUserId());
			
			// 변수
			likes = ms.selectLikesReviewer(m.getUserId());
			page = "/views/movie/typeAnalysis.jsp";
			session.setAttribute("member", m);
			session.setAttribute("scoreCnt", Arrays.toString(scoreCnt.toArray()));		// 평점 분포
			session.setAttribute("likes", Arrays.toString(likes.toArray()));	// 구독
		} else {
			// 로그인 안하고 들어갔을 때
			request.setAttribute("exception", new Exception("로그인을 해야 사용가능합니다."));
			page = "views/common/errorPage.jsp";
		}
		request.getRequestDispatcher(page).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
