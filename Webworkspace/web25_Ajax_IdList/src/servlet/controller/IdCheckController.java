package servlet.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;

public class IdCheckController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		PrintWriter out = response.getWriter();
		String path = "step2_register.html";
		String id = request.getParameter("id");
		try {
			boolean flag=MemberDAOImpl.getInstance().idExist(id);
			out.print(flag);
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}

}
