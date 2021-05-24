package java_20210513;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Calendar2 {

	private Calendar cal;
	public Calendar2() {
		cal = Calendar.getInstance();
	}
	
	public void print(int year, int month, int day) {
		cal.set(year, month-1, day);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 입니다.");
		System.out.println(sdf.format(cal.getTime())); //format() date type필요 -> cal.getTime() date type
	}
	
	public void print(int year, int month) {
		System.out.println("< "+year+"년 "+month+"월 달력 >");
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		
		cal.set(year, month-1, 1);
		// 1->일요일, 2->월 .... 7->토요일
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		for(int i=0; i<dayOfWeek-1; i++) {
			System.out.print("\t");
		}
		
		for(int i=1; i<cal.getActualMaximum(Calendar.DATE); i++) {
			System.out.print(i +"\t");
			if(dayOfWeek%7 == 0) System.out.println();
			dayOfWeek++;
		}
		System.out.println();
	}
	
	public void print(int year) {
		for(int i=1; i<13; i++) {
			print(year, i);
		}
	}
}