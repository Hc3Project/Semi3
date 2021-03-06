package com.kh.semi.manager.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.semi.manager.user.model.service.UserService;
import com.kh.semi.manager.user.model.vo.UserInfo;

/**
 * Servlet implementation class UserSelectPartServlet
 */
@WebServlet("/uSelectPart.ur")
public class UserSelectPartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSelectPartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opt = request.getParameter("opt");
		String keyword = request.getParameter("keyword");
		int stNum = Integer.parseInt(request.getParameter("stNum"));
		int edNum = Integer.parseInt(request.getParameter("edNum"));
		
		List<UserInfo> result = new UserService().selectPartUser(opt, keyword, stNum, edNum);
		new Gson().toJson(result, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
