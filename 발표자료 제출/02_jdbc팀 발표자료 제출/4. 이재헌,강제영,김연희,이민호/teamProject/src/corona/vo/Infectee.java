package corona.vo;

import java.util.ArrayList;

public class Infectee extends Person {
	private int num;
	private String infectionRoute; // 감염경로 : 해외냐, 지역
	
	private String in_hospital; // 입원 날짜
	private String treatDate; // 완치 날짜
	private String deathDate; // 사망 날짜
	private ArrayList<Visit> allTrace;  // 동선 껍데기
	
	private Hospital hospital;
	
	public Infectee() {
		
	}

	public Infectee(int ssn, String name, String address1, String address2, int age, String gender, int infecter,
			String test_condition, String isolation, String country, int num, String infectionRoute, String in_hospital, String treatDate, String deathDate,
			ArrayList<Visit> allTrace, Hospital hospital) {
		super(ssn, name, address1, address2, age, gender, infecter, test_condition, isolation, country);
		this.num = num;
		this.infectionRoute = infectionRoute;
		this.in_hospital = in_hospital;
		this.treatDate = treatDate;
		this.deathDate = deathDate;
		this.allTrace = allTrace;
		this.hospital = hospital;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getInfectionRoute() {
		return infectionRoute;
	}

	public void setInfectionRoute(String infectionRoute) {
		this.infectionRoute = infectionRoute;
	}

	public String getIn_hospital() {
		return in_hospital;
	}

	public void setIn_hospital(String in_hospital) {
		this.in_hospital = in_hospital;
	}

	public String getTreatDate() {
		return treatDate;
	}

	public void setTreatDate(String treatDate) {
		this.treatDate = treatDate;
	}

	public String getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(String deathDate) {
		this.deathDate = deathDate;
	}

	public ArrayList<Visit> getAllTrace() {
		return allTrace;
	}

	public void setAllTrace(ArrayList<Visit> allTrace) {
		this.allTrace = allTrace;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	@Override
	public String toString() {
		return super.toString()+" Infectee [num=" + num + ", infectionRoute=" + infectionRoute + ", in_hospital=" + in_hospital
				+ ", treatDate=" + treatDate + ", deathDate=" + deathDate + ", allTrace=" + allTrace + ", hospital="
				+ hospital + "]\n";
	}

}
