package hrd.vo;
import java.util.Arrays;

public class Dates {
	private int[] days = {14,17,22,20,21,19};	//index +4 => month
	private int year;
	private int month;
	private int day;
	
	public Dates(int[] days, int year, int month, int day) {
		super();
		this.days = days;
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public int[] getDays() {
		return days;
	}

	public void setDays(int[] days) {
		this.days = days;
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
	

	@Override
	public String toString() {
		return "Dates [days=" + Arrays.toString(days) + ", year=" + year + ", month=" + month + ", day=" + day + "]";
	}
	
	
	

	
}