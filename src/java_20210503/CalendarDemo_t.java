package java_20210503;

public class CalendarDemo_t {

	public static void main(String[] args) {
		
		int year = 2021;
		int month = 4;
		int day = 30;
		
		//2020년까지 총일수
		int totalCount = 365 * (year-1) + (year-1)/4 - (year-1)/100 + (year-1)/400 ;
		
		//2021년도의 1월, 2월, 3월의 합을 구한다.
		totalCount += 31 + 28 + 31;
		
		//2021년도 4월의 일수를 더한다.
		totalCount += day;
		
		int dayOfWeek = totalCount % 7;
		
		String message = "";
		if (dayOfWeek % 7 == 1) {
			message = "월요일";
		} else if (dayOfWeek % 7 == 2) {
			message = "화요일";
		} else if (dayOfWeek % 7 == 3) {
			message = "수요일";
		} else if (dayOfWeek % 7 == 4) {
			message = "목요일";
		} else if (dayOfWeek % 7 == 5) {
			message = "금요일";
		} else if (dayOfWeek % 7 == 6) {
			message = "토요일";
		} else if (dayOfWeek % 7 == 0) {
			message = "일요일";
		} else {
			System.out.println("잘못된 날짜입니다.");
		}
		
		System.out.printf("%d년 %d월 %d일 %s 입니다.", year, month, day, message);
		
		
	}

}
