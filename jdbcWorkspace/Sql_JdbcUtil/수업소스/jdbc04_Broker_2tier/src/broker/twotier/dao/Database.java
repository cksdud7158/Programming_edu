package broker.twotier.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import broker.twotier.exception.DuplicateSSNException;
import broker.twotier.vo.CustomerRec;
import broker.twotier.vo.SharesRec;
import broker.twotier.vo.StockRec;
import config.ServerInfo;

public class Database implements DatabaseTemplate{
	
	public Database(String serverIp) throws ClassNotFoundException{
		Class.forName(ServerInfo.DRIVER_NAME);
		System.out.println("드라이버 로딩 성공....");
	}
	//공통적인 로직....
	@Override
	public Connection getConnect() throws SQLException {
		Connection conn =DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
		System.out.println("Database Connection......");
		return conn;
	}
	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();		
	}
	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs!=null) rs.close();
		closeAll(ps, conn);	
	}
	
	public boolean isExist(String ssn)throws SQLException {
		//있는지 없는지 존재유무 확인...
		Connection conn = getConnect();
		
		String sql ="SELECT ssn FROM customer WHERE ssn=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1,ssn);
		ResultSet rs = ps.executeQuery();
		return rs.next();
	}	
	
	@Override
	public void addCustomer(CustomerRec cust) throws SQLException, DuplicateSSNException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			
			if(!isExist(cust.getSsn())) { //ssn이 없는거야...
				String query = "INSERT INTO customer(ssn, cust_name, address) VALUES(?,?,?)";
				ps = conn.prepareStatement(query);
			
				ps.setString(1, cust.getSsn());
				ps.setString(2, cust.getName());
				ps.setString(3, cust.getAddress());
			
				System.out.println(ps.executeUpdate()+" 명 INSERT OK....addCustomer()...");
			}else { //ssn이 있는거야...
				throw new DuplicateSSNException(cust.getName()+" 님은 이미 회원이십니다...");
			}			
			
		}finally {
			closeAll(ps, conn);
		}
	}

	@Override
	public void deleteCustomer(String ssn) throws SQLException {
		
		
	}

	@Override
	public void updateCustomer(CustomerRec cust) throws SQLException {

	}

	@Override
	public Vector<SharesRec> getPortfolio(String ssn) throws SQLException {
		
		return null;
	}

	@Override
	public CustomerRec getCustomer(String ssn) throws SQLException {
		
		return null;
	}

	@Override
	public ArrayList<CustomerRec> getAllCustomers() throws SQLException {
		
		return null;
	}

	@Override
	public ArrayList<StockRec> getAllStocks() throws SQLException {
		
		return null;
	}

	@Override
	public void buyShares(String ssn, String symbol, int quantity) throws SQLException {
		
		
	}

	@Override
	public void sellShares(String ssn, String symbol, int quantity) throws SQLException {
		
		
	}

}
