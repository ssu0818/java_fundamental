package java_20210503;

public class ForDemo {

	public static void main(String[] args) {
		//1-10 합
		int sum = 0;

		for(int i=1; i<=10; i++) {
			sum += i;
		}
		
		System.out.printf("1부터 10까지의 합은 %d 입니다. \n", sum);

		
		//짝수 합1
		sum = 0;
		for(int i=0; i<=10; i++) {
			if(i%2==0) {
				sum += i;
			}
		}
		
		System.out.printf("1부터 10까지 짝수의 합은 %d 입니다. \n", sum);

		//짝수 합2 (1보다 이 반복문이 good)
		sum = 0;
		for(int i=0; i<=10; i+=2) {
			sum += i;
		}
		
		System.out.printf("1부터 10까지 짝수의 합은 %d 입니다. \n", sum);
		
		
		//구구단_t
		for(int first =2; first < 10; first++) {
			System.out.printf("%d단 입니다. %n", first);
			for(int second = 1; second < 10; second++) {
				System.out.printf("%d * %d = %d %n", first, second, first*second);
			}
		}
		
		//구구단
		for(int i=2; i<10; i++) {
			System.out.printf("<%d단> %n",i);
			for(int j=1; j<10; j++) {
				//System.out.println(i +" * " + j + " = " + i*j);
				System.out.printf("%d * %d = %d %n", i, j, i*j);
			}
		}
		
		//소수
		int totalCountOfPrimeNumber=0;
		int totalIndex = 0;
		//1보다 큰 자연수 중 1과 자기 자신만을 약수로 가지는 수 예)2,3,5....
		for(int i=2; i<=100; i++) {
			int count = 0;
/*
 * 방법1)
			for(int j=1; j<=i; j++) {
				if(i%j==0) {
					count++;
				}
				totalIndex++;
			}
			if(count==2) {
				totalCountOfPrimeNumber++;
				System.out.print(i+"\t");
			}
			totalIndex++;
			
*/
			
/*
 * 방법2)
			for(int j=2; j<i; j++) {
				if(i%j==0) {
					count++;
				}
				totalIndex++;
			}
			if(count==0) {
				totalCountOfPrimeNumber++;
				System.out.print(i+"\t");
			}
			totalIndex++;
		}
*/

//방법3)
			for(int j=2; j<i; j++) {
				if(i%j==0) {
					count++;
					break;
				}
				totalIndex++;
			}
			if(count==0) {
				totalCountOfPrimeNumber++;
				System.out.print(i+"\t");
			}
			totalIndex++;
		}
		
		
		
		System.out.println();
		System.out.println(totalCountOfPrimeNumber);
		System.out.println(totalIndex);
		
		
		
		
		
		
	}
}
