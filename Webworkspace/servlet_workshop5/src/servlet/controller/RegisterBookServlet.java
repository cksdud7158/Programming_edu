package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.BookVO;
import servlet.model.UserDAOImpl;

public class RegisterBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public RegisterBookServlet() {
        super();
       
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("여기서 받는다.");
		PrintWriter out = response.getWriter();
		
		//폼값 받는다.
		String isbn = request.getParameter("isbn1")+"-"+request.getParameter("isbn2")+"-"+request.getParameter("isbn3");
		String title = request.getParameter("title");
		String catalogue = request.getParameter("catalogue");
		String nation = request.getParameter("nation");
		String publish_date = request.getParameter("publish_date");
		String publisher = request.getParameter("publisher");
		String author = request.getParameter("author");
		int price = Integer.parseInt(request.getParameter("price"));
		String description = request.getParameter("description");
		
		
		System.out.println(isbn);
		System.out.println(publish_date);
		
		BookVO book = new BookVO(isbn, title, catalogue, nation, publish_date, publisher, author, price, description);
		
		try {
			UserDAOImpl dao = UserDAOImpl.getInstance();
			
			System.out.println(book);
			
			dao.registerBook(book);
			
			request.setAttribute("book", book);
			RequestDispatcher rdp = request.getRequestDispatcher("SuccessRegisterBook.jsp");
			rdp.forward(request, response);
		} catch (Exception e) {
			System.out.println("책 등록 실패했습니다. ");
		}finally {
			out.close();
		}
	}
}
