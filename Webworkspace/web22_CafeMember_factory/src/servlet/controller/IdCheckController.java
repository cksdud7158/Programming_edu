package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;

public class IdCheckController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String path = "idcheck.jsp";
		String id = request.getParameter("id");
		try {
			boolean flag=MemberDAOImpl.getInstance().idExist(id);
			request.setAttribute("flag", flag);
			request.getRequestDispatcher(path).forward(request, response);
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}

}
