package jdbc.step1;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * JDBC 작업 4단계
 * 1. 드라이버를 로딩(클라이언트 메모리단에 올리기)
 * 2. DB 서버와 연결 - jdbc:mysql://ip:3306/scott   ( 앞에는 프로토콜이 오고 뒤에는 IP주소and 포트 받음)
 * 	  Connection 리턴
 * 3. query를 준비시킴
 * 	  PreparedStatement st = conn.prepareStatement("sql query");
 * 4. 값이 바인딩 + 쿼리문이 실행 -- 실제로 DB서버에 값을 추가/삭제/수정/가지고옴
 * 	1) ?에 해당하는 값을 먼저 바인딩
 *  2) 쿼리문 실행
 * 	  st.executeUpdate() : int -- insert/delete/update
 * 	  st.executeQuery() : ResultSet -- select
 */
public class DBConnectionTest1 {
	public DBConnectionTest1() {
		try {
			//1. 
			Class.forName("com.mysql.cj.jdbc.Driver"); //FQCN : Fully qualified name
			System.out.println("Driver Loading Succes");
			
			//2. 
			String url ="jdbc:mysql://127.0.0.1:3306/scott?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
			Connection conn = DriverManager.getConnection(url, "root", "1234");
			System.out.println("DB Connection Succes");
			
			//3.
			String query ="INSERT INTO person(ssn, name, address) VALUES(?,?,?)";
			PreparedStatement st = conn.prepareStatement(query);
			System.out.println("Creating PreParedStatement");
			
			//4.
			st.setInt(1, 111);
			st.setString(2, "박찬영");
			st.setString(3, "역삼동");
			
			int row =st.executeUpdate();
			System.out.println(row+"명 추가됨");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Loading fail");
		} catch(SQLException e) {
			System.out.println("DBConnection fail");
		}
	}
	
	public static void main(String[] args) {
		new DBConnectionTest1();
	}

}
