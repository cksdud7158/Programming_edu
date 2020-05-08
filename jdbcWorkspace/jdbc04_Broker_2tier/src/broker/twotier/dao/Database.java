package broker.twotier.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.DuplicateFormatFlagsException;
import java.util.Vector;

import broker.twotier.exception.DuplicateSSNException;
import broker.twotier.vo.CustomerRec;
import broker.twotier.vo.ShresRec;
import broker.twotier.vo.StockRec;
import config.ServerInfo;

public class Database implements DatabaseTemplate{
	
	public Database(String serverIP) throws ClassNotFoundException{
		Class.forName(ServerInfo.DRIVE_NAME);
		System.out.println("Drive Loading");
	}
	
	//공통적인 로직
	@Override
	public Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		return conn;
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps!=null)ps.close();
		if(conn!=null)conn.close();
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs!=null) rs.close();
		closeAll(ps, conn);
	}

	@Override
	public void addCustomer(CustomerRec cust) throws SQLException, DuplicateSSNException{
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			
			if(!isExist(cust.getSsn(), conn)) { //ssn이 없는거야...
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
	public void deleteCustomer(String ssn) throws SQLException, DuplicateSSNException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			
			if(isExist(ssn, conn)) { 
				String query = "delete from customer where ssn =?";
				ps = conn.prepareStatement(query);
			
				ps.setString(1, ssn);
				System.out.println(ps.executeUpdate()+"삭제 완료");
			}else { //ssn이 있는거야...
				throw new DuplicateSSNException("해당 회원이 존재하지않습니다.");
			}			
		}finally {
			closeAll(ps, conn);
		}
	}

	@Override
	public void updateCustomer(CustomerRec cust) throws SQLException, DuplicateSSNException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			
			if(isExist(cust.getSsn(), conn)) { //ssn이 없는거야...
				String query = "update customer set cust_name=?, address=? where ssn=?";
				ps = conn.prepareStatement(query);
				
				ps.setString(1, cust.getName());
				ps.setString(2, cust.getAddress());
				ps.setString(3, cust.getSsn());
				
				System.out.println(ps.executeUpdate()+"정보 변경 완료");
			}else { //ssn이 있는거야...
				throw new DuplicateSSNException(cust.getName()+" 님은 존재하지않습니다. ");
			}			
		}finally {
			closeAll(ps, conn);
		}
		
	}

	@Override
	public Vector<ShresRec> getPortfolio(String ssn) throws SQLException, DuplicateSSNException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Vector<ShresRec> portfolio = new Vector<>();
		try {
			conn = getConnect();
			
			if(isExist(ssn, conn)) { 
				String query = "select * from shares where ssn=? ";
				ps = conn.prepareStatement(query);
				ps.setString(1, ssn);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					portfolio.add(new ShresRec(ssn, 
							rs.getString("symbol"), 
							rs.getInt("quantity")));
				}
			}else { 
				throw new DuplicateSSNException("구매 하신 주식이 없습니다. ");
			}			
		}finally {
			closeAll(ps, conn);
		} return portfolio;
	}

	@Override
	public CustomerRec getCustomer(String ssn) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		CustomerRec cust = null;
		try {
			conn = getConnect();
			if(isExist(ssn, conn)) { 
				String query = "select * from customer where ssn=? ";
				ps = conn.prepareStatement(query);
				ps.setString(1, ssn);
				rs = ps.executeQuery();
				
				if(rs.next()) {
					cust.setName(rs.getString("cust_name"));
					cust.setSsn(ssn);
					cust.setAddress(rs.getString("address"));
				}
			}else { 
				throw new DuplicateSSNException("");
			}			
		}finally {
			closeAll(ps, conn);
		} return portfolio;
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
	
	public boolean isExist(String ssn, Connection conn) throws SQLException{
		String sql =  "select ssn from customer where ssn=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, ssn);
		ResultSet rs = ps.executeQuery();
		return rs.next();
	}

}
