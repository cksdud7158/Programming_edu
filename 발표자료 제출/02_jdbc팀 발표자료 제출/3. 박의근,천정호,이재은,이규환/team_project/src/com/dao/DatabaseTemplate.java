package com.dao;

import java.sql.Connection;
import java.util.ArrayList;

import com.vo.CowRec;
import com.vo.CustomerRec;
import com.vo.FarmerRec;


public interface DatabaseTemplate {	
	
	// CowRec CRUD
	ArrayList<CowRec> searchALLCow();
	CowRec searchCow(int id);
	void insertCow(CowRec cow);
	void deleteCow(int id, Connection conn);
	void updateCow(CowRec cow);
	
	// Farmer CURD
	ArrayList<FarmerRec> searchALLFarmer();
	FarmerRec searchFarmer(int id);
	void insertFarmer(FarmerRec farmer);
	void deleteFarmer(int id);
	void updateFarmer(FarmerRec farmer);
	
	// * 치료하기
	// 상태가 안좋은 소들을 치료하고
	// vet의 가격을 지불한다. (Farm_Info의 Balance를 수정한다.)
	void careCow(int id);
	// 정기검진 : 모든 소를 검사해서 치료가 필요한 소들을 치료한다.
	void careCow();
	
	//Customer CURD
	ArrayList<CustomerRec> searchALLCustomer();
	CustomerRec searchCustomer(int custid);
	void insertCustomer(CustomerRec customer);
	void deleteCustomer(int custid);
	void updateCustomer(CustomerRec customer);
	// * 판매하기
	// 기업이 원하는 소의 등급과 지불할 수 있는 최대 금액을 기준으로 팔수있는 소를 정한다.
	// (소의 등급별 kg당 가격 * 소의 몸무게)를 가격으로 산정한다.
	void sellCow(CustomerRec customer);
	void sellCow(int customerId);
	
	
	
	
}