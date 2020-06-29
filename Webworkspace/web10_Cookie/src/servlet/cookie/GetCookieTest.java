package servlet.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 
 */
public class GetCookieTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public GetCookieTest() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.println("<h2> SetCookieTest 에서 설정한 쿠키의 정보를 받아옵니다.</h2>");
		Cookie[ ] cs = request.getCookies();
		
		out.println("받아온 쿠키 now : "+cs[0]);
		//out.println("받아온 쿠키 id "+cs[1]);
		
	}

}
