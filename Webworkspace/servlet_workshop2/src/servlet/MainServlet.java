package servlet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String path;

    
    public MainServlet() {
        super();
        
    }
    
    @Override
    public void init() throws ServletException {
    	// 1. ServletConfig 기능을 이용해서 path 에 연결된 값을 받아온다.
    			path = getInitParameter("path");
    			System.out.println("init() call - "+ path);
    			try {
    				//2. BufferdReader를 사용해서 파일을 읽어들인다.
    				//3. count 값 초기화 
    				try {
    					BufferedReader br = new BufferedReader(new FileReader(path));
    					String str = br.readLine();
    					String line=" ";
    					for(int i=0; str!=null; i++) {
    			        	System.out.println(line);
    			         }
    					br.close();
    			} catch (Exception e) {
    				System.out.println("파일을 읽어들이는데 실패 ");
    			}
    			} catch (Exception e) {
    				System.out.println("읽는데 실패 ");
    			}
    	super.init();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
				
		PrintWriter out = response.getWriter();
		
		
		if(id.equals("encore") && password.equals("1234")) {
			out.println("<html><body>");
			out.println("<a href=loginSuccess?id="+id+"&password="+password+">로그인페이지로 이동<a>");
			out.println("</html></body>");
			
			out.close();
		}else {
			out.println("<html><body>");
			out.println("<h2>로그인 실패<h2>");
			out.println("<a href=http://localhost:8888/servlet_workshop1/index.html>로그인페이지로 가기<h2>");
			out.println("</html></body>");
			
			out.close();
		}
		
	}
}
