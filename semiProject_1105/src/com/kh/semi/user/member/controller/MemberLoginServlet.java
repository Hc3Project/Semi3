package com.kh.semi.user.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semi.common.CollaborativeFiltering;
import com.kh.semi.exception.MemberException;
import com.kh.semi.user.member.model.service.MemberService;
import com.kh.semi.user.member.model.vo.Member;



/**
 * Servlet implementation class MemberLoginServlet
 */
@WebServlet("/login.me")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberLoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// login.jsp 에 있는 아이디, 비밀번호 name과 같아야 함!!
		String userId = request.getParameter("name");
		String password = request.getParameter("password");

		MemberService ms = new MemberService();

		Member m = new Member(userId, password);

		System.out.println("전달 받은 멤버 정보 : " + m);
		
		// 추천용 변수
		List<String> userList = null;
		List<String> itemList = null;
		int[][] itemMatrix = null;
		HashMap<Integer, Double> cfResult = null;
		String[] itemRankList = null;
		
		try {
			m = ms.selectMember(m);
			System.out.println("로그인 성공!");
			
			// 추천 알고리즘 추가
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
			///////////////////////////////
			HttpSession session = request.getSession();

			session.setAttribute("member", m);
			response.sendRedirect("/semi/index.jsp");

		} catch (MemberException e) {
			
			PrintWriter out = response.getWriter();

			out.println("<script> alert('아이디 또는 비밀번호가 일치하지 않습니다.'); location.href='views/member/login.jsp';</script>");

			out.flush();
			out.close();
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
