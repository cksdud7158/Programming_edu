package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberVO;

public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext context;  
 
    public ViewServlet() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 
		 * 1. Attribute 에 바인딘됭 데이타를 받아와서 
		 * 2. 웹브라우저에 출력하는 로직 을 작성
		 * 
		 */
		
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		context=getServletContext();
		MemberVO vo = (MemberVO)context.getAttribute("vo");
		
		out.println("<h2>정보 출력</h2>");
		out.println("<h2>이름 정보 출력</h2>"+vo.getName());
		out.println("<h2>나이 정보 출력</h2>"+vo.getAge());
		out.println("<h2>주소 정보 출력</h2>"+vo.getAddr());
		
		out.close();
	}

}
