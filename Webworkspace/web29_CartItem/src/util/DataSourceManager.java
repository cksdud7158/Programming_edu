package util;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/*
 * JNDI API 를 이용해서 DataSource를 리턴받아온다.
 * 싱글톤 구사 
 * 
 */
public class DataSourceManager {
	private DataSource ds;
	
	// 싱글톤
	private static DataSourceManager instance = new DataSourceManager();
	private DataSourceManager() {
		// InitialContext 객체의 lookup() 을 이용해서 하나 받아오는 로직
		try {
			//Naming Service(JNDI API)...javax.naming.Context
			InitialContext ic = new InitialContext();			
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/mysql");
			System.out.println("DataSource  Lookup 성공...");
		}catch(NamingException e) {
			System.out.println("DataSource  Lookup 실패...");
		}
	}
	public static DataSourceManager getInstance() {
		return instance;
	}
	
	public DataSource getConnection() {
		return ds; 
	}
}
