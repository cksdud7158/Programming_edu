package jdbc.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import config.ServerInfo;

public class TXCommitTest1 {

	public static void main(String[] args) throws Exception{
		Class.forName(ServerInfo.DRIVE_NAME);
		System.out.println("Driver Loading");
		
		Connection conn = 
				DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		System.out.println("DB Server Connection");
		
		String query1= "insert into encore(name) values(?)";
		String query2= "select no, name from encore where no=?";
		
		//setAutocommit을 false로 해서 트랙잭션을 실행
		// 트랜잭션을 처리하는 메서드는 connection이 갖고 있다. 
		// 트랜잭션 시작
		conn.setAutoCommit(false);
		
		PreparedStatement ps = conn.prepareStatement(query1);
		ps.setString(1, "전지현");
		ps.executeUpdate();
		
		// 실행 실패 시 rollback
		// 성공시 commit
		PreparedStatement ps2 = conn.prepareStatement(query2);
		ps2.setInt(1, 3); // 기존에 no가 3이기에 4까지만 나와야 하지만 7을 넣어서 오류발생, 이를 확인
		ResultSet rs = ps2.executeQuery();
		 
		if(!rs.next()) {// 레코드가 존재하지 않는다면
			conn.rollback();
			System.out.println("찾는 번호의 해당하는 회원이 없어서 rollback ");
		}else {// 레코드가 존재한다면
			conn.commit();
			System.out.println("번호에 해당하는 회원 발견 commit");
		}
		//트랜잭션 처리를 다시 원래대로 돌려 놓음
		conn.setAutoCommit(true);
		
	}	
}
