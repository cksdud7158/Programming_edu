package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;


@WebServlet("/front.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DispatcherServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청이 어디에서 들어온 요청인지 확인 command 값 받는다. 
		String command= request.getParameter("command");
		String path = "index.jsp";
		
		if(command.equals("register")) {
			path= register(request, response);
		}else if(command.equals("find")) {
			path= find(request, response);
		}else if(command.equals("idCheck")) {
			path= idCheck(request, response);
		}else if(command.equals("allView")) {
			path= allView(request, response);
		}else if(command.equals("loginForm")) {
			path= loginForm(request, response);
		}else if(command.equals("logout")) {
			path= logout(request, response);
		}
		

		request.getRequestDispatcher(path).forward(request, response);
		
	}


	private String logout(HttpServletRequest request, HttpServletResponse response) {
		String path="logout.jsp";
		//로그아웃 로직을 작성 
				HttpSession session = request.getSession();
				
				if(session.getAttribute("vo")!=null) { // 로그인한 상태라면
					session.invalidate();
				}
		return path;
	}

	private String loginForm(HttpServletRequest request, HttpServletResponse response) {
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
		return path;
	}


	private String allView(HttpServletRequest request, HttpServletResponse response) {
		String path="allView.jsp";
		try {
			ArrayList<MemberVO> list=MemberDAOImpl.getInstance().showAllMember();
			request.setAttribute("list", list);
		}catch(SQLException e) {
			
		}
		return path;
	}


	private String idCheck(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String id = request.getParameter("id");
		String path = "idcheck.jsp";
		try {
			boolean flag=MemberDAOImpl.getInstance().idExist(id);
			request.setAttribute("flag", flag);
		}catch(Exception e) {
			System.out.println(e);
		}
		return path;
	}


	private String find(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
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
		
		return path;
		
	}


	private String register(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String path = "AllMember";
		
		MemberVO pvo  = new MemberVO(id, password, name, address);
		try {
			MemberDAOImpl.getInstance().registerMember(pvo);
			
			//response.sendRedirect("AllMember?name="+name);
		}catch(SQLException e) {
			
		}
		return path;
	}

}
