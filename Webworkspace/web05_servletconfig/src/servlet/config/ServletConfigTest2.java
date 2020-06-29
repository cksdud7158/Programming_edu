package servlet.config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfigTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count = 0;
	private String path;
	
	public void init() throws ServletException {
		//1.ServletConfig의 기능을 사용해서 path에 연결된 값을 받아온다..		
		path = getInitParameter("path");
		System.out.println("init()..call..."+path);
		try {
			//2. BufferedReader를 사용해서 파일을 읽어들인다..
			//3. count값으로 필드 초기화
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line = br.readLine();
			count = Integer.parseInt(line);
			System.out.println("DD로 부터 읽어들인 값을 가지고 필드 초기화....:: count "+ count);
			br.close();
		}catch(Exception e) {
			System.out.println("파일을 읽어들이는데 실패...");
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로직은 여기다가...
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("userName");
		
		out.println("<h2>"+name+", "+count+"번째 고객닙이십니다!!</h2>");
		out.close();
	}
}






