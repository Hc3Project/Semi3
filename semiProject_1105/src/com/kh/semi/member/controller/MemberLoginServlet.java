package com.kh.semi.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// login.jsp 에 있는 아이디, 비밀번호 name과 같아야 함!!
		String userId = request.getParameter("name");
		String password = request.getParameter("password");
		
		MemberService ms = new MemberService();
		
		Member m = new Member(userId, password);
		
		System.out.println("전달 받은 멤버 정보 : "+m);
		
		try {
			m = ms.selectMember(m);
			System.out.println("로그인 성공!");
			
			HttpSession session = request.getSession();
			
			session.setAttribute("member", m);
			response.sendRedirect("/semi/views/index.jsp");
			
		} catch (MemberException e) {
			
			//e.printStackTrace();
			
			request.setAttribute("msg", "로그인 실패");
			request.setAttribute("exception", e);
			
			 PrintWriter out = response.getWriter();
	          
	         out.println("<script> alert('아이디 또는 비밀번호가 일치하지 않습니다.'); location.href='views/member/login.jsp';</script>");
	          
	         out.flush();
	         out.close();
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
