package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.membership.MemberImpl;

import servlet.error.DuplicateSSNException;
import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public RegisterServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// 폼값을 받는다. 
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		//vo 생성
		MemberVO vo = new MemberVO(id, password, name, address);
		
		//MemebrDAO를 리턴 받는다. 
		MemberDAOImpl dao = MemberDAOImpl.getInstance();
		
		//비즈니스로직 호출
		try {
			dao.registerMember(new MemberVO(id, password, name, address));
		} catch (SQLException | DuplicateSSNException e) {
			System.out.println("이미 존재합니다._RegisterServlet");
		}
		// 다이렉트 
		PrintWriter out = response.getWriter();
		out.println(request.getParameter("id")+"가입 완료됬습니다.");
		out.println("<hr><p>");
		request.getRequestDispatcher("AMS").include(request, response);
		
		
		
	}

}
