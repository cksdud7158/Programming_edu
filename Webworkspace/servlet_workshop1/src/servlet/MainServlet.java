package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MainServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
				
		PrintWriter out = response.getWriter();
		
		if(id.equals("encore") && password.equals("1234")) {
			out.println("<html><body>");
			out.println("<a href=loginSuccess?id="+id+"&password="+password+">로그인페이지로 이동<a>");
			out.println("</html></body>");
			
			out.close();
		}else {
			out.println("<html><body>");
			out.println("<h2>로그인 실패<h2>");
			out.println("<a href=http://localhost:8888/servlet_workshop1/index.html>로그인페이지로 가기<h2>");
			out.println("</html></body>");
			
			out.close();
		}
		
	}
}
