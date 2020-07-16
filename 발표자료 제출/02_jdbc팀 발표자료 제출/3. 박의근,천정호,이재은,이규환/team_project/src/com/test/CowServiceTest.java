package com.test;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import com.dao.Database;
import com.vo.CowRec;
import com.vo.CustomerRec;
import com.vo.FarmerRec;


public class CowServiceTest {

	public static void main(String[] args) throws ClassNotFoundException {
		Database db = new Database();
		ArrayList<CowRec> ret = db.searchALLCow();
		Scanner sc = new Scanner(System.in);
		
			while (true) {
			int sel = -1;
			System.out.println("+====================================================+");
			System.out.println("|               < Connected Cow Manager >            |");
			System.out.println("+====================================================+");
			System.out.println(
					"| 1. 소 관리하기                                                                                         |");
			System.out.println(
					"| 2. 소 판매하기                                                                                         |");
			System.out.println(
					"| 3. 직원 관리하기                                                                                      |");
			System.out.println(
					"| 4. 거래 내역                                                                                            |");
			System.out.println(
					"| 5. 거래처 관리                                                                                         |");
			System.out.println(
					"| 6. 종료하기                                                                                             |");
			System.out.println("+====================================================+");
			System.out.print(" * 입력 >> ");
			sel = sc.nextInt();

			if (sel == 1) {
				System.out.println("+====================================================+");
				System.out.println("|                     < 소 관리하기 >                     |");
				System.out.println("+====================================================+");
				System.out.println(
						"| 1. 소 추가하기                                                                                         |");
				System.out.println(
						"| 2. 소 치유하기                                                                                         |");
				System.out.println(
						"| 3. 소 검진하기                                                                                         |");
				System.out.println(
						"| 4. 나이가 많은 소 폐사하기                                                                        |");
				System.out.println(
						"| 5. 모든 소 조회하기                                                                                  |");
				System.out.println(
						"| 6. 뒤로가기                                                                                             |");
				System.out.println("+====================================================+");
				System.out.print(" * 입력 >> ");
				sel = sc.nextInt();
				if (sel == 1) {					
					System.out.print(" * 무게 >> ");
					int weight = sc.nextInt();
					System.out.print(" * 나이 >> ");
					int age = sc.nextInt();
					System.out.print(" * 상태 >> ");
					String state = sc.next();
					System.out.print(" * 성별 >> ");
					String sex = sc.next();
					System.out.print(" * 담당자 ID (100번 부터 시작합니다.) >> ");
					int manager = sc.nextInt();
					System.out.print(" * 주치의 ID (60001번부터 시작합니다.) >> ");
					int vet_id = sc.nextInt();
					System.out.print(" * 마블링 상태 (1 - 10) >> ");
					int marbling = sc.nextInt();
					CowRec cow = new CowRec(weight, age, state, sex, manager, vet_id, marbling);
					db.insertCow(cow);
					System.out.println("(알림) 추가에 성공하였습니다.");
				} else if (sel == 2) {
					System.out.print(" * 치유할 소의 ID >> ");
					int cowId = sc.nextInt();
					db.careCow(cowId);
					System.out.println("(알림) " + cowId + "번 소가 치료되었습니다.");
					
				} else if (sel == 3) {
					System.out.println("(알림) 건강하지 않은 모든 소들을 찾아 치료합니다.");
					db.careCow();
					System.out.println("(알림) 모든 소들이 치료되었습니다.");
				} else if (sel == 4) {
					System.out.println("(알림) 나이가 많은 소들을 폐사합니다.");
					db.dropOldCows();
				} else if (sel == 5) {
					db.printCows(db.searchALLCow(), "모든 소 조회");
				} else if (sel == 6) {
					
				} else {
					System.out.println("(알림) 잘못된 입력입니다.");
				}

			} else if (sel == 2) {
				System.out.println("(알림) 거래할 기업의 ID를 입력하세요");
				System.out.print(" * CUSTOMER ID >> ");
				int custId = sc.nextInt();
				db.sellCow(custId);
				
			} else if (sel == 3) {
				System.out.println("+====================================================+");
				System.out.println("|                    < 직원 관리하기 >                     |");
				System.out.println("+====================================================+");
				System.out.println(
						"| 1. 직원 추가하기                                                                                      |");
				System.out.println(
						"| 2. 직원 수정하기                                                                                      |");
				System.out.println(
						"| 3. 직원 제거하기                                                                                      |");
				System.out.println(
						"| 4. 직원 검색하기                                                                                      |");
				System.out.println(
						"| 5. 모든 직원 조회하기                                                                               |");
				System.out.println(
						"| 6. 뒤로가기                                                                                             |");
				System.out.println("+====================================================+");
				System.out.print(" * 입력 >> ");
				sel = sc.nextInt();
				if(sel == 1) {
					System.out.print(" * ID >> ");
					int farmerId = sc.nextInt();
					System.out.print(" * 이름 >> ");
					String farmerName = sc.next();
					System.out.print(" * 입사 일자 (ex. 1994-08-05) >> ");
					String hireDate = sc.next();
					System.out.print(" * 직무 >> ");
					String farmerJob = sc.next();
					FarmerRec farmer = new FarmerRec(farmerId, farmerName, hireDate, farmerJob);
					db.insertFarmer(farmer);
					System.out.println("(알림) 추가에 성공하였습니다.");
				}else if(sel == 2) {
					System.out.print(" * ID >> ");
					int farmerId = sc.nextInt();
					System.out.print(" * 이름 >> ");
					String farmerName = sc.next();
					System.out.print(" * 입사 일자 (ex. 1994-08-05) >> ");
					String hireDate = sc.next();
					System.out.print(" * 직무 >> ");
					String farmerJob = sc.next();
					FarmerRec farmer = new FarmerRec(farmerId, farmerName, hireDate, farmerJob);
					db.updateFarmer(farmer);
					System.out.println("(알림) 정보 수정에 성공하였습니다.");
				}else if(sel == 3) {
					System.out.print(" * ID >> ");
					int farmerId = sc.nextInt();
					db.deleteFarmer(farmerId);
					System.out.println("(알림) 직원제거에 성공하였습니다.");
				}else if(sel == 4) {
					System.out.print(" * ID >> ");
					int farmerId = sc.nextInt();
					FarmerRec customer = db.searchFarmer(farmerId);
					System.out.println("======================================================");
					System.out.println("ID\tNAME\tHIREDATE\tJOB");
					System.out.println("======================================================");
					System.out.println(customer);
					System.out.println("======================================================");
					
				}else if(sel == 5) {
					ArrayList<FarmerRec> farmers = db.searchALLFarmer();
					System.out.println("======================================================");
					System.out.println("ID\tNAME\tHIREDATE\tJOB");
					System.out.println("======================================================");
					for(FarmerRec farmer: farmers) {
						System.out.println(farmer);						
					}
					System.out.println("======================================================");
				}else if(sel == 6) {
				}else {
					System.out.println("(알림) 잘못된 입력입니다.");
				}
			} else if (sel == 4) {
				db.showAccount();
				
			} else if (sel == 5){
				System.out.println("+====================================================+");
				System.out.println("|                    < 직원 관리하기 >                     |");
				System.out.println("+====================================================+");
				System.out.println(
						"| 1. 거래처 정보 확인하기                                                                            |");
				System.out.println(
						"| 2. 거래처 추가하기                                                                                      |");
				System.out.println(
						"| 3. 거래처 제거하기                                                                                      |");
				System.out.println(
						"| 4. 거래처 수정하기                                                                                      |");
				System.out.println(
						"| 5. 뒤로가기                                                                                             |");
				System.out.println("+====================================================+");
				System.out.print(" * 입력 >> ");
				sel = sc.nextInt();
				if(sel == 1) {
					System.out.println("거래처 ID 검색");
					System.out.print(" * 입력 >> ");
					int custumerid = sc.nextInt();
					System.out.println("======================================================");
					db.searchCustomer(custumerid);
					
					System.out.println("======================================================");
				}else if(sel == 2) {
					System.out.print(" * ID >> ");
					int custId = sc.nextInt();
					System.out.print(" * 한계등급 >> ");
					String limitgrade = sc.next();
					System.out.print(" * 제한금 >> ");
					int limitprice = sc.nextInt();
					System.out.print(" * 총거래량 >> ");
					int getTotal = sc.nextInt();
					System.out.print(" * 거래처명 ");
					String custname= sc.next();
					CustomerRec farmer = new CustomerRec(custId,custname,limitgrade, limitprice, getTotal);
					db.insertCustomer(farmer);
					System.out.println("(알림) 정보 추가에 성공하였습니다.");
				}else if(sel == 3) {
					System.out.print(" * ID >> ");
					int farmerId = sc.nextInt();
					db.deleteCustomer(farmerId);
					System.out.println("(알림) 직원제거에 성공하였습니다.");
				}else if(sel == 4) {
					System.out.print(" * ID >> ");
					int custId = sc.nextInt();
					System.out.print(" * 한계등급 >> ");
					String limitgrade = sc.next();
					System.out.print(" * 제한금 >> ");
					int limitprice = sc.nextInt();
					System.out.print(" * 총거래량 >> ");
					int getTotal = sc.nextInt();
					System.out.print(" * 거래처명 ");
					String custname= sc.next();
					CustomerRec farmer = new CustomerRec(custId,custname,limitgrade, limitprice, getTotal);
					db.updateCustomer(farmer);
					System.out.println("(알림) 정보 수정에 성공하였습니다.");
					
				}else if(sel == 5) {
					
				}else {
					System.out.println("(알림) 잘못된 입력입니다.");
				}
			} else if (sel == 6){
				System.out.println("오늘 하루도 고생하셨습니다.");
				break;
			}
				else {
				System.out.println("(ERROR) 잘못된 입력입니다.");
			}

		}
		
	}

}
