package com.kh.semi.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.member.execption.MemberException;
import com.kh.semi.member.model.service.MemberService;
import com.kh.semi.member.model.vo.Member;

/**
 * Servlet implementation class MemberInsertServlet
 */
@WebServlet("/mInsert.me")
public class MemberInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		
		
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("password"));
		System.out.println(request.getParameter("email"));
		
		MemberService ms = new MemberService();
		Member m = new Member(userId, password, email);
		System.out.println("email fg"+email);
		
		try {
			ms.insertMember(m);
			System.out.println("회원 가입 완료 : "+m);
			response.sendRedirect("/semi/views/index.jsp");
		} catch (MemberException e) {
			System.out.println("에러가 발생했습니다~");
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
