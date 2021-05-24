package java_20210507;

public class Calendar {
	private int[] monthArray = {31,28,31,30,31,30,31,31,30,31,30,31};
	
	public static final int MONDAY = 1;
	public static final int TUESDAY = 2;
	public static final int WENDESDAY = 3;
	public static final int THURSDAY = 4;
	public static final int FRIDAY = 5;
	public static final int SATURDAY = 6;
	public static final int SUNDAY = 0;
	
	private boolean isLeafYear(int year) {
		return (year%4==0 && year%100!=0) || year%400==0;
	}
	
	private int getCount(int year,int month, int day) {
		int totalCount = 365 * (year-1) + (year-1)/4 - (year-1)/100 + (year-1)/400;
		
		boolean isLeafYear = isLeafYear(year);
		if(isLeafYear){
			monthArray[1] = 29;
		}
		
		for(int i=0; i<month-1; i++) {
			totalCount += monthArray[i];
		}
		
		totalCount += day;
		return totalCount;
	}
	
	//이 라인 먼저 코딩 시작
	public void print(int year, int month, int day) {
			int totalCount = getCount(year, month, day);
			int dayOfWeek = totalCount % 7;
			String message = "";
//			if(dayOfWeek == 1) { //이렇게 작성하면 다른 사람들이 모름. 좋은 코드 x
			if(dayOfWeek == Calendar.MONDAY) {
				message = "월요일";
			}else if(dayOfWeek == Calendar.TUESDAY) {
				message = "화요일";
			}else if(dayOfWeek == Calendar.WENDESDAY) {
				message = "수요일";
			}else if(dayOfWeek == Calendar.THURSDAY) {
				message = "목요일";
			}else if(dayOfWeek == Calendar.FRIDAY) {
				message = "금요일";
			}else if(dayOfWeek == Calendar.SATURDAY) {
				message = "토요일";
			}else if(dayOfWeek == Calendar.SUNDAY) {
				message = "일요일";
			}
			System.out.printf("%d년 %d월 %d일 %s 입니다.", year, month, day, message);
	}
	
	public void print(int year, int month) {
		System.out.println("< "+year+"년 "+month+"월 달력 >");
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		
		//탭만큼 띄어쓰기 해야한다. 예) 2021년 5월 달력을 출력하기 위해서는 2021년 5월 1일까지 총 날짜를 구해서 7로 나눈 나머지 만큼 띄어쓰기 하면 된다.
		int totalCount = getCount(year, month, 1); //day 없기때문에 1일 지정해서 넣어줌
		int rest = totalCount % 7; //예)2021년 5월 1일은 토요일(나머지6)
		//int count = 0; // count변수를 줄 바꿈 목적으로 만드는 것.
		for(int i=0; i<rest; i++) {
			System.out.print("\t");
			//count++;
		}
		
		for(int i=1; i<monthArray[month-1]; i++) {
			System.out.print(i +"\t");
			//count++;
			//if(count%7 == 6) System.out.println();
			if(rest%7 == 6) System.out.println();
			rest++;
		}
		System.out.println();
	}
	
	public void print(int year) {
		for(int i=1; i<13; i++) {
			print(year, i);
		}
	}
}