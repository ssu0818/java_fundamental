package java_20210511.step1;
/*
	1.[요구사항] : 밀리 세컨드로 경과 시간을 만들어 주세요.
	2.[요구사항] : 나노 세컨드로 경과 시간을 만들어 주세요.
*/
public class FootStopWatch {
	long startTime;
	long endTime;
	
	public double getElapsedTime() {
		return (double)(endTime - startTime)/1000;
	}
	
	public static void main(String[] args) {
		FootStopWatch f = new FootStopWatch();
		//1970년 1월 1일부터 현재까지의 시간을 밀리세컨드로 반환
		f.startTime = System.currentTimeMillis();
		
		for(long i = 0; i<30_000_000_000l; i++) {
			
		}
		
		f.endTime = System.currentTimeMillis();
		double elapsedTime = f.getElapsedTime();
		System.out.printf("경과시간 : %,.3f %n", elapsedTime);
		
	}
}
