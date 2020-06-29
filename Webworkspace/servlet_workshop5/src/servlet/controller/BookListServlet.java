package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.BookVO;
import servlet.model.UserDAOImpl;

public class BookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public BookListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			ArrayList<BookVO> list = UserDAOImpl.getInstance().bookList();
			request.setAttribute("list", list);
			request.getRequestDispatcher("BookList.jsp").forward(request, response);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
