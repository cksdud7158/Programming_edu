package servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddressAjax")
public class AddressAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HashMap map = new HashMap<>();
 
    public AddressAjax() {
        super();
    }

    //디비 연결하는 대신에 Map을 이용해서 각 선수들의 address 를 맵핑 시키겠다. 
	public void init() throws ServletException {
		map.put("이용규", "addr1");
		map.put("김태균", "addr2");
		map.put("루현진", "addr3");
		map.put("푸이그", "addr4");
		map.put("커쇼", "addr5");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html);charset=utf-8");
		
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		
		out.print(map.get(name));
	}

}
