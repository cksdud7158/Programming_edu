package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberVO;


public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext context;
		
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
			/*
			 * 1. 양방향 한글 처리
			 * 2. 폼값 받아서 
			 * 3. vo 객체 생성
			 * 4. DAO 리턴 받고 (받았다 가정)
			 * 5. 비즈니스 로직호출 (했다 가정)
			 * 6. 객체 바인딩 ...ServletContext에 
			 * 7. 페이지 이동.. ( a 태그)
			 */
			
			//request.setCharacterEncoding("utf-8");
			//response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			String addr = request.getParameter("addr");
			
			MemberVO vo = new MemberVO(name, age, addr);
			
			context = getServletContext();
			context.setAttribute("vo", vo); // 참조변수와 같은 이름으로 설정하는것이 좋다. 
			
			out.println("<a href=ViewServlet>ViewServlet 이동</a>");
			//out.println("<a href=result.jsp>결과 확인 이동</a>");
			
			out.close();
		}
}
