package java_20210511.step2;

public class StopWatchDemo {
	
	public static void main(String[] args) {
		StopWatch s = new StopWatch();
//		s.start();
		s.startNano();
		for(long i = 0; i<30_000_000_000l; i++) {
			
		}
		
//		s.stop();
		s.stopNano();
		double elapsedTime = s.getElapsedTime();
//		System.out.printf("경과시간 : %,.3f %n", elapsedTime);
		System.out.printf("경과시간 : %,.9f %n", elapsedTime);
		
		
	}	
}
