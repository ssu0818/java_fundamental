package java_20210517;

public class TryCatchDemo {
	
	public static double getAvgs(int k, int e) {
		int sum = k + e;
		double avg = (double) sum / 2;
		return avg;
	}
	
	//javac TryCatchDemo.java => compile
	//java TryCatchDemo 10 20 30
	//Run Configurations -> Arguments -> Program arguments
	// -> 10 20
	// -> 10 a -> java.lang.NumberFormatException
	// -> 10   -> java.lang.ArrayIndexOutOfBoundsException

	public static void main(String[] args) {
		try {
			int korean = Integer.parseInt(args[0]);
			int english = Integer.parseInt(args[1]);
			
			double average = getAvgs(korean, english);
			
			System.out.printf("국어, 영어의 평균 점수는 %.1f입니다. %n", average);
		}catch(NumberFormatException e){
			/*
			 catch 블럭의 수행문을 만들 때 2가지 형태로 코딩한다.
			 1. 에러 메세지를 출력 (개발자) - 개발단계에서
			 2. 에러 메세지를 출력 (사용자) - 서비스단계에서
			 */ 
//			e.printStackTrace(); // error stack 모두 다 보고 싶은 경우
			System.err.println(e.getMessage()); // 에러 메세지만 보고 싶은 경우 -- 사용자에게 절대 보여주면 안됨.
			System.err.println("문자말고 숫자를 넣어 !");
		}catch(ArrayIndexOutOfBoundsException e){
			/*
			 catch 블럭의 수행문을 만들 때 2가지 형태로 코딩한다.
			 1. 에러 메세지를 출력 (개발자)
			 2. 에러 메세지를 출력 (사용자)
			 */
//			e.printStackTrace(); // error stack 모두 다 보고 싶은 경우
			System.err.println(e.getMessage()); // 에러 메세지만 보고 싶은 경우
			System.err.println("인자 2개가 필요해 !");
		}finally {
			System.out.println("무조건 수행되는 블럭 - finally");
		}
	}
}
