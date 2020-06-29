package servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class LoginController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String path="login_result.jsp";
		try {
			MemberVO rvo=MemberDAOImpl.getInstance().login(id, password);
			HttpSession session = request.getSession();
			
			if(rvo !=null ) {
				session.setAttribute("vo", rvo);
				System.out.println("JSESSIONID :: "+session.getId());				
			}
		} catch (SQLException e) {		
			System.out.println(e);
		}
		
		
		return new ModelAndView(path);
	}

}
