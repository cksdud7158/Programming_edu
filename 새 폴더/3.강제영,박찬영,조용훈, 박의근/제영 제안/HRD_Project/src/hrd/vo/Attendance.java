package hrd.vo;

import java.util.ArrayList;

public class Attendance {
	ArrayList<Integer> attendace = new ArrayList<Integer>();
	ArrayList<Integer> late = new ArrayList<Integer>();
	ArrayList<Integer> abscent = new ArrayList<Integer>();
	ArrayList<Integer> vacation = new ArrayList<Integer>();
	
	
	public Attendance(ArrayList<Integer> attendace, ArrayList<Integer> late, ArrayList<Integer> abscent) {
		super();
		this.attendace = attendace;
		this.late = late;
		this.abscent = abscent;
	}
	public ArrayList<Integer> getAttendace() {
		return attendace;
	}
	public void setAttendace(ArrayList<Integer> attendace) {
		this.attendace = attendace;
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
	@Override
	public String toString() {
		return "Attendance [attendace=" + attendace + ", late=" + late + ", abscent=" + abscent + "]";
	}
	

	
	
}
