package servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;


public class IdcheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public IdcheckServlet() {
        super();
     
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		try {
			boolean flag=MemberDAOImpl.getInstance().idExist(id);
			request.setAttribute("flag", flag);
			request.getRequestDispatcher("idcheck.jsp").forward(request, response);
		}catch(Exception e) {
			System.out.println(e);
		}
		
	
		
	}

}
