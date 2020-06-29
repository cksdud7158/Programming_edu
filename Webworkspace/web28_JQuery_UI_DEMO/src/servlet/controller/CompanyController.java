package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CompanyController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CompanyController...진입 ");
		String result ="<ul><li> Tomato System</li><br/>"
				+ "<li> skdkasdkf System</li><br/>"
				+ "<li>뱁새공방 System</li><br/>"
				+ "<li>뱁새공방 System</li><br/>"
				+ "<li>뱁새공방 System</li><br/></ul>";
		
		request.setAttribute("result", result);
		return new ModelAndView("Result.jsp");
	}

}
