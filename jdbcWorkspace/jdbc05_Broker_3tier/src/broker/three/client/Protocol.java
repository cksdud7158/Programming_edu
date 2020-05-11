package broker.three.client;

import java.util.ArrayList;
import java.util.Vector;

import broker.three.exception.DuplicateSSNException;
import broker.three.exception.InvalidTransactionException;
import broker.three.exception.RecordNotFoundException;
import broker.threetier.vo.CustomerRec;
import broker.threetier.vo.ShresRec;
import broker.threetier.vo.StockRec;

/*
 * Database 와 비슷하면서 다른 놈
 */
public class Protocol { 
	public Protocol(String IP) {
		
	}
	
	
	public void addCustomer(CustomerRec cust) throws DuplicateSSNException{}
	public void deleteCustomer(String ssn) throws RecordNotFoundException {}
	public void updateCustomer(CustomerRec cust) throws RecordNotFoundException {}
	public Vector<ShresRec> getPortfolio(String ssn){
		return null;
	}
	public CustomerRec getCustomer(String ssn) {
		return null;
	}
	public ArrayList<CustomerRec> getAllCustomers() {
		return null;
		}
	public ArrayList<StockRec> getAllStocks() {
		return null;
		}
	public void buyShares(String ssn, String symbol, int quantity) {}
	public void sellShares(String ssn, String symbol, int quantity) throws InvalidTransactionException,RecordNotFoundException{}
	
}
