package pattern.factory;

import pattern.action.Action;
import pattern.action.AddAction;
import pattern.action.DeleteAction;
import pattern.action.UpdateAction;

/*
 * Action 들을 만들어 내는 공장 
 * Dispatcher 에서 보내주는 Command 값에 따라서 생성하는 Action 이 달라진다.
 * 
 */
public class ActionFactory {
	private static ActionFactory factory = new ActionFactory();
	private ActionFactory() {
		System.out.println("ActionFactory Creating");
	}
	
	public static ActionFactory getInstance() {
		return factory;
	}
	
	//Action을 생성하는 기능 
	public Action createAction(String command) {
		
		Action action = null;
		
		if(command.equals("INSERT")) {
			action= new AddAction();
		}else if(command.equals("DELETE")) {
			action= new DeleteAction();
		}else if(command.equals("UPDATE")) {
			action= new UpdateAction();
		}
		return action;
		
	}
}
