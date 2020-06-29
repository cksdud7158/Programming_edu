package servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AjaxServlet")
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("userId");
		// 탁구공(xhr)이 대서양 건널때 delay 시키는 로직 ...readyState 값이 2,3 인 경우를 볼 수 있도록 설정 
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		out.print(id);
		
	}

}