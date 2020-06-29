package servlet.controller;

public class HandlerMapping {
	private static HandlerMapping handler = new HandlerMapping();
	private HandlerMapping() {};
	public static HandlerMapping getInstance() {
		return handler;
	}
	
	public Controller createController(String command) {
		Controller controller = null;
		
		if(command.equals("find.do")) {
			controller = new FIndController();
			System.out.println("FIndCOntroller 생성됨");
		}else if(command.equals("allmember.do")){
			controller = new AllMemberController();
		}else if(command.equals("login.do")){
			controller = new LoginController();
		}else if(command.equals("register.do")){
			controller = new RegisterController();
		}else if(command.equals("idCheck.do")){
			controller = new IdCheckController();
		}else if(command.equals("logout.do")){
			controller = new LogoutController();
		}else if(command.equals("update.do")){
			controller = new UpdateController();
		}
		return controller;
	}
	
}
