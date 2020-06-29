package servlet.http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HttpServletTest() {
        super();
       
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>"); // 브라우저로 응답 -> 출력 
		out.println("<h2>hello HttpServley</h2>");
		out.println("</body> </html>");
		
		out.close();
	}

	
	

}
