package jdbc.test;

import java.sql.SQLException;

import config.ServerInfo;
import jdbc.dao.impl.CustomerDAOImpl;
import jdbc.vo.Customer;
/* 
 * DB에 있는 데이타를 CRUD를 핸들링할 때 데이타의 존재 유무를 사전에 항상 확인해야함
 */
public class CustomerDAOTest {
	// static 초기화 블락
	static {
		try {
			Class.forName(ServerInfo.DRIVE_NAME);
			System.out.println("Driver Loading OK");
		}catch(ClassNotFoundException e) {
			System.out.println("Driver Loading Fail");

		}
	}
	public static void main(String[] args) {
		CustomerDAOImpl dao = CustomerDAOImpl.getInstance();
		//메소드 호출... 할때 값 입력 해서 하나씩 완성
		/*try {
			dao.registerCustomer(new Customer("2", "1234", "박찬영", "사가정"));
		} catch (SQLException e) {
			System.out.println("회원 가입 실패");
		}*/
		/*try {
			dao.deleteCustomer("cksdud");
		} catch (SQLException e) {
			System.out.println("삭제 실패");
		}*/
		/*try {
			dao.updateCustomer(new Customer("2", "1234", "다른사람", "여긴어디"));
		} catch (SQLException e) {
			System.out.println("변경 실패");
		}*/
		/*try {
			System.out.println(dao.getCustomer("1"));
		} catch (SQLException e) {
			System.out.println("불러오기 실패");
		}*/
		/*try {
		System.out.println(dao.getAllCustomer());
		} catch (SQLException e) {
		System.out.println("불러오기 실패");
		}*/
		try {
			System.out.println(dao.login(new Customer("1", "1234")));
			} catch (SQLException e) {
			System.out.println("불러오기 실패");
			}
		
		
	}

}
