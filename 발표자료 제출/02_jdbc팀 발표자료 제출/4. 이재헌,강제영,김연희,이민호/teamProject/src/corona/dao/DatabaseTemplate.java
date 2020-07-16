package corona.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import corona.exception.DuplicateSSNException;
import corona.exception.RecordNotFoundException;
import corona.vo.Hospital;
import corona.vo.Infectee;
import corona.vo.Person;
import corona.vo.Visit;

public interface DatabaseTemplate {
	// [								공통 로직											]
	Connection getConnect() throws SQLException;
	void closeAll(PreparedStatement ps, Connection conn)throws SQLException;
	void closeAll(ResultSet rs, PreparedStatement ps, Connection conn)throws SQLException;	
	
	// [								비지니스 로직											]
	/* =========================================== 1.추가 ==============================================*/
	//B1 : Person 테이블에 추가
	void addPeople(Person p) throws SQLException, DuplicateSSNException ;
	
	/* =========================================== 2.조회 ==============================================*/
	/* ----------------- (1)일반 유저 조회 -----------------------------*/
	/* -- (1-1)코로나 현황 관련 조회 --*/
	// B2 : 일일확진자수
	int todayInfectee() throws SQLException;
	// B3 : 일일완치자수
	int todayTreated() throws SQLException;
	// B4 : 일일사망자
	int todayDeath() throws SQLException;
	// B5 : 누적확진자
	int totalInfectee() throws SQLException;
	// B6 : 누적완치자
	int totalTreated() throws SQLException;
	// B7 : 누적사망자
	int totalDeath() throws SQLException;
	// B8 : 누적사망률
	float totalDeathRate() throws SQLException;
	// B9 : 치료중인원수
	int treating() throws SQLException;
	// B10 : 누적검사수
	int totalTest() throws SQLException;
	// B11 : 누적검사완료수 
	int totalTestDone() throws SQLException;
	// B12 : 누적확진률 : 누적확진수/누적검사완료수 * 100
	float totalInfecteeRate() throws SQLException;
	// B13 : 지역발생확진자 
	int localInfectee() throws SQLException;
	// B14 : 해외발생확진자수
	int foreignInfectee() throws SQLException;
	// B15 : 광역시도별확진자
	int infecteeInCertainCity(String address1) throws SQLException;
	//B16 : 시구군별 확진자
	int infecteeInCertainCity(String address1, String address2) throws SQLException;
	
	/* -- (1-2)동선 및 방역 관련 조회 --*/ //UI상에 지도에 구현하심이?
	// B17 : 특정환자 동선 검색(지역 몇번 확진자)
	ArrayList<Visit> searchAllTrace(String address1, String address2, int num) throws SQLException; // 특정 환자
	// B18 : 특정환자 동선 검색
	ArrayList<Visit> searchAllTrace(int num) throws SQLException;
	// B19 : 모든 방역 내역
	ArrayList<Visit> isCleaned() throws SQLException; // 모든 방역 내역
	// B20 : 특정 확진자가 간 곳의 방역 여부
	ArrayList<Visit> isCleaned(int ssn) throws SQLException; // 특정 확진자가 간 곳 
	
	
	/* ---------------- (2)직원 고유 조회 -----------------------------------*/
	/* -- (2-1)Person 관련 조회 --*/
	// B21 : Person 조회
	Person searchPeople(int ssn) throws Exception;
	// B22 : 국적조회(Person 테이블의 Country)
	String searchForeigner(int ssn) throws SQLException, RecordNotFoundException;
	
	/* -- (2-2)Infectee 관련 조회 --*/
	// B25 : 전체확진자
		ArrayList<Infectee> searchAllInfectee() throws SQLException, RecordNotFoundException;
	// B23 : 특정확진자 조회(주소1,주소2,확진번호)
	Person searchAInfectee(String address1, String address2, int num) throws SQLException, RecordNotFoundException;
	// B24 : 특정 확진자 조회(확진번호)
	Person searchAInfectee(int num) throws SQLException, RecordNotFoundException;//
	// B26 : 해외발생확진자 
	ArrayList<Infectee> searchAllForeignInfectee() throws SQLException, RecordNotFoundException;
	// B30 : 특정 확진자가 감염시킨 확진자 검색!
    ArrayList<Infectee> searchInfectedPeopleByCertainPerson(int ssn) throws SQLException, RecordNotFoundException;
	
	/* -- (2-3)Hospital--Infectee 관련 조회 --*/
	// B27 : 병원이름으로 병원 코드 조회
	int searchAHosipitalCode(String name) throws SQLException, RecordNotFoundException;
	// B28 : 확진자가 입원한 병원 조회
	Hospital whereIsAInfectee(int ssn) throws SQLException, RecordNotFoundException;
	// B29 : 병원 내 모든 확진자 조회
	ArrayList<Infectee> searchAllInfecteeInHospital(int code) throws SQLException, RecordNotFoundException;
	
	/* -- (2-4)Visits--Infectee 관련 조회 --*/
    // B31 : 특정 장소 방역 조회
    ArrayList<Visit> isCleaned(String address) throws SQLException; //
    // B40 : ssn을 입력하고 동선 목록을 리턴 --> %%B18과 B40 겹침?
    ArrayList<Visit> getTrace(int ssn) throws SQLException;
    
    /* =========================================== 3.정보 수정 ==============================================*/
    /* -- (3-1)Person 관련 수정 --*/
    // B32 : Person 테이블 수정
    void updatePerson(Person p) throws SQLException;
    
    /* -- (3-2)Infectee 관련 수정 --*/
    // B33 : 확진자 추가 + 입원 처리 + 방역도 : 입원날짜 넣기 
    void addInfectee(int ssn, int code, String infectionroute, String date) throws SQLException, DuplicateSSNException; // corona19를 1로 infectee 생성
	// B34 : 완치 처리
    void treatedInfectee (int ssn, String date) throws SQLException;
    // B35 : 격리해제 : null = 격리된 적 없음. 2020년 이후 날짜 = 격리 중. '1999-12-31' = 격리해제
    void NoMoreIsolation(int ssn) throws SQLException;
    // B36 : 사망 처리
    void setDeath(int ssn, String date) throws SQLException;
    
    /* -- (3-3)Visits 관련 수정 --*/
    // B37 : 동선 수정
    void updateTrace(int num, String address, String visitDate,String oldaddress) throws SQLException;
    
    /* =========================================== 4.방역 조치 ==============================================*/
    // B38 : 방역하기 : visit, place clean
    void doClean(int num, String address, String visitDate, String cleanDate) throws SQLException ;
    
    /* =========================================== 5. 기타 ==============================================*/
    /* ---------------- (1)변환 -----------------------------------*/
    // B39 : 특정 지역 n번 확진자의 ssn을 리턴
    int returnSsn(String address1, String address2, int num) throws SQLException;
	// B41 : 특정 도시화자의 감염넘버를 ssn으로 바꿈
	int certainCityInfecteeNumToSsn(String address1, String address2, int num) throws SQLException;
	// B42 : 감염넘버를특정도시감염넘버로 바꿈
	int InfecteeNumToCertainCityInfecteeNum(int num) throws SQLException;
	// B43 : 특정도시감염넘버를총감연넘버로바꿈
	int certainCityInfecteeNumToInfecteeNum(String address1, String address2, int num) throws SQLException;
	
	/* ---------------- (2)유무확인 -----------------------------------*/
	// B44 : 확진자 번호 유무 확인
	boolean isExistinInfecteeWithNum(int num, Connection conn) throws SQLException;
	// B45 : 병원코드 유무확인
	boolean isExistinHospitalWithCode(int code, Connection conn) throws SQLException;
	// B46 : 병원이름 유무확인
	boolean isExistinHospitalWithName(String name, Connection conn) throws SQLException;
	// B47 : 확진자 유무확인
	boolean isExistinInfectee(int ssn, Connection conn)throws SQLException;
	ArrayList<Visit> searchAllTraceBySsn(int ssn) throws SQLException;
}