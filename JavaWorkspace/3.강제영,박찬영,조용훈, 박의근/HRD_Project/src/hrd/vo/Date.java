package hrd.vo;
import java.util.Calendar;

public class Date {
	private int[] days = {15,17,22,20,21,19};	//index +4 => month, 4월 수업일수 15일로 수정했습니다
	
	static Calendar cal = Calendar.getInstance(); 		//default calendar is set today

	//cal.get(Calendar.MONTH)
	public static int getThisMonth(int year,int month, int date) {
		month=month-1;// Jan=0, Feb=1---
		cal.set(year,month,date);
		int today=date;
		int days=0;
		for(int i = 1; i<=today;i++) {			//공휴일 계산
			switch(month){
				case 3:
					if(i<6)
						continue;	//개강

					else if(15<=i && i<=17)
						continue; //선거일~징검다리 휴일, 주말포함
					
					else if(i==30)	//석가탄신일
						continue;
					else
						break;
				case 4:
					if(i==1 || i==4 || i==5 || i==15)
						continue;
					else
						break;
				case 6:
					if(17<=i && i<=21)	//여름휴가
						continue;
					else
						break;
				case 8:
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
	
	public int[] getDays() {
		return days;
	}

	public void setDays(int[] days) {
		this.days = days;
	}
	
}