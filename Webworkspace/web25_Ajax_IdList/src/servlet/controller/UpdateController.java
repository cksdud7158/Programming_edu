package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class UpdateController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		MemberVO pvo = new MemberVO(id, password, name, address);
		String path = "index.jsp";
		try {
			MemberDAOImpl.getInstance().updateMember(pvo);
			
			HttpSession session  = request.getSession();
			if(session.getAttribute("vo") !=null) {
				session.setAttribute("vo", pvo); //중요
				path = "update_result.jsp";
			}
			
			request.getRequestDispatcher(path).forward(request, response);
		}catch(Exception e) {
			
		}		
		return null;
	}
	
}
