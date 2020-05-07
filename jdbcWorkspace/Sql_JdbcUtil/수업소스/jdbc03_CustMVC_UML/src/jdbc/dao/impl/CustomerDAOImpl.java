package jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import jdbc.dao.CustomerDAO;
import jdbc.vo.Customer;
/*
 * dao란?
 * Database Access Object의 약자로...
 * 디비에 접근하는 로직(중요한 로직...일명 비지니스로직)을 담고 있는 객체이다.
 * ::
 * 공통적인 로직과 가변적인 로직 둘로 나눠어서 작성해준다.
 */
public class CustomerDAOImpl implements CustomerDAO{
	
	private static CustomerDAOImpl dao = new CustomerDAOImpl();
	private CustomerDAOImpl() {}
	public static CustomerDAOImpl getInstance() {
		return dao;
	}
	
	
   //공통적인 로직  //////////////////////////////////////////////
	@Override
	public Connection getConnect() throws SQLException {		
		return null;
	}
	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
				
	}
	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
				
	}
	
    //비지니스 로직 //////////////////////////////////////////////////
	@Override
	public void registerCustomer(Customer vo) throws SQLException {
		
	}

	@Override
	public void deleteCustomer(String id) throws SQLException {		
		
	}

	@Override
	public void updateCustomer(Customer vo) throws SQLException {		
		
	}

	@Override
	public Customer getCustomer(String id) throws SQLException {
		
		return null;
	}

	@Override
	public ArrayList<Customer> getAllCustomer() throws SQLException {
		
		return null;
	}

	@Override
	public Customer login(Customer vo) throws SQLException {
		
		return null;
	}
}
