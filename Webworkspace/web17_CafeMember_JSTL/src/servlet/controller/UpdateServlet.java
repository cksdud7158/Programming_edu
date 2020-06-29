package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;


public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public UpdateServlet() {
        super();
       
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1.폼값을 받는다.
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		HttpSession session = request.getSession();
		MemberVO vo = (MemberVO) session.getAttribute("vo");
		//2. vo 생성 pvo
		MemberVO pvo = new MemberVO(vo.getId(), password, name, address);
		//3. DAO 리턴받아 비즈니스 로직 호출
		
		try {
			MemberDAOImpl dao = MemberDAOImpl.getInstance();
			dao.updateMember(pvo);
			//4. 수정된 정보를 반드시 세션에 바인딩 
			if(vo!=null) {
				session.setAttribute("vo", pvo);
			}
			//5. 네비게이션  update_result.jsp
			request.getRequestDispatcher("update_result.jsp").forward(request, response);
		} catch (SQLException e) {
			System.out.println("회원정보 변경 실패");
		}
		
		
		
		
	}

}
