package servlet.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberVO;

public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ProductServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		// 1. 기존의 세션을 받아온다
		HttpSession s = request.getSession(false);
		// 2. 세션에 바인딩된 값이 있다면.. 그 값을 찾아온다. 
		if(s.getAttribute("vo") != null) { // 로그인 성공 했다면
			
			MemberVO vo = (MemberVO) s.getAttribute("vo");
			// 3. 2번에서 받아온 정보를 여기서 출력 해봄.. 세션의 jSessionid 값도 출력.. 기존것과 동일한지 확인 
			out.println(vo);
			out.println(s.getId());
			// 4. 상품정보를 하나 세션에 다시 바인딩
			String product = "상품";
			request.setAttribute("product", product);
			// 5. 네이게이션 href= CartServlet 
			out.println("<a href= CartServlet> CartServlet <a>");
		}else {
			out.println("<h2>로그인 실패됬습니다.</h2>");
			out.println("<a href= login.html> Login 페이지로 이동 <a>");
		}
		
		
		
		
	}

}
