package servlet.first;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WordEncoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WordEncoreServlet() {
       super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1. 폼값을 받아서
		 * 2. 받은 값을 수정한 후 
		 * 3. 다시 웹브라우저로 전송 출력
		 */
		
		String wName= request.getParameter("word"); // 인자 값은 폼의 이름을 스트링으로 받음
		wName = wName+"Update";
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>"); // 브라우저로 응답 -> 출력 
		out.println("<h2>Client 에서 보내온 값입니다. </h2>");
		out.println(wName+"</body> </html>");
		
		out.close();
	}


}
