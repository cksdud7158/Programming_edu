package hrd.vo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class Date {
	
	public static int[] days = {14,17,22,20,21,19};	//index +4 => month
	private static int year;
	private static int month;
	private static int day;
	
	public Date(int year, int month, int day) {
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
	
	//해당 월, 일 기준 수업일수
		static Calendar cal = Calendar.getInstance(); 		//default calendar is set today

	//cal.get(Calendar.MONTH)
	public static int getThisMonth() {
		cal.set(year,month,day);
		int today=cal.get(Calendar.DATE);
		int days=0;
		for(int i = 1; i<=today;i++) {			//공휴일 계산
			switch(month){
				case 4:
					if(i<6)
						continue;	//개강

					else if(15<=i && i<=17)
						continue; //선거일~징검다리 휴일, 주말포함
					
					else if(i==30)	//석가탄신일
						continue;
					else
						break;
				case 5:
					if(i==1 || i==4 || i==5 || i==15)
						continue;
					else
						break;
				case 7:
					if(17<=i && i<=21)	//여름휴가
						continue;
					else
						break;
				case 9:
					if(i>=25)
						continue;
					break;
			}
			
			cal.set(year,month,i);
			if(cal.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY || cal.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY)
				continue;
			days++;
		}
		return days;
	}
	
	
	

	
}