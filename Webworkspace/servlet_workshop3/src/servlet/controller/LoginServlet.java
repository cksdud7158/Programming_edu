package servlet.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.BookVO;
import servlet.model.userInfo;

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
		String id= request.getParameter("id");
		String password= request.getParameter("password");
		System.out.println(id);
		System.out.println(password);
		
		
		if(id.equals("id")&&password.equals("pass1")) {
			request.getRequestDispatcher("loginSuccess.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("index.html").include(request, response);
			out.println("<script>alert('ID or Password가 틀렸습니다.')</script>");
		}
	}

}















