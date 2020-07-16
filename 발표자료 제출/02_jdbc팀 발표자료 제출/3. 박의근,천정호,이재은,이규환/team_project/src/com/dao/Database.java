package com.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.exception.InvalidTransactionException;
import com.exception.NotEnoughMoneyException;
import com.exception.RecordNotFoundException;
import com.vo.CowRec;
import com.vo.CustomerRec;
import com.vo.FarmerRec;
import com.vo.VetRec;

public class Database implements DatabaseTemplate {
	String url;
	String id;
	String password;

	public Database() throws ClassNotFoundException {
		Properties p = new Properties();
		try {
			p.load(new FileInputStream("src/config/jdbc.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Class.forName(p.getProperty("jdbc.mysql.driver"));
		url = p.getProperty("jdbc.mysql.url");
		id = p.getProperty("jdbc.mysql.user");
		password = p.getProperty("jdbc.mysql.password");

	}

	@Override
	public ArrayList<CowRec> searchALLCow() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<CowRec> ret = new ArrayList<CowRec>();
		try {
			conn = DriverManager.getConnection(url, id, password);
			ps = conn.prepareStatement("SELECT * FROM COWS");
			rs = ps.executeQuery();
			while (rs.next()) {
				CowRec cow = new CowRec(rs.getInt("weight"), rs.getInt("age"), rs.getString("state"),
						rs.getString("SEX"), rs.getInt("manager"), rs.getInt("vet_id"), rs.getInt("Marbling"));
				cow.setId(rs.getInt("id"));
				ret.add(cow);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return ret;
	}

	@Override
	public CowRec searchCow(int cowId) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		CowRec ret = null;
		try {
			conn = DriverManager.getConnection(url, id, password);
			ps = conn.prepareStatement("SELECT * FROM COWS WHERE id=?");
			ps.setInt(1, cowId);
			rs = ps.executeQuery();
			if (rs.next()) {
				ret = new CowRec(rs.getInt("weight"), rs.getInt("age"), rs.getString("state"), rs.getString("SEX"),
						rs.getInt("manager"), rs.getInt("vet_id"), rs.getInt("Marbling"));
				ret.setId(cowId);
			} else {
				throw new RecordNotFoundException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return ret;
	}

	@Override
	public void insertCow(CowRec cow) {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DriverManager.getConnection(url, id, password);
			ps = conn.prepareStatement(
					"INSERT INTO COWS(weight, age, state, sex, manager, vet_id, marbling) VALUES (?, ?, ?, ?, ?, ?, ?)");
			ps.setInt(1, cow.getWeight());
			ps.setInt(2, cow.getAge());
			ps.setString(3, cow.getState());
			ps.setString(4, cow.getSex());
			ps.setInt(5, cow.getManager());
			ps.setInt(6, cow.getVet_id());
			ps.setInt(7,  cow.getMarbling());

			int ret = ps.executeUpdate();
			if (ret == 0) {
				throw new InvalidTransactionException();
			}
			System.out.println("소가 추가 되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InvalidTransactionException e) {
			System.out.println("insertCow() error..");
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void deleteCow(int cowId, Connection conn) {
		PreparedStatement ps = null;

		try {
			conn = DriverManager.getConnection(url, id, password);
			ps = conn.prepareStatement("DELETE FROM Cows WHERE id=?");
			ps.setInt(1, cowId);
			System.out.println("check");
			int ret = ps.executeUpdate();
			if (ret == 0) {
				throw new InvalidTransactionException();
			}
			System.out.println("소가 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InvalidTransactionException e) {
			System.out.println("deleteCow() error..");
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void updateCow(CowRec cow) {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DriverManager.getConnection(url, id, password);
			ps = conn.prepareStatement(
					"UPDATE cows SET weight=?, age=?, state=?, sex=?, manager=?, vet_id=? WHERE id=?");
			ps.setInt(1, cow.getWeight());
			ps.setInt(2, cow.getAge());
			ps.setString(3, cow.getState());
			ps.setString(4, cow.getSex());
			ps.setInt(5, cow.getManager());
			ps.setInt(6, cow.getVet_id());
			ps.setInt(7, cow.getId());

			int ret = ps.executeUpdate();
			if (ret == 0) {
				throw new InvalidTransactionException();
			}
			System.out.println("소 정보가 수정되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InvalidTransactionException e) {
			System.out.println("updateCow() error..");
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public ArrayList<FarmerRec> searchALLFarmer() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<FarmerRec> ret = new ArrayList<FarmerRec>();
		try {
			conn = DriverManager.getConnection(url, id, password);
			ps = conn.prepareStatement("SELECT * FROM Farm_EE");
			rs = ps.executeQuery();
			while (rs.next()) {
				ret.add(new FarmerRec(rs.getInt("id"), rs.getString("name"), rs.getString("HIREDATE"),
						rs.getString("JOB")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return ret;
	}

	@Override
	public FarmerRec searchFarmer(int farmerId) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		FarmerRec ret = null;
		try {
			conn = DriverManager.getConnection(url, id, password);
			ps = conn.prepareStatement("SELECT * FROM farm_ee WHERE id=?");
			ps.setInt(1, farmerId);
			rs = ps.executeQuery();
			if (rs.next()) {
				ret = new FarmerRec(rs.getInt("id"), rs.getString("name"), rs.getString("HIREDATE"),
						rs.getString("JOB"));
			} else {
				throw new RecordNotFoundException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return ret;
	}

	@Override
	public void insertFarmer(FarmerRec farmer) {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DriverManager.getConnection(url, id, password);
			ps = conn.prepareStatement("INSERT INTO farm_ee (id, name, hiredate, job) VALUES (?, ?, ?, ?)");
			ps.setInt(1, farmer.getId());
			ps.setString(2, farmer.getName());
			ps.setString(3, farmer.getHiredate());
			ps.setString(4, farmer.getJob());

			int ret = ps.executeUpdate();
			if (ret == 0) {
				throw new InvalidTransactionException();
			}
			System.out.println("직원이 추가 되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InvalidTransactionException e) {
			System.out.println("insertFarmer() error..");
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteFarmer(int farmerId) {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DriverManager.getConnection(url, id, password);
			ps = conn.prepareStatement("DELETE FROM farm_ee WHERE id=?");
			ps.setInt(1, farmerId);

			int ret = ps.executeUpdate();
			if (ret == 0) {
				throw new InvalidTransactionException();
			}
			System.out.println("직원이 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InvalidTransactionException e) {
			System.out.println("deleteFarmer() error..");
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void updateFarmer(FarmerRec farmer) {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DriverManager.getConnection(url, id, password);
			ps = conn.prepareStatement("UPDATE farmer_ee SET name=?, hiredate=?, job=? WHERE id=?");
			ps.setString(1, farmer.getName());
			ps.setString(2, farmer.getHiredate());
			ps.setString(3, farmer.getJob());
			ps.setInt(4, farmer.getId());

			int ret = ps.executeUpdate();
			if (ret == 0) {
				throw new InvalidTransactionException();
			}
			System.out.println("소 정보가 수정되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InvalidTransactionException e) {
			System.out.println("updateCow() error..");
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public VetRec searchVet(int cowId) {
		Connection conn = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		VetRec ret = null;
		
		try {
			conn = DriverManager.getConnection(url, id, password);
			// 1. 해당소의 주치의를 찾는다.
			ps = conn.prepareStatement(
					"select V.id id, V.price price from cows C, vet V where C.id=? and C.vet_id=V.id");
			ps.setInt(1, cowId);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				// 주치의를 찾았을 경우 vo생성
				ret = new VetRec(rs.getInt("id"), rs.getInt("price"));
			} else {
				throw new RecordNotFoundException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (RecordNotFoundException e) {
			System.out.println("현재 존재하는 의사는 없습니다... 의사를 찾고 다시 실행하겠습니다.");
			System.out.println(cowId + "번 소의 담당 의사가 없습니다.");
			ret = NewSearchVet(cowId, conn);
		} finally {
			try {
				ps.close();
				rs.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return ret;
	}
	
	public VetRec NewSearchVet(int cowId, Connection conn) {
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		ResultSet rs = null;
		ArrayList<VetRec> ret = new ArrayList<VetRec>();
	
		try {
			ps1 = conn.prepareStatement("select id, price from vet");
			rs = ps1.executeQuery();
			while (rs.next()) {
				ret.add(new VetRec(rs.getInt("id"), rs.getInt("price")));
			}
			
			int retnum = ret.get(0).getId();
			
			
			ps2 = conn.prepareStatement("update cows set vet_id=? where id= ?");
			
			ps2.setInt(1, retnum);
			ps2.setInt(2, cowId);

			ps2.executeUpdate();
			 
			 System.out.println(retnum+"담당 의사로 변경되었습니다");
			 
			
		} catch (SQLException e) {
			System.out.println("존재하는 의사가 없습니다.");
			e.printStackTrace();
		} catch (NullPointerException e){
			System.out.println("값이 없습니다");
		}finally {
			try {
				ps1.close();
				ps2.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return ret.get(0);
	}
	private void spendMoney(int price, Connection conn) throws NotEnoughMoneyException, SQLException, RecordNotFoundException {
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		ResultSet rs = null;
		String farmName = "";
		int balance = 0;
		// 현재 잔고 확인
		ps = conn.prepareStatement("select farmname, balance from farm_info");
		rs = ps.executeQuery();
		
	
		if (rs.next()) {
			balance += rs.getInt("BALANCE");
			farmName = rs.getString("FARMNAME");
			balance -= price ;

			// 잔고가 충분하지 않다면 예외를 발생시킨다.
			if (balance < 0) {
				throw new NotEnoughMoneyException();
			} else {
				ps2 = conn.prepareStatement("UPDATE FARM_INFO SET BALANCE=? WHERE FARMNAME=?");
				ps2.setInt(1, balance);
				ps2.setString(2, farmName);
				ps2.executeUpdate();
				System.out.println(farmName + "이 " + price + "원을 지출하여 현재 잔고는 " + balance + "원 입니다.");
			}

		} else {
			throw new RecordNotFoundException();
		}

		rs.close();
		ps.close();
		ps2.close();

	}

	private void saveMoney(int price, Connection conn) {
		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement("UPDATE FARM_INFO SET BALANCE = BALANCE + ? WHERE FARMNAME='엔코아 농장'");
			ps.setInt(1, price);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	// 소 개별 치료
	@Override
	public void careCow(int cowId) {
		Connection conn = null;
		CowRec cow = searchCow(cowId);
		String state = "";

		if (cow == null) {
			return;
		}

		state = cow.getState();

		if (state.equals("정상")) {
			System.out.println("(알림) 소가 건강합니다.");
		} else if (state.equals("치료중")) {
			System.out.println("(알림) 소가 치료중입니다.");
		} else if (state.equals("외상") || state.equals("내상")) {
			// Transaction 사용
			try {
				conn = DriverManager.getConnection(url, id, password);
				conn.setAutoCommit(false);

				// 1. 해당 소의 주치의를 찾는다.
				VetRec vet = searchVet(cowId);
				// 2. 치료비만큼 농장의 잔고를 뺀다.
				spendMoney(vet.getPrice(), conn);
				// 3. 소의 상태를 '정상으로 돌려놓는다.'
				cow.setState("정상");
				updateCow(cow);

				conn.commit();
				conn.setAutoCommit(true);
				conn.close();
			} catch (SQLException e) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			} catch (NotEnoughMoneyException e) {
				e.printStackTrace();
			} catch (RecordNotFoundException e) {
				e.printStackTrace();
			}
			System.out.println("(알림) 소가 치료되었습니다.");
		}

	}

	@Override
	public void careCow() {
		ArrayList<CowRec> allCows = searchALLCow();
		for (CowRec cow : allCows) {
			careCow(cow.getId());
		}
	}

	@Override
	public void sellCow(CustomerRec customer) {
		Connection conn = null;
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;

		ResultSet rs = null;

		ArrayList<CowRec> cows = new ArrayList<CowRec>();

		try {
			conn = DriverManager.getConnection(url, id, password);

			conn.setAutoCommit(false);

			// 1. customer가 원하는 최소등급을 만족하는 소들을 찾는다.
			ps = conn.prepareStatement(
					"SELECT C.ID, C.WEIGHT, C.age, C.state, C.sex, C.MANAGER, C.vet_id, C.MARBLING, G.GRADE, G.PRICE_PER_WEIGHT, (C.WEIGHT * G.PRICE_PER_WEIGHT) AS PRICE "
							+ "FROM COWS C, COW_GRADE G "
							+ "WHERE G.MARBLING_FROM <= C.MARBLING AND C.MARBLING < G.MARBLING_TO "
							+ "AND G.GRADE <= ? AND (C.WEIGHT * G.PRICE_PER_WEIGHT)<=? and C.STATE='정상' "
							+ "ORDER BY GRADE ASC, PRICE ASC");
			// 찾은 소들 중 고객이 원하는 금액의 소를 찾는다.
			ps.setString(1, customer.getLimit_grade());
			ps.setInt(2, customer.getLimit_price());
			rs = ps.executeQuery();

			while (rs.next()) {
				cows.add(new CowRec(rs.getInt("id"), rs.getInt("weight"), rs.getInt("age"), rs.getString("state"),
						rs.getString("sex"), rs.getInt("manager"), rs.getInt("vet_id"), rs.getInt("marbling"),
						rs.getInt("PRICE")));
			}

			printCows(cows, "판매자의 조건에 맞는 소 리스트 ");

			CowRec bestCow = cows.get(0);
			System.out.println("(알림) 최적의 소는 id : " + bestCow.getId() + "입니다.");

			// 3. 거래 목록에 추가시킨다.
			ps2 = conn.prepareStatement("INSERT INTO cust_relation_farm(FARMNAME, PRICE, CUSTOMER) VALUES(?, ?, ?)");
			ps2.setString(1, "엔코아 농장");
			ps2.setInt(2, bestCow.getPrice());
			ps2.setInt(3, customer.getId());
			ps2.executeUpdate();
			
			// 4. farm_info의 balance를 판매한 가격만큼 증가시킨다.
			saveMoney(bestCow.getPrice(), conn);

			// 5. 해당 소를 cows table에서 삭제한다.
			deleteCow(bestCow.getId(), conn);

			System.out.println(">> 거래 완료!");

			conn.commit();
			conn.setAutoCommit(true);

		} catch (SQLException e) {
			try {
				System.out.println("(error) 거래 오류!");

				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				ps2.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	@Override
	public void sellCow(int customerId) {
		Connection conn = null;
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;

		ResultSet rs = null;

		CustomerRec customer = null;
		ArrayList<CowRec> cows = new ArrayList<CowRec>();

		
		try {
			conn = DriverManager.getConnection(url, id, password);

			conn.setAutoCommit(false);

			// 0. CustomerRec 찾기
			customer = searchCustomer(customerId, conn);
			
			System.out.println(">> 구매자가 원하는 소의 최소 등급    : " + customer.getLimit_grade());
			System.out.println(">> 구매자가 지불할 수 있는 금액       : " + customer.getLimit_price());
			
			// 1. customer가 원하는 최소등급을 만족하는 소들을 찾는다.
			ps = conn.prepareStatement(
					"SELECT C.ID, C.WEIGHT, C.age, C.state, C.sex, C.MANAGER, C.vet_id, C.MARBLING, G.GRADE AS GRADE, G.PRICE_PER_WEIGHT, (C.WEIGHT * G.PRICE_PER_WEIGHT) AS PRICE "
							+ "FROM COWS C, COW_GRADE G "
							+ "WHERE G.MARBLING_FROM <= C.MARBLING AND C.MARBLING < G.MARBLING_TO "
							+ "AND G.GRADE <= ? AND (C.WEIGHT * G.PRICE_PER_WEIGHT)<=? and C.STATE='정상' and C.age < 4 "
							+ "ORDER BY GRADE ASC, PRICE ASC");
			// 찾은 소들 중 고객이 원하는 금액의 소를 찾는다.
			ps.setString(1, customer.getLimit_grade());
			ps.setInt(2, customer.getLimit_price());
			rs = ps.executeQuery();
			if(!rs.next()) System.out.println("값이 없다.");
			while (rs.next()) {
				CowRec cow = new CowRec(rs.getInt("id"), rs.getInt("weight"), rs.getInt("age"), rs.getString("state"),
						rs.getString("sex"), rs.getInt("manager"), rs.getInt("vet_id"), rs.getInt("marbling"),
						rs.getInt("PRICE"));
				cow.setGrade(rs.getString("GRADE"));
				cows.add(cow);
			}
			System.out.println(cows);
			printCows(cows, "판매자의 조건에 맞는 소 리스트 ");

			CowRec bestCow = cows.get(0);
			System.out.println(cows.get(0));
			System.out.println("(알림) 최적의 id : " + bestCow.getId() + "입니다.");

			// 3. 거래 목록에 추가시킨다.
			ps2 = conn.prepareStatement("INSERT INTO cust_relation_farm(FARMNAME, PRICE, CUSTOMER) VALUES(?, ?, ?)");
			ps2.setString(1, "엔코아 농장");
			ps2.setInt(2, bestCow.getPrice());
			ps2.setInt(3, customer.getId());
			ps2.executeUpdate();
			
			// 4. farm_info의 balance를 판매한 가격만큼 증가시킨다.
			saveMoney(bestCow.getPrice(), conn);

			// 5. 해당 소를 cows table에서 삭제한다.
			deleteCow(bestCow.getId(), conn);

			System.out.println(">> 거래 완료!");

			conn.commit();
			conn.setAutoCommit(true);

		} catch (SQLException e) {
			try {
				System.out.println("(error) 거래 오류!");

				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				ps2.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private CustomerRec searchCustomer(int customerId, Connection conn) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		CustomerRec ret = null;
		try {
			ps = conn.prepareCall("SELECT limit_grade, limit_price, total from customer_ee where id=?");
			ps.setInt(1, customerId);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				ret = new CustomerRec(customerId, rs.getString("limit_grade"), rs.getInt("limit_price"), rs.getInt("total"));
			}
			else {
				throw new RecordNotFoundException();
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		}
		
		return ret;
	}

	public void printCows(ArrayList<CowRec> cows, String msg) {
		String bar = "ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ";
		int tmp = bar.length();
		int left_space = 0;
		int right_space = 0;
		if (msg.length() % 2 == 0) {
			left_space = (tmp - msg.length()) / 2;
			right_space = tmp - left_space - msg.length();


		} else {
			left_space = (tmp - msg.length()) / 2 + 1;
			right_space = tmp - left_space - msg.length();


		}
		System.out.println("(알림) 최대 10마리 까지 출력됩니다.");
		for (int i = 0; i < left_space; i++) {
			System.out.print("ㅡ");
		}
		System.out.print("     " + msg + "      ");
		for (int i = 0; i < right_space; i++) {
			System.out.print("ㅡ");
		}
		System.out.println();
		System.out.println("id\tweight\tage\tstate\tsex\tmanager\tvet_id\tmarbling");
		System.out.println(bar);
		
		int max_print_line = 10;
		int count = 0;
		if(cows.size() > 20) {
			for(int i =0; i< 10; i++) {
				if(count == max_print_line) {
					break;
				}
				if(!cows.get(i).getGrade().equals("") && cows.get(i).getPrice() !=0) {
					System.out.print(cows.get(i));
					System.out.println("\t" + cows.get(i).getGrade()+"등급\t" + cows.get(i).getPrice() + "원");
				}
				else {
					System.out.println(cows.get(i));
				}
			}
			System.out.println("\t\t\t.");
			System.out.println("\t\t\t.");
			System.out.println("\t\t\t.");

			for(int i = cows.size()-10; i< cows.size(); i++) {
				if(count == max_print_line) {
					break;
				}
				if(!cows.get(i).getGrade().equals("") && cows.get(i).getPrice() !=0) {
					System.out.print(cows.get(i));
					System.out.println("\t" + cows.get(i).getGrade()+"등급\t" + cows.get(i).getPrice() + "원");
				}
				else {
					System.out.println(cows.get(i));
				}
			}
		}
		else {
			for (CowRec cow : cows) {
				if(count == max_print_line) {
					break;
				}
				if(!cow.getGrade().equals("") && cow.getPrice() !=0) {
					System.out.print(cow);
					System.out.println("\t" + cow.getGrade()+"등급\t" + cow.getPrice() + "원");
				}
				else {
					System.out.println(cow);
				}
				count++;
			}
			System.out.println();
		}
	}

	public void dropOldCows() {
		Connection conn = null;
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		ResultSet rs = null;
		ArrayList<CowRec> ret = new ArrayList<CowRec>();
		
		try {
			conn = DriverManager.getConnection(url, id, password);
			ps = conn.prepareStatement("SELECT * FROM cows WHERE age>=4");
			rs = ps.executeQuery();
					
			while (rs.next()) {
				CowRec cow = new CowRec(rs.getInt("weight"), rs.getInt("age"), rs.getString("state"),
						rs.getString("SEX"), rs.getInt("manager"), rs.getInt("vet_id"), rs.getInt("Marbling"));
				cow.setId(rs.getInt("id"));
				ret.add(cow);
			}
			printCows(ret, "폐사 대상 소 목록");
					
			ps2 = conn.prepareStatement("DELETE FROM COWS WHERE age>=4");
			ps2.executeUpdate();
			
			System.out.println(">> 나이가 4살 이상인 소들를 폐사하였습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				ps.close();
				ps2.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void showAccount() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url, id, password);
			ps = conn.prepareStatement("SELECT * FROM CUST_RELATION_FARM");
			rs = ps.executeQuery();
			
			System.out.println("======================================================");
			System.out.println("FARM\t\tCUSTOMER\tPRICE");
			while(rs.next()) {
				System.out.println(rs.getString("FARMNAME")+"\t\t"+rs.getInt("customer")+"\t\t"+rs.getInt("price"));
			}
			System.out.println("======================================================");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	
	}
	
	@Override
	public ArrayList<CustomerRec> searchALLCustomer() {
		ArrayList<CustomerRec> cust = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(url, id, password);
			ps = conn.prepareStatement("SELECT * FROM customer_ee ");
			rs = ps.executeQuery();

			while (rs.next()) {
				CustomerRec customer = new CustomerRec(rs.getInt("id"), rs.getString("name"), rs.getString("limit_grade"),
						rs.getInt("limit_price"), rs.getInt("total"));
				cust.add(customer);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cust;
	}

	@Override
	public CustomerRec searchCustomer(int custid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		CustomerRec cust = null;
		try {
			conn = DriverManager.getConnection(url, id, password);
			ps = conn.prepareStatement("SELECT * FROM COWS WHERE id=?");
			ps.setInt(1, custid);

			rs = ps.executeQuery();
			if (rs.next()) {
				cust = new CustomerRec(rs.getInt("id"), rs.getString("name"), rs.getString("limit_grade"),
						rs.getInt("limit_price"), rs.getInt("total"));
			} else {
				throw new RecordNotFoundException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return cust;
	}

	@Override
	public void insertCustomer(CustomerRec customer) {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DriverManager.getConnection(url, id, password);
			ps = conn.prepareStatement(
					"INSERT INTO customer_ee(id,limit_grade,limit_price,total,cust_name) VALUES (?, ?, ?, ?, ?)");
			ps.setInt(1, customer.getId());
			ps.setString(2, customer.getLimit_grade());
			ps.setInt(3, customer.getLimit_price());
			ps.setInt(4, customer.getTotal());
			ps.setString(5, customer.getName());

			int ret = ps.executeUpdate();
			if (ret == 0) {
				throw new InvalidTransactionException();
			}
			System.out.println("거래처가 추가 되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InvalidTransactionException e) {
			System.out.println("insertCustomer() error..");
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void deleteCustomer(int custid) {
		PreparedStatement ps = null;
		Connection conn =null;

		try{
			conn = DriverManager.getConnection(url, id, password);
			ps = conn.prepareStatement("DELETE FROM customer_ee WHERE id=?");
			ps.setInt(1, custid);
			System.out.println("check");
			int ret = ps.executeUpdate();
			if (ret == 0) {
				throw new InvalidTransactionException();
			}
			System.out.println("거래처가 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InvalidTransactionException e) {
			System.out.println("deleteCustomer error..");
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void updateCustomer(CustomerRec customer) {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DriverManager.getConnection(url, id, password);
			ps = conn.prepareStatement(
					"UPDATE customer_ee SET limit_grade=? , limit_price=? , total=?, cust_name=? WHERE id=?");
			ps.setString(1, customer.getLimit_grade());
			ps.setInt(2, customer.getLimit_price());
			ps.setInt(3, customer.getTotal());
			ps.setString(4, customer.getName());

			int ret = ps.executeUpdate();
			if (ret == 0) {
				throw new InvalidTransactionException();
			}
			System.out.println("고객사 정보가 수정되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InvalidTransactionException e) {
			System.out.println("updateCustomer() error..");
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
