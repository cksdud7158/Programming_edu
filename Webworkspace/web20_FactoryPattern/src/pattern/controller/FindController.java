package pattern.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pattern.model.Dao;
import pattern.model.NoteBook;


public class FindController implements Controller{

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String model = request.getParameter("model");
		
		NoteBook nb= Dao.getInstance().findNoteBook(model);
		
		request.setAttribute("nb", nb);
		
		String path = "find_result.jsp";
		
		
		return path;
	}

}
