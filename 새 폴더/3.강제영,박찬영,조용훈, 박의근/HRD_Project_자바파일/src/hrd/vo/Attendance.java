package hrd.vo;

import java.util.ArrayList;

public class Attendance {
	
	private ArrayList<Integer> maxattendace;
	private ArrayList<Integer> late;
	private ArrayList<Integer> abscent;
	private int vacation;
	
	
	public Attendance(ArrayList<Integer> attendace, ArrayList<Integer> late, ArrayList<Integer> abscent) {
		super();
		this.maxattendace = attendace;
		this.late = late;
		this.abscent = abscent;
	}
	
	public ArrayList<Integer> getAttendace() {
		return maxattendace;
	}
	
	public void setAttendace(ArrayList<Integer> attendace) {
		this.maxattendace = attendace;
	}

	public ArrayList<Integer> getLate() {
		return late;
	}
	public void setLate(ArrayList<Integer> late) {
		this.late = late;
	}
	public ArrayList<Integer> getAbscent() {
		return abscent;
	}
	public void setAbscent(ArrayList<Integer> abscent) {
		this.abscent = abscent;
	}
	
	public int getVacation() {
		return vacation;
	}
	public void setVacation(int vacation) {

		this.vacation = vacation;
	}

	@Override
	public String toString() {
		return "[maxattendace=" + maxattendace + ", late= " + late + ", abscent= " + abscent + ", vacation= " +vacation + "]";
	}	
}
