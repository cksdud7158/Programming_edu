package broker.twotier.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import broker.twotier.exception.DuplicateSSNException;
import broker.twotier.vo.CustomerRec;
import broker.twotier.vo.ShresRec;
import broker.twotier.vo.StockRec;

public interface DatabaseTemplate {
	Connection getConnect() throws SQLException;
	void closeAll(PreparedStatement ps, Connection conn) throws SQLException;
	void closeAll(ResultSet rs,PreparedStatement ps, Connection conn) throws SQLException;
	
	//비즈니스 로직..CRUD
	void addCustomer(CustomerRec cust) throws SQLException, DuplicateSSNException;
	void deleteCustomer(String ssn) throws SQLException, DuplicateSSNException;
	void updateCustomer(CustomerRec cust) throws SQLException, DuplicateSSNException;
	
	Vector<ShresRec> getPortfolio(String ssn) throws SQLException, DuplicateSSNException;
	CustomerRec getCustomer(String ssn) throws SQLException;
	ArrayList<CustomerRec> getAllCustomers() throws SQLException;
	ArrayList<StockRec> getAllStocks() throws SQLException;
	
	//비즈니스 로직..특화된 로직
	void buyShares(String ssn, String symbol, int quantity) throws SQLException;
	void sellShares(String ssn, String symbol, int quantity) throws SQLException;
	
	
}



















