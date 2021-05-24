package java_20210430;

public class CalendarDemo {

	public static void main(String[] args) {
		/*
		 <달력 만들기>
		 1. 1년 1월 1일은 월요일 
		 2. 1년은 365일 이고, 윤년은 366일 - 2월29일 
		 3. 윤년은 4년마다 발생하고 그중에서 100배수는 제외하고 400배수는 제외하지 않는다. //  윤년: 4의 배수 이 중에서 100의 배수 제외, 이중에서 400의 배수 윤년.  
		 4. 2021년 4월 30일은 무슨 요일? 
		 힌트) 2020년까지 총일수, 2021년 1~3월까지 총일수, 30을 더해서 7로 나눈 나머지가 1이면 월요일, 2이면 화요일 ...
		 */

		int year = 2021;
		int month = 4;
		int day = 30;
		int total = 0; // 총일수
		int tday = 0; // 한달 일수
		String date = ""; // 요일

		for (int i = 1; i < month; i++) {
			if (i == 2) {
				tday += year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ? 29 : 28;
			} else if (i == 4 || i == 6 || i == 9 || i == 11) {
				tday += 30;
			} else {
				tday += 31;
			}
		}

		total = ((year - 1)*365 + (year-1)/4 - (year-1)/100 + (year-1)/400 + tday + day) % 7;
		
		/*
		System.out.println(tday);
		System.out.println(day);
		System.out.println(year);
		System.out.println("total: " + total);
		*/
		
		// 요일 확인
		if (total % 7 == 1) {
			date = "월요일";
		} else if (total % 7 == 2) {
			date = "화요일";
		} else if (total % 7 == 3) {
			date = "수요일";
		} else if (total % 7 == 4) {
			date = "목요일";
		} else if (total % 7 == 5) {
			date = "금요일";
		} else if (total % 7 == 6) {
			date = "토요일";
		} else if (total % 7 == 0) {
			date = "일요일";
		} else {
			System.out.println("잘못된 날짜입니다.");
		}
		
		
		System.out.println(year + "년 " + month + "월 " + day + "일은 " + date + "입니다! :D");

		// System.out.printf("%d년 %d월 %d일 %s 입니다! :D", year, month, day, date);
		
		/*
		switch (total % 7) { 
			case 0: 
				System.out.println("일요일"); break; 
			case 1:
				System.out.println("월요일"); break;
 		
		}
		 */

	}
}