package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginSuccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginSuccess() {
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
		
		out.println("<html> "
				+ "<head>\r\n" + 
				"    <meta charset=\"UTF-8\">\r\n" + 
				"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n" + 
				"    <title>Document</title>\r\n" + 
				"    <style>\r\n" + 
				"       body{\r\n" + 
				"           width: 900px;\r\n" + 
				"			height: 300px;\r\n" +
				"           margin: 0 auto;\r\n" + 
				"           margin-top: 200px;\r\n" + 
				"           text-align: center;\r\n" + 
				"           border: 1px solid black;\r\n" + 
				"       }\r\n" + 
				"       a{\r\n" + 
				"           display: block;\r\n" + 
				"       }\r\n" + 
				"\r\n" + 
				"    </style>\r\n" + 
				"</head><body>");
		
		out.println("<h2>"+id+"님이 로그인되었습니다.</h2>");
		out.println("<a href=registerBook>도서 등록</a>");
		out.println("<a href=http://localhost:8888/servlet_workshop1/index.html>로그아웃</a>");
		out.println("</html></body>");
	}
}














