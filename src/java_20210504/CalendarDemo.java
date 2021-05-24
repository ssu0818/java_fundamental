package java_20210504;

public class CalendarDemo {

	public static void main(String[] args) {
		/*
		 * 달력 만들기
		 * 1. 1년 1월 1일은 월요일
		 * 2. 1년은 365일 이고, 윤년은 366일 - 2월 29일
		 * 3. 윤년은 4년마다 발생하고 그중에서 100배수는 제외하고 
		 *    400배수는 제외하지 않는다.
		 * 4. 2021년 4월 30일은 무슨요일 일까요?
		 * 힌트) 2020년까지 총일수, 1-3월까지 총일수 , 30을 더해서 
		 *     7로 나눈 나머지가 1이면 월요일, 2이면 화요일....
		 */
		int year = 2024;
		int month = 5;
		int day = 4;
		
		//2020년까지 총일수 
		int totalCount = 365 *(year-1)  
				+ (year-1)/4 //2020년까지 윤년   
				- (year-1)/100 //2020년까지 100의 배수는 제외
				+ (year-1)/400; // 2020년까지 400의 배수는 추가
		//2021년도의 1월, 2월, 3월의 합을 구한다.
		//totalCount = totalCount + 31 + 28 +31;
		int[] monthArray = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		boolean isLeafYear = (year%4==0 && year%100!=0 || year%400==0);
		if(isLeafYear){
			monthArray[1] = 29;
		}
		
		for(int i=0; i<month-1; i++) {
			totalCount += monthArray[i];
		}
		//totalCount += 31 + 28 + 31;
		
		//2021년도 4월의 일수를 더한다.
		totalCount += day;
		
		int dayOfWeek = totalCount % 7;
		String message = "";
		if(dayOfWeek == 1) {
			message = "월요일";
		}else if(dayOfWeek == 2) {
			message = "화요일";
		}else if(dayOfWeek == 3) {
			message = "수요일";
		}else if(dayOfWeek == 4) {
			message = "목요일";
		}else if(dayOfWeek == 5) {
			message = "금요일";
		}else if(dayOfWeek == 6) {
			message = "토요일";
		}else if(dayOfWeek == 0) {
			message = "일요일";
		}
		
		System.out.printf("%d년 %d월 %d일 %s 입니다.", year, month, day, message);

		
	}

}