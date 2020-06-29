package servlet.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CartServlet() {
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
		
		//1. 기존 세션을 하나 받아옴
		HttpSession s = request.getSession(false);
		
		//2. jsessionId, vo, product 정보 받아와서 출력
		
		out.println("jessionId--"+s.getId()+"  vo--"+s.getAttribute("vo")+"product---"+s.getAttribute("product"));
		//3. 현재 세션에 바인딩 된 정보가 있다면  세션을 종료 
		if(s.getAttribute("vo")!=null) {
			s.invalidate();
			out.println("<script> alert('로그아웃되셨습니다.') ");
			out.println("location.href='login.html' </script>");
		}else {
			//4. 현재 세션에 바인딩 된 정보가 있다면  -- 처음부터 -> 로그인으로 보내기 
			out.println("<h2>로그인 실패됬습니다.</h2>");
			out.println("<a href= login.html> Login 페이지로 이동 <a>");
		}
		
		
	}

}
