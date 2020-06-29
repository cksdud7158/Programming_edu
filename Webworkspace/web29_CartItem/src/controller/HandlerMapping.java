package controller;

public class HandlerMapping {
	private static HandlerMapping handler = new HandlerMapping();
	private HandlerMapping() {};
	public static HandlerMapping getInstance() {
		return handler;
	}
	
	public Controller createController(String command) {
		Controller controller = null;
		
		if(command.equals("itemList.do")) {
			controller = new getAllItemController();
			System.out.println("FIndCOntroller 생성됨");
		}else if(command.equals("itemView.do")) {
			controller = new getItemController();
			System.out.println("getItemController 생성됨");
		}
		
		return controller;
	}
	
}
