package servlet.generic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class GenericServletTest2 extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    public GenericServletTest2() {
        super();
    }

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// PrintWriter
		PrintWriter out =response.getWriter();
		
		out.println("<html><body bgcolor='blue'>"); // 브라우저로 응답 -> 출력 
		out.println("<h2>hello</h2>");
		out.println("</body> </html>");
		
		out.close();
	}
}

/*
 * xml 파일 
 * 서블릿 인스턴스 매핑정보  -> was 
 *  FQCN : servlet.generic.GenericServletTest2
 *  Server 내부이름 매핑 : GenericServletTest2
 *  클라이언트 url 매핑 : GS2
 */
