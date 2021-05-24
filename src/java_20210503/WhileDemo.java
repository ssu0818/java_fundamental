package java_20210503;

public class WhileDemo {

	public static void main(String[] args) {
		int sum = 0;
		int i = 1; //초기값
		while(i<=10) { //조건
			sum += i;
			i++; //증감
		}
		
		System.out.printf("1부터 10까지 합 : %d :D %n", sum);
		
		
		sum = 0;
		int j = 1;
		for(;j<11;) {
			sum += j;
			j++;
		}
				
		System.out.printf("1부터 10까지 합 : %d :) %n", sum);
		
		
		//구구단
		int dan = 2;
		
		while(dan<10) {
			int b = 1;
			System.out.printf("<%d단> %n",dan);
			while(b<10) {
				System.out.printf("%d * %d = %d %n", dan, b, dan*b);
				b++;
			}
			dan++;
		}		
	}
}
