package servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class FIndController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id");
		String path = "find_fail.jsp";
		
		try {
			MemberVO vo=MemberDAOImpl.getInstance().findByIdMember(id);
			if(vo!=null) {
				request.setAttribute("vo", vo);
				path = "find_ok.jsp";
			}			
		}catch(SQLException e) {
			System.out.println(e);
		}
		
		return new ModelAndView(path);
	}

}
