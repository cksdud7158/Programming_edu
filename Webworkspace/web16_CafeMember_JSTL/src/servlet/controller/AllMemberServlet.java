package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;


public class AllMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AllMemberServlet() {
        super();
   
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<MemberVO> list = new ArrayList<>();
		
		MemberDAOImpl dao = MemberDAOImpl.getInstance();
		
		try {
			list = dao.showAllMember();
			request.setAttribute("list", list);
			request.getRequestDispatcher("allshow.jsp").include(request, response);
			
		} catch (SQLException e) {
			System.out.println("회원이 아무도 없습니다.");
		}
	}

}















