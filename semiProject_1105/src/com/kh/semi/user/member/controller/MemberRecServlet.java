package com.kh.semi.user.member.controller;

import java.io.IOException;
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
		
		List<String> userList = null;
		List<String> itemList = null;
		int[][] itemMatrix = null;
		HashMap<Integer, Double> cfResult = null;
		String[] itemRankList = null;
		
		MemberService ms = new MemberService();
		
		HttpSession session = request.getSession();
		Member m = (Member)session.getAttribute("member");
		
		if(m!=null) {
			int userIdx = ms.selectUserIdx(m.getUserId());
			if(userIdx!=-1) {
				// 평점을 한번 이상 매겼을 경우..
				userList = ms.selectUserNum("userId");
				itemList = ms.selectUserNum("mCode");
				itemMatrix = ms.selectRating(userList.size(), itemList.size());
				cfResult = new CollaborativeFiltering().cfCalc(itemMatrix, userIdx);

				Object[] tmpArr = cfResult.keySet().toArray();
				if(tmpArr.length!=0) {
					// 추천 결과 값이 하나 이상 존재하면 예측치가 높은 순서대로 배열에 담긴다
					itemRankList = new String[tmpArr.length];
					for(int i=0; i<itemRankList.length; i++) {
						itemRankList[i] = itemList.get((int)tmpArr[i]);
					}
					m.setRecRecList(itemRankList);
				} else {
					// 추천결과가 하나도 없을 경우 null
				}
			} else {
				// 평점을 단 한번도 하지 않을 경우 null
			}
		} else {
		}
		
		session.setAttribute("member", m);
		response.sendRedirect("/semi/views/movie/yourMovieAnalysis.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
