package hrd.vo;
import java.util.Calendar;

public class Date {
	private int[] days;	//index +4 => month, 4월 수업일수 15일로 수정했습니다
	private int year;
	private int month;
	private int day;

	public Date() {};
	public Date(int[] days, int year, int month, int day) {
		this.days = days;
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
	
	
	
	
	
}