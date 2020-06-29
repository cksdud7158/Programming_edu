package servlet.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberVO;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public LoginServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		//1. session을 하나 받아온다.
		//HttpSession s = request.getSession();
		HttpSession s = request.getSession(true); // 최초로 세션이 만들어졌을 때 true, 기존의 것을 갖다 쓸때는 false
		System.out.println(s.getId());
		
		// 2. 폼에 입력된 값을 가지고 vo 객체 생성 MemverVO
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		MemberVO vo = new MemberVO(id, password);
		//3. 세션에 바인딩
		s.setAttribute("vo", vo);
		out.println(vo);
		out.println("<hr>");
		
		//4. 네비게이션 
		out.println("<a href= ProductServlet> ProductServlet <a>");
		
		
	}

}
