package broker.twotier.test;

import java.sql.SQLException;
import java.util.DuplicateFormatFlagsException;

import broker.twotier.dao.Database;
import broker.twotier.vo.CustomerRec;

public class DatabaseTest {

	public static void main(String[] args) throws Exception {
		Database db = new Database("127.0.0.1");
		//db.addCustomer(new CustomerRec("1234", "아이유", "서초동"));
		//db.deleteCustomer("1234");
		//db.updateCustomer(new CustomerRec("1234-1234", "박찬영", "사가정"));
		System.out.println(db.getPortfolio("1234"));
	}
}
