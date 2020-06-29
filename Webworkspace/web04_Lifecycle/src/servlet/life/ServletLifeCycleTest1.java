package servlet.life;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletLifeCycleTest1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count=0; //필드..
	
	
    public ServletLifeCycleTest1() {
        super();
        System.out.println("1. ServletLifeCycleTest1..call by contanier");
    }

	
	public void init() throws ServletException {
		System.out.println("2. init..call by contanier");
	}

	
	public void destroy() {
		System.out.println("4. destroy..call by contanier");
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("3. service..call by contanier");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><body bgcolor=cyan>");
		out.println("<h2>LifeCycle CallBack Method</h2>");
		out.println("<b>cCount :: <b>"+ ++count);
		out.println("</body></html>");
		
		
		out.close();
	}

}


