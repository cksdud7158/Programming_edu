package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//로그아웃 로직을 작성....invalidate()
		HttpSession session = request.getSession();
		String path ="index.jsp";	
		if(session.getAttribute("vo") !=null) {//로그인한 상태라면...
			session.invalidate();
			path ="logout.jsp";
			request.getRequestDispatcher(path).forward(request, response);
		}
		return null;
	}

}
