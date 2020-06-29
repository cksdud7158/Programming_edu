package servlet.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletConfigTest1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String name, addr;
       
   
    public ServletConfigTest1() {
        super();
        System.out.println("생성자 호출..");

    }
    
    @Override
    public void init() throws ServletException {
    	super.init();
        System.out.println("init 호출..");
       name = getInitParameter("name");
       addr = getInitParameter("addr");
       System.out.println(name+","+addr);

    	
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doProcess 호출..");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<h2> A Servlet Config Instance Intialization<h2><p>");
		out.println(name);
		out.println(addr);
		
		out.close();
        

	}


}
