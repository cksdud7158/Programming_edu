package servlet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import servlet.error.DuplicateSSNException;




public class DAO {
	private static DAO dao = new DAO();
	private DataSource ds;
	
	private DAO() {
		try {
			//Naming Service(JNDI API)....javax.naming.Context.
			InitialContext ic = new InitialContext();
			
			ds=(DataSource) ic.lookup("java:comp/env/jdbc/mysql");
			System.out.println("DataSource Look up 성공");
		} catch (NamingException e) {
			System.out.println("DataSource Look up 실패");
		}
	}
	
	public static DAO getInstance() {
		return dao;
	}
	
	public Connection getConnection() throws SQLException {
		System.out.println("Database Connection......");
		
		return ds.getConnection(); // 공장에서 하나의 connection을 빌려서 나온다. 
	}

	public void closeAll(PreparedStatement ps, Connection co) throws SQLException {
		if(ps!=null) ps.close();
		if(co!=null) co.close();	
	}


	public void closeAll(ResultSet rs, PreparedStatement ps, Connection co) throws SQLException {
		if(rs!=null) rs.close();
		closeAll(ps, co);	
	}
	
	public boolean isExist(String isbn, Connection conn)throws SQLException {
		//있는지 없는지 존재유무 확인...
		
		String sql ="SELECT bookNum FROM book WHERE bookNum=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1,isbn);
		ResultSet rs = ps.executeQuery();
		return rs.next();
	}	

	public void registerBook(BookVO book) throws SQLException, DuplicateSSNException {
		
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			
			if(!isExist(book.getIsbn(), conn)) { // 없다면
			String query = "insert into book(isbn, title, catalogue, nation, publish_date, publisher, author, price, description) values(?,?,?,?,?,?,?,?,?);";
			ps = conn.prepareStatement(query);
		
			ps.setString(1, book.getIsbn());
			ps.setString(2, book.getTitle());
			ps.setString(3, book.getCatalogue());
			ps.setString(4, book.getNation());
			ps.setString(5, book.getPublish_date());
			ps.setString(6, book.getPublisher());
			ps.setString(7, book.getAuthor());
			ps.setInt(8, book.getPrice());
			ps.setString(9, book.getDescription());
			
			System.out.println(ps.executeUpdate()+" 명 INSERT OK....addCustomer()...");	
			}else {
				throw new DuplicateSSNException(book.getIsbn()+" 은 이미 존재합니다...");
			}
		}finally {
			closeAll(ps, conn);
		}	
	}
}





