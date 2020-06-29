package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.BookVO;


public class RegisterBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegisterBook() {
        super();
       
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		String bookNum = request.getParameter("bookNum");
		String bookName = request.getParameter("bookName");
		String bookCategory = request.getParameter("bookCategory");
		String publishingCountry = request.getParameter("publishingCountry");
		String publishingDate = request.getParameter("publishingDate");
		String publisher = request.getParameter("publisher");
		String author = request.getParameter("author");
		int bookPrice = Integer.parseInt(request.getParameter("bookPrice"));
		String summaryContext = request.getParameter("summaryContext");
		
		BookVO book = new BookVO(bookNum, bookName, bookCategory, publishingCountry, publishingDate, publisher, author, bookPrice, summaryContext);
		
		request.setAttribute("book", book);
		RequestDispatcher rdp = request.getRequestDispatcher("SuccessRegisterBook.jsp");
		rdp.forward(request, response);
		
		out.close();
		
	}

}
