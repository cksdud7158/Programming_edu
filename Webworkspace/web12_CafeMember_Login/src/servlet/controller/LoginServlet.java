package servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
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
		// 1. 폼값 받아온다.
		String id = request.getParameter("id");
		String password= request.getParameter("password");
		
		// 2. dao 리턴받고 biz 로직 호출
		MemberDAOImpl dao = MemberDAOImpl.getInstance();
		
		try {
			MemberVO loginVo= dao.login(id, password);
			
		// 3. 세션을 받아온다.
			HttpSession session = request.getSession();
			
		// 4. 결과값 바인딩 ... 세션에...이떄 jsessionId 값도 찍어본다. 콘솔에 
			session.setAttribute("loginVo", loginVo);
			System.out.println(session.getId());
			
		// 5. 페이지 이동 login_result.jsp
			request.getRequestDispatcher("login_result.jsp").forward(request, response);
			
		} catch (Exception e) {
			System.out.println("로그인 실패 ");
		}
		
		
		
		
		
		
	}

}
