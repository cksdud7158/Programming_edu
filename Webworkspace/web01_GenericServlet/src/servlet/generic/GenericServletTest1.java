package servlet.generic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class GenericServletTest1 extends GenericServlet {
	/* 클라이언트가 요청을 하면 호출되는 메소드 
	 * 이떄 클라이언트의 요청 정보를 ServletRequest 에 저장 --브로커의 Command
	 * 요청을 수행한 후 응답할 정보를 ServletResponse에 저장  -- Command 안의 Result
	 *  */
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// 요청을 받았다 치고  응답만 해보겠다. 브라우저로 응답
		PrintWriter out = res.getWriter(); 
		out.println("<html><body bgcolor='yellow'>"); // 브라우저로 응답 -> 출력 
		out.println("<h2>hello</h2>");
		out.println("</body> </html>");
		
		out.close();
	}	
}

// http://127.0.0.1:8888/web01_GenericServlet/GenericServletTest1
