package jdbc.step3;
/*
 * Step2 에서는 DB서버에 대한 정보가 프로그램상에 하드코딩 되어져 있다. 
 * 따라서 별도의 모듈에 DB서버에 대한 정보를 뽑아내어서 별도로 처리 
 * MetaData화 시킨다. 
 * 인터페이스 - Properties 파일- XML
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;
import query.PersonSQL;

public class DBConnectionTest1 {
	
	public DBConnectionTest1() throws ClassNotFoundException, SQLException {
		
		//1. 드라이버 로딩
		Class.forName(ServerInfo.DRIVE_NAME); //Driver FQCN
		System.out.println("Driver Loading");
		
		//2. 디비 연결 - getConnection
		Connection conn=  DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		System.out.println("DB 연결 성공");
		
		/*//3. 쿼리 준비
		String query = "INSERT INTO person(ssn,name,address)VALUES(?,?,?)";
		PreparedStatement st = conn.prepareStatement(query);
		System.out.println("PreparedStatement 생성 성공");
		
		//4.?에 값을 바인딩하고 |쿼리문을 실행
		st.setInt(1, 333);
		st.setNString(2, "나나");
		st.setString(3, "사가정");
		System.out.println(st.executeUpdate());*/
		
	/*	//delete....333번을 삭제 
		String query= "DELETE FROM person where ssn=?";
		PreparedStatement st = conn.prepareStatement(query);
		
		st.setInt(1, 333);
		System.out.println(st.executeUpdate());*/
		
	/*	//update....111번에 대한 정보를 수정
		String query= "update person set name=?, address=? where ssn=?";
		PreparedStatement st = conn.prepareStatement(query);

		st.setString(1, "박나리");
		st.setString(2, "서초동");
		st.setInt(3, 111);
		System.out.println(st.executeUpdate());*/
		
		//select .... 모든 레코드를 다 가져온다. 
		PreparedStatement st = conn.prepareStatement(PersonSQL.ALL_PERSON);
		
		ResultSet rs=st.executeQuery();
		while(rs.next()) {
			int ssn = rs.getInt("ssn"); //getInt(1)도 가능
			String name = rs.getString("name");
			String addr= rs.getString("address");
			System.out.println(ssn+","+name+","+addr);
		}
		
		//5. 자원 반납...자원을 열어서 사용한 순서 반대로 닫는다. 
		st.close();
		conn.close();
		

	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		new DBConnectionTest1();
	}

}
