package jdbc.dao.impl;

import java.security.GeneralSecurityException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;
import jdbc.dao.CustomerDAO;
import jdbc.vo.Customer;

public class CustomerDAOImpl implements CustomerDAO{
	/*
	 * DAO 란?
	 * Database Acess Object
	 * 디비에 접근하는 로직 (중요한 로직... 일명 비지니스 로직)을 담고있는 객체이다.
	 * 공통적인 로직과 가변적인 로직 둘로 나뉘어서 작성해준다. 
	 */
	private static CustomerDAOImpl dao = new CustomerDAOImpl();
	private CustomerDAOImpl() {};
	public static CustomerDAOImpl getInstance() {
		return dao;
	}
	
	// 공통적인 로직
	@Override
	public Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		return conn;
	}

	@Override
	public void close(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps!=null)ps.close();
		if(conn!=null)conn.close();
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs!=null) rs.close();
		if(ps!=null)ps.close();
		if(conn!=null)conn.close();		
	}
	
	// 비지니스 로직
	@Override
	public void registerCustomer(Customer vo) throws SQLException {
		Connection conn = getConnect();
		String query = "INSERT INTO cust(id, pass,Cust_name, address) VALUES(?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, vo.getId());
		ps.setString(2, vo.getPass());
		ps.setString(3, vo.getName());
		ps.setString(4, vo.getAddress());
		
		ps.executeUpdate();
		System.out.println(vo.getName()+"님, 회원가입되셨습니다.");
		
		close(ps,conn);
	}

	@Override
	public void deleteCustomer(String id) throws SQLException {
		Connection conn = getConnect();
		String query = "delete from cust where id =?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1,id);
		ps.executeUpdate();
		System.out.println("삭제 완료");
		close(ps,conn);
	}

	@Override
	public void updateCustomer(Customer vo) throws SQLException {
		Connection conn = getConnect();
		String query = "update cust set pass=?,Cust_name=?, address=? where id=? ";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, vo.getPass());
		ps.setString(2, vo.getName());
		ps.setString(3, vo.getAddress());
		ps.setString(4, vo.getId());
		
		ps.executeUpdate();
		System.out.println("변경 완료");
		close(ps,conn);
	}

	@Override
	public Customer getCustomer(String id) throws SQLException {
		Connection conn = getConnect();
		Customer vo = null;
		String query = "select * from cust where id=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, id);
		ResultSet rs= ps.executeQuery();
		if(rs.next()) {
			vo = new Customer(id, 
					rs.getString("pass"), 
					rs.getString("Cust_name"), 
					rs.getString("address"));
		}
		closeAll(rs, ps, conn);
		return vo;
	}

	@Override
	public ArrayList<Customer> getAllCustomer() throws SQLException {
		Connection conn = getConnect();
		ArrayList<Customer> avo = new ArrayList<>();
		String query = "select * from cust";
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs= ps.executeQuery();
		while(rs.next()) {
			avo.add(new Customer(rs.getString("id"), 
					rs.getString("pass"), 
					rs.getString("cust_name"), 
					rs.getString("address")));
		}
		closeAll(rs, ps, conn);
		return avo;
	}

	@Override
	public Customer login(Customer vo) throws SQLException {
		Connection conn = getConnect();
		Customer vo1 =null;
		String query = "select * from cust where id=? and pass=?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, vo.getId());
		ps.setString(2, vo.getPass());
		
		ResultSet rs= ps.executeQuery();
		while(rs.next()) {
			vo1= new Customer(rs.getString("id"), 
					rs.getString("pass"),
					rs.getString("cust_name"),
					rs.getString("address"));
		}
		closeAll(rs, ps, conn);
		return vo1;
	}
	

}
