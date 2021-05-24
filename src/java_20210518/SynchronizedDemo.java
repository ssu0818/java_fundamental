package java_20210518;

public class SynchronizedDemo implements Runnable{
	int x;
	int y;

	@Override
	public void run() { //public synchronized void run()
		synchronized(SynchronizedDemo.class) { // or this
			for(int i=0; i<1000; i++) {
				x++;
				y++;
				String threadName = Thread.currentThread().getName();
				System.out.printf("x : %d , y: %d - %s %n", x,y,threadName);
			}
		}
	}
	
	
	public static void main(String[] args) {
		SynchronizedDemo s1 = new SynchronizedDemo();
		SynchronizedDemo s2 = new SynchronizedDemo();
		Thread t1 = new Thread(s1);
		Thread t2 = new Thread(s1); // 값 2000으로 끝남. synchronized하기 전 스레드 번갈아 
//		Thread t2 = new Thread(s2); // 값 1000으로 끝. 서로 다른 객체일 때 synchronized 영향x. 스레드가 synchronized했지만 lock pool로 이동하지않았기 때문에.
		t1.start();
		t2.start();
		
	}
}
