/*
 * 서블릿 필드값 count 값을 영구적으로 보관할 수 있는 방법은 지금으로서는 없다. 
 * 왜냐하면 서버가 stop 되는 순간 destory() callback 함수가 자동으로 호출 되어지고,
 * 서블릿인스턴스를 메모리에서 unbound 시켜버리기 때문이다.
 * 
 * 서버가 내려가더라도 서비스를 수행한 후 필드에 저장시킨 값을 영구적으로 보관하려면 
 * 1) DB에 보관
 * 2) 파일에 보관
 * 
 * 이떄 서블릿 라이플 사이클 메소드가 중요하게 사용되어진다.
 * 1) 해당 필드값을 파일로 출력 
 * 2) 파일에 저장된 값을 불러 읽어와야한다. 
 * 
 * 서블릿 라이플 싸이클 메소드
 * init() ----- 2)
 * 
 * 
 * destory() ----- 1)
 * 
 */
package servlet.life;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletLifeCycleTest3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count=0; //필드..
	private String path= "c:\\filestore\\life\\count.txt";
	
	
    public ServletLifeCycleTest3() {
        super();
        System.out.println("1. ServletLifeCycleTest1..call by contanier");
    }

	
	public void init() throws ServletException {
		System.out.println("2. init..call by contanier");
		
		//서버가 다시 시작될 때 init() 에서 파일에 저장된 내용을 읽어서 필드 count 에 다시 할당 
		try {
				BufferedReader br = new BufferedReader(new FileReader(path));
				String str = br.readLine();
				count= Integer.parseInt(str);
				
				System.out.println("파일을 읽어드림 count : "+count);
				br.close();
		} catch (Exception e) {
			System.out.println("파일을 읽어들이는데 실패 ");
		}
	}

	
	public void destroy() {
		System.out.println("4. destroy..call by contanier");
		
		// 필드에 저장된 값을 파일로 뿌리고 서버가 내려질것이다. 
		File file = new File(path);
		// 출력용 파일이 출력 스트림에서 자동적으로 생성되려면 그전에 반드시 폴더가 먼저 만들어져 있어야한다. 
		file.getParentFile().mkdirs(); // 파일을 제외한 폴더를 만들어 준다. 
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(file));
			pw.println(count);
			pw.close();
			
			/*PrintWriter pw = new PrintWriter(new FileWriter(file,true),true); // 앞 true 는 이어쓰기 안하면 자동으로 덮어 쓰기됨, 뒤는 close() 안써도 됨 
			pw.println(count);*/
			
			System.out.println(path+" count 값 :: "+ count+"파일에 영구적으로 저장됨 ");
		} catch (Exception e) {
			System.out.println("스트림 생성 실패");
		}
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("3. service..call by contanier");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		
		out.println("<html><body bgcolor=cyan>");
		out.println("<h2>ServletCOnfig</h2>");
		out.println("<b>Count :: <b>"+ ++count);
		out.println("</body></html>");
		
		
		out.close();
	}

}


