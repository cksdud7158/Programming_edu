/*
 * 요청이 들어왔을 때 첫번째 서블릿 
 * ::
 * 1. 쿠키 생성 : Cookie c = new Cookie("name","value");
 * 2. 생성한 쿠키를 웹브라우저로 보냄.. response.addCookie();
 * 
 */
package servlet.cookie;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class setCookieTest extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
 
    public setCookieTest() {
        super();
       
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date now = new Date();
		String id = "ENCORE";
		
		String s = now.toString();
		System.out.println(s);
		//1. 쿠키생성
		Cookie c1 = new Cookie("now",URLEncoder.encode(s,"UTF-8"));
		Cookie c2 = new Cookie("id", id);
		System.out.println(c1+",,,,,,,"+c2);
		//2.쿠키의 유효시간을 지정, 하루로 지정 
		c1.setMaxAge(24*60*60);
		//c1.setMaxAge(2*24*60*60); // 2day
		c2.setMaxAge(0); // 쿠키 사용하지않겠다. 
		
		//3. 쿠키를 전송 
		response.addCookie(c1);
		response.addCookie(c2);
		
		//4. 페이지 이동 getCookieTest
		response.sendRedirect("GetCookieTest");
	}

}
















