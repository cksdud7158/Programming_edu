package servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
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
		//hidden 값으로 들어온 요청을 받지 않고 들어온 요청의 주소를 직접 인식시킨다. 
		String RequestURI = request.getRequestURI();
		System.out.println(RequestURI);
		
		String ContextPath=request.getContextPath();
		System.out.println(ContextPath);
		
		//find.do 만 추출하자  substring() 사용
		String command = RequestURI.substring(ContextPath.length()+1);
		System.out.println(command);
		
		
		Controller controller= HandlerMapping.getInstance().createController(command);
		String path = "index.jsp";
		ModelAndView mv = null;
		
		try {
			mv = controller.handle(request, response);
			path = mv.getPath();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		if(mv!=null) {
			if(mv.isRedirect()) {
				response.sendRedirect(path);
			}
			else {
				request.getRequestDispatcher(path).forward(request, response);
			}
		}
		

	}
}












