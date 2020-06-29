package servlet.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class AllMemberController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path="allView.jsp";
		try {
			ArrayList<MemberVO> list=MemberDAOImpl.getInstance().showAllMember();
			request.setAttribute("list", list);
			
		}catch(SQLException e) {
			
		}
		
		
		return new ModelAndView(path);
	}
	
}
