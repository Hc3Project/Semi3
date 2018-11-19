package com.kh.semi.user.category.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.kh.semi.user.category.model.vo.CategoryInfo;
import com.kh.semi.user.member.model.service.MemberService;
import com.kh.semi.user.member.model.vo.Member;

/**
 * Servlet implementation class GenreStatServlet
 */
@WebServlet("/gStat.me")
public class GenreStatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenreStatServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Member m = (Member)session.getAttribute("member");
		List<CategoryInfo> gStat1 = null;
//		List<CategoryInfo> gStat2 = null;
		
		MemberService ms = new MemberService();
		
		gStat1 = ms.selectGenreStat(m.getUserId(), "gcode1");
		
		new Gson().toJson(gStat1, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
