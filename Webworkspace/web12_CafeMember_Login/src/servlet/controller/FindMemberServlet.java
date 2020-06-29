package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.error.DuplicateSSNException;
import servlet.error.RecordNotFoundException;
import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class FindMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FindMemberServlet() {
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
			
		MemberDAOImpl dao = MemberDAOImpl.getInstance();

		try {
			MemberVO vo = dao.findById(id);
			request.setAttribute("vo", vo);
			request.getRequestDispatcher("find_ok.jsp").forward(request, response);
		} catch (SQLException | RecordNotFoundException e) {
			System.out.println("해당 아이디는 존재하지않습니다..FindMemberServlet");
			request.getRequestDispatcher("find_fail.jsp").forward(request, response);
		}
	}

}
