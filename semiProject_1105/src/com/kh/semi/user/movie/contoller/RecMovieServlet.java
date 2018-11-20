package com.kh.semi.user.movie.contoller;

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

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.kh.semi.common.CollaborativeFiltering;
import com.kh.semi.common.MovieImg;
import com.kh.semi.exception.DetailViewException;
import com.kh.semi.manager.video.model.vo.MovieInfo;
import com.kh.semi.user.member.model.service.MemberService;
import com.kh.semi.user.member.model.vo.Member;

/**
 * Servlet implementation class RecMovieServlet
 */
@WebServlet("/recMovie.do")
public class RecMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecMovieServlet() {
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
		String[] itemRankList = null;
		String[] itemRankTitle = null;
		HashMap<Integer, Double> cfResult = null;
		
		MemberService ms = new MemberService();
		
		HttpSession session = request.getSession();
		Member m = (Member)session.getAttribute("member");
		
		String page = "";
		if(m!=null) {
			// 협업 필터링 및 배열 출력
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
					itemRankTitle = new String[tmpArr.length];
					for(int i=0; i<itemRankList.length; i++) {
						itemRankList[i] = itemList.get((int)tmpArr[i]);
						itemRankTitle[i] = ms.selectMovieTitle(itemList.get((int)tmpArr[i]));
					}
					m.setRecRecList(itemRankList);
				} else {
					// 추천결과가 하나도 없을 경우 null
				}
			} else {
				// 평점을 단 한번도 하지 않을 경우 null
			}
			// 변수
			session.setAttribute("member", m);
			response.setContentType("application/json; charset=UTF-8");
			
			JSONArray result = new JSONArray();
			JSONObject movie = null;
			
			for(int i = 0;i<itemRankTitle.length;i++) {
				System.out.println(itemRankTitle[i].toString());
				System.out.println("code"+m.getRecList()[i].toString());
				movie = new JSONObject();
				
				movie.put("mTitle", itemRankTitle[i]);
				movie.put("mCode", m.getRecList()[i]);
				
				try {
					movie.put("mPage", new MovieImg().moviewImg(itemRankTitle[i],m.getRecList()[i]));
				} catch (DetailViewException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				result.add(movie);

			}
			response.getWriter().print(result.toJSONString());
		
			/*	System.out.println(Arrays.toString(m.getRecList()));
			response.getWriter().print(Arrays.toString(m.getRecList()) + "," + Arrays.toString(itemRankTitle));*/
			

		/*	JSONArray result = new JSONArray();
			JSONObject movieIf = null;

			for (MovieInfo movie : mlist) {
				movieIf = new JSONObject();

				movieIf.put("mTitle", movie.getmTitle());
				movieIf.put("mCode", movie.getmCode());

				try {
					movieIf.put("mPage", new MovieImg().moviewImg(movie.getmTitle(),movie.getmCode()));
				} catch (DetailViewException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				result.add(movieIf);
			}
			response.getWriter().print(result.toJSONString());*/
			
			
			
			
			
				
		} else {
			// 로그인 안하고 들어갔을 때
			request.setAttribute("exception", new Exception("로그인을 해야 사용가능합니다."));
			page = "views/common/errorPage.jsp";
			request.getRequestDispatcher(page).forward(request, response);
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
