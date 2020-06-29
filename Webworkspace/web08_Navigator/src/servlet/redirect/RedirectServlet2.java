package servlet.redirect;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public RedirectServlet2() {
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
		 * checkbox를 선택하지 않으면 eroor페이지로 이동  redirect 방법 
		 * 그렇지않은 경우 frowarding 으로 내용을 전달
		 */
	
		String choose = request.getParameter("choose");
		
		if(choose==null) {
			response.sendRedirect("./error/error.html");
		}else {
			request.getRequestDispatcher("redirect2.jsp").forward(request, response);
			
		}
	}

}
