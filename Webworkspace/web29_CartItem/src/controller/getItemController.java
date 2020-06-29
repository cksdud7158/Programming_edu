package controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Item;
import model.ItemDAO;

public class getItemController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String path ="itemView.jsp";
		int itemNumber = Integer.parseInt(request.getParameter("itemNumber"));
		System.out.println("getItemController::"+itemNumber);
		Item item = ItemDAO.getInstance().getItem(itemNumber);
		
		//오늘 본 상품 정보를 저장하는 쿠키 로직을 추가 
		// 1) 쿠기 생성 + 생성한 쿠키를 웹브라우저로 보냄 
		Cookie cookie = new Cookie("fruitshop"+itemNumber, item.getUrl());
		cookie.setMaxAge(24*60*60);
		response.addCookie(cookie);
		
		request.setAttribute("item", item);
		
		return new ModelAndView(path);
	}

}
