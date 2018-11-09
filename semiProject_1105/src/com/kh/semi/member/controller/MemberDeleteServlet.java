package com.kh.semi.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semi.member.execption.MemberException;
import com.kh.semi.member.model.service.MemberService;
import com.kh.semi.member.model.vo.Member;

/**
 * Servlet implementation class MemberDeleteServlet
 */
@WebServlet("/mDelete.me")
public class MemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService ms = new MemberService();
		HttpSession session = request.getSession(false);
		
		Member m = (Member)session.getAttribute("member");
		
		System.out.println("회원 기존 정보 : "+session.getAttribute("member"));
		
		try {
			ms.deleteMember(m.getUserId());
			System.out.println("회원 탈퇴 완료!: "+m);
			
			session.invalidate();
			
			response.sendRedirect("/semi/views/index.jsp");
			
		} catch (Exception e) {
			
			request.setAttribute("msg", "회원 탈퇴 중 에러가 발생했습니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
