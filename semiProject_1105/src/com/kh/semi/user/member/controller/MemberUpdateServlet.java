package com.kh.semi.user.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semi.user.member.execption.MemberException;
import com.kh.semi.user.member.model.service.MemberService;
import com.kh.semi.user.member.model.vo.Member;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/mUpdate.me")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("newPassword");

		MemberService ms = new MemberService();

		HttpSession session = request.getSession(false);
		Member m = (Member) session.getAttribute("member");

		m.setEmail(email);
		m.setPassword(password);

		System.out.println("회원 기존 정보 : " + session.getAttribute("member"));
		System.out.println("회원 정보 수정 시 전달 받은 값 : " + m);

		try {
			ms.updateMember(m);
			System.out.println("회원 정보 수정 완료!: " + m);
			response.sendRedirect("/semi/index.jsp");

		} catch (Exception e) {

			// e.printStackTrace();

			request.setAttribute("msg", "회원정보 수정 중 에러가 발생했습니다!");
			request.setAttribute("exception", e);

			// request.getRequestDispatcher("views/common/errorPage.jsp").forward(request,
			// response);
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
