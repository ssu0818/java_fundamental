package java_20210430;

public class IfDemo {
	public static void main(String[] args) {	
		// Run Configurations > Arguments > Program arguments 값 넣기
		int month = Integer.parseInt(args[0]);  
		
		//int month = 12;
		String season = "";
		if (month == 12 || month == 1 || month == 2) {
			season = "겨울";
		} else if (month == 3 || month == 4 || month == 5) { // month >= 3 && month <= 5
			season = "봄";
		} else if (month == 6 || month == 7 || month == 8) {
			season = "여름";
		} else if (month == 9 || month == 10 || month == 11) {
			season = "가을";
		} else {
			season = "잘못된 숫자";
		}
		System.out.println(month + "월은 " + season + "입니다.");
		System.out.println("=============");
		
		
		int a = 125900;
		double d = 125234.789;
		String name = "수연";
		
		System.out.printf("a는 %,d 입니다. %n", a); //%숫자 ex)%10 : 10자리 맞춰서 출력 / %0숫자 : 0을 채워서 출력 / %-숫자 : 뒤를 채움 / %,숫자 : ,채워줌 
		System.out.printf("d는 %,.2f 입니다. %n", d); //%.숫자 : 소수점자리 표현
		System.out.printf("내 이름은 %s 입니다. %n", name);
		System.out.printf("출력 다하기 >>> %s, %d, %f %n", name, a, d);
		System.out.println("=============");

		
		int a1 = 100;
		String msg = "";
		if(a1 % 2 == 0) {
			msg = "짝수";
		}else {
			msg = "홀수";
		}
		System.out.println(msg);
		
		msg = (a1 % 2 ==0) ? "짝수" : "홀수";
		System.out.println(msg);
		
		
		
	}
}
