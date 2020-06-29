package servlet.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class IdListController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path="show_idList.jsp";
		try {
			ArrayList<MemberVO> list=MemberDAOImpl.getInstance().showAllMember();
			request.setAttribute("list", list);
			
		}catch(SQLException e) {
			System.out.println("IdListController"+e);
		}
		
		
		return new ModelAndView(path);
	}

}
