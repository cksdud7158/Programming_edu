package corona.test;

import java.util.ArrayList;

import corona.dao.Database;
import corona.exception.DuplicateSSNException;
import corona.vo.Visit;
import corona.dao.Database;
import corona.exception.DuplicateSSNException;
import corona.exception.RecordNotFoundException;
import corona.vo.Person;

public class Corona_test {

	public static void main(String[] args) throws Exception {
		Database db = new Database("192.168.0.164");

		/* 환자 현황 */
		// 1.일일 확진자
		//System.out.println(db.todayInfectee());

		// 2.일일 완치자
		//System.out.println(db.todayTreated());

		/*-------------------------------------------*/

		// 3.누적확진자
		// System.out.println(db.totalInfectee());
		// 3-2 일일 확진자
		// System.out.println(db.todayInfectee());

		// 4.누적완치자
		// System.out.println(db.totalTreated());
		// 4-2 일일 완치자
		// System.out.println(db.todayTreated());

		// 5.치료중
		// System.out.println(db.treating());

		// 6.누적사망
		// System.out.println(db.totalDeath());
		// 6-2일일 사망
		// System.out.println(db.todayDeath());

		/*-----------검사현환---------------------------*/
		// 1. 누적검사수
		// System.out.println(db.totalTest());

		// 2. 누적 검사 완료수
		// System.out.println(db.totalTestDone());

		// 3.누적확진률
		// System.out.println(db.totalInfecteeRate());

		/*-----------지역발생확진자, 해외유입확진자, 누적사망률-----------------*/
		// 지역발생확진자
		// System.out.println(db.localInfectee());

		// 해외발생확진자수
		// System.out.println(db.foreignInfectee());

		// 누적사망률
		// System.out.println(db.totalDeathRate());

		/* 시도별 확진자 현황 */

		// 시도별확진자
		// System.out.println(db.infecteeInCertainCity("서울"));
		// 시도별확진자수
		// System.out.println(db.infecteeInCertainCity("서울", "서초구"));

		/* 지역 n번확자 동선 검색 */
		// 특정환자 동선 검색(지역 몇번 확진자)
		/*
		  for(Visit v: db.searchAllTrace("서울", "서초구", 2)) { System.out.println(v); }
		*/ 

		/* 관리자 페이지 */
		// 검사 받은 사람 추가
		//db.addPeople (new Person(7777, "이재헌", "서울시", "동대문구", 33, "m", 0, "2020-05-17", "2020-05-17", "대한민국"));

		// 확진자 추가
		//db.addInfectee(7777, 102, "지역", "2020-05-18");

		// 치료 완료
		//db.treatedInfectee(7777, "2020-05-18"); 

		// 격리 해제
		//db.NoMoreIsolation(999); 

		// 방역하기
		//db.doClean(1, "888번", "2020-01-31", "2020-02-01");
		
		
		// 사망
		//db.setDeath(333, "2000-05-30");
		
		
		
		/* 조회 */
		// 검사받은사람 조회
		/*  System.out.println(db.searchPeople(444));
		  System.out.println(db.searchPeople(888));
		 */

		// 전체 확진자 정보 조회
		 //System.out.println(db.searchAllInfectee());
		 // 특정 확진자 정보 조회
		 //
		
		
		// 특정확진자 동선 조회(SSN)
		// for (Visit v : db.searchAllTrace(888)) { System.out.println(v); }

		// 특정 환자가 입원한 병원 조회 by ssn
		//System.out.println(db.whereIsAInfectee(888));

		// 국적조회
		// System.out.println(db.searchForeigner(1));

		// 병원 코드 조회
		// System.out.println(db.searchAHosipitalCode("신촌세브란스"));
		
		//병원코드로 확진자조회 
		//System.out.println(db.searchAllInfecteeInHospital(101));
		
		// 모든 방역 내역
		/*
		 * for (Visit v : db.isCleaned()) { System.out.println(v); }
		 */

		//특정 환자 다녀간 곳 방역 유무
		/*for (Visit v : db.isCleaned(888)) {
			System.out.println(v);
		}*/
		
		
		//해외국적확진자 where country = ?
		//System.out.println(db.searchAllForeignInfectee());
		
		
		// 특정 환자가 감염시킨 사람들을 조회  
		//System.out.println(db.searchInfectedPeopleByCertainPerson(111));

		
		
		
		
		
		
		
		
		

		// updatePerson()
		// searchPeople 기능으로 가져와서 화면에 뿌린다음, UI에서 사용자가 바꾼 값을 새로 덮어씌우는 방법이 좋을 듯
		// 나이를 30 -> 31로 변경
		/*
		 * Person temperson = db.searchPeople(111); db.updatePerson(new
		 * Person(temperson.getSsn(), temperson.getName(), temperson.getAddress1(),
		 * temperson.getAddress2(),31,temperson.getGender(), temperson.getInfecter(),
		 * temperson.getTest_condition(), temperson.getIsolation(),
		 * temperson.getCountry()));
		 */

		// ljh_16
		// 특정 도시화자의 감염넘버를 ssn으로 바꿈/ public int certainCityInfecteeNumToSsn(String
		// address1, String address2, int num)
		// System.out.println(db.certainCityInfecteeNumToSsn("서울", "서초구", 1));

		// ljh_17
		// 감염넘버를특정도시감염넘버로 바꿈 public int InfecteeNumToCertainCityInfecteeNum(int num)
		// System.out.println(db.InfecteeNumToCertainCityInfecteeNum(5));

		// ljh_18
		// 특정도시감염넘버를총감연넘버로바꿈 public int certainCityInfecteeNumToInfecteeNum(String
		// address1, String address2, int num)
		// System.out.println(db.certainCityInfecteeNumToInfecteeNum("서울", "서초구", 1));

		
		
		// isCleaned()
		/* ArrayList<Visit> temp =db.isCleaned("888번지"); for(Visit v : temp) {
		 * if(v.getCleanDate() == null) { System.out.println("방역 필요"); }else {
		 * System.out.println("방역 완료"); } }
		 */
		/*
		 * // System.out.println(db.returnSsn("서울", "서초구", 2));
		 * 
		 * 
		 * 
		 * 
		 *
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
*/		
	}

}
