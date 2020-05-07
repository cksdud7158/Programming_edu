package jdbc.test;

import config.ServerInfo;
import jdbc.dao.impl.CustomerDAOImpl;

public class CustomerDAOTest {
	//static 초기화 블락...
	static {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("Driver Loading OK!!.....");
		}catch(ClassNotFoundException e) {
			System.out.println("Driver Loading Fail.....");
		}
	}
	public static void main(String[] args) {
		CustomerDAOImpl dao = CustomerDAOImpl.getInstance();
		//메소드 호출...할때 값 입력...해서 하나씩 완성해 나가보세요

	}
}





