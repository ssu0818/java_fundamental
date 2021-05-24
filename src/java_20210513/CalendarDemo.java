package java_20210513;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarDemo {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DATE);
//		int hour = cal.get(Calendar.HOUR); //5:44 출력
		int hour = cal.get(Calendar.HOUR_OF_DAY); //17:44출력
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		
		System.out.printf("%d연, %d월, %d일 %n",year,month+1,day);
		System.out.printf("%d:%d:%d %n",hour,minute,second);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println(dayOfWeek); //목 : 5
		StringBuffer message = new StringBuffer();
		if(dayOfWeek==Calendar.SUNDAY) {
			message.append("일요일");		
		}else if(dayOfWeek==Calendar.MONDAY) {
			message.append("월요일");
		}else if(dayOfWeek==Calendar.TUESDAY) {
			message.append("화요일");
		}else if(dayOfWeek==Calendar.WEDNESDAY) {
			message.append("수요일");
		}else if(dayOfWeek==Calendar.THURSDAY) {
			message.append("목요일");
		}else if(dayOfWeek==Calendar.FRIDAY) {
			message.append("금요일");
		}else if(dayOfWeek==Calendar.SATURDAY) {
			message.append("토요일");
		}
		
		System.out.printf("%d년 %d월 %d일 %s입니다 :) %n", year, month+1, day, message.toString());
		
		
		//(단축키)ctrl + shift + 5: 자동 import
		
		cal.set(2020, 1, 13); //날짜 변경할 때 사용하는 메서드
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 HH시 mm분 ss초"); 
		/*
		Date d = cal.getTime();
		String display = sdf.format(d);
		String display = sdf.format(cal.getTime());
		System.out.println(display);
		*/
		System.out.println(sdf.format(cal.getTime()));
		
		//해당 월 마지막 날짜 반환
		int lastDay = cal.getActualMaximum(Calendar.DATE); 
		System.out.println(lastDay);
		
		
		
		
	}
}
