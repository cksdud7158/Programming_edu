package jdbc.step1.simple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;

/*
 * 구조적으로 작성할 예정
 * 1. 드라이버 로딩 
 * 2. DB 연결
 * 3. PreparedStatement 생성
 * 4. 쿼리문 실행
 * 5. close
 * 
 * 메소드마다 동일한 부분이 반복되는 것은 비효율적이다.
 * 반복
 * 1) 고정적인 반복 -- DB 연결 , 자원 반납 -- 공톡적인 메소드로 정의 ..메소드 마다 호출해서 사용
 * 2) 변동적인 반복 
 * 
 */
public class SimpleMVCPersonTest {
	// 공통적인 부분 정의
		public Connection getConnect() throws SQLException{
			Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
			System.out.println("Database Connection");
			return conn;
		}
		
		public void closeAll(PreparedStatement ps,Connection conn)throws SQLException {
			if(ps!=null)ps.close();
			if(conn!=null)conn.close();
		}
		
		public void closeAll(PreparedStatement ps,Connection conn, ResultSet rs)throws SQLException {
			if(rs!= null) rs.close();
			closeAll(ps, conn);
		}
	
// 비즈니스 로직...DAO(Database Acess Object)
	public void addPerson(int ssn, String name, String address) throws SQLException {
		//DB 연결, PreparedStatement 생성, 쿼리문 실행,close
		
		
		Connection conn= getConnect();
		String query = "INSERT INTO person(ssn,name, address) VALUES(?,?,?)";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setInt(1, ssn);
		ps.setString(2, name);
		ps.setString(3, address);
		
		ps.executeUpdate();
		System.out.println(name+"님, 회원가입되셨습니다.");
		
		closeAll(ps, conn);
		
	}
	
	public void removePerson(int ssn) throws SQLException {
		//DB 연결, PreparedStatement 생성, 쿼리문 실행,close
		Connection conn = null;
		PreparedStatement ps = null;
		conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		String query = "delete from person where ssn=?";
		ps = conn.prepareStatement(query);
	
		ps.setInt(1, ssn);
		ps.executeUpdate();
		System.out.println("삭제 됬습니다.");
		
		closeAll(ps, conn);
	}
	
	public void updatePerson(int ssn, String name, String address) throws SQLException {
		//DB 연결, PreparedStatement 생성, 쿼리문 실행,close
		Connection conn = null;
		PreparedStatement ps = null;
		conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		String query = "update person set name=?, address=? where ssn=?";
		ps = conn.prepareStatement(query);
	
		ps.setString(1, name);
		ps.setString(2, address);
		ps.setInt(3, ssn);
		ps.executeUpdate();
		System.out.println("정보가 변경됬습니다. ");
		closeAll(ps, conn);
	}
	
	public void searchAllPerson() throws SQLException {
		//DB 연결, PreparedStatement 생성, 쿼리문 실행,close
		Connection conn = null;
		PreparedStatement ps = null;
		conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		String query = "select * from person";
		ps = conn.prepareStatement(query);
	
		ResultSet rs= ps.executeQuery();
		while(rs.next()) {
			int ssn = rs.getInt("ssn");
			String name = rs.getString("name");
			String address = rs.getString("address");
			System.out.println(ssn+","+name+","+address);
		}
		closeAll(ps, conn, rs);
	}
	
	public void searchAPerson() {
		//DB 연결, PreparedStatement 생성, 쿼리문 실행,close
	}
	
	public static void main(String[] args){
		SimpleMVCPersonTest mvc = new SimpleMVCPersonTest();
		/*try {
			mvc.addPerson(444, "아이유", "제주도");//calling
		} catch (SQLException e) {
			System.out.println("회원 가입 실패");
		}*/
		
		/*try {
			mvc.removePerson(333);
		} catch (SQLException e) {
			System.out.println("삭제 실패");
		}*/
		/*try {
			mvc.updatePerson(222, "아야", "사가정");
		}catch(SQLException e) {
		System.out.println("정보 변경 실패");
		}*/
		try {
			mvc.searchAllPerson();
		} catch (SQLException e) {
			System.out.println("정보 읽어오기 실패");
		}
		
	}
	
	//static initialization block
	static {
		try {
			Class.forName(ServerInfo.DRIVE_NAME);
			System.out.println("Drive Loading..Success");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Loading..Fail");
		}
	}

}
