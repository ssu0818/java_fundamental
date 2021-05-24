package java_20210430;

public class OperatorDemo {
	public static void main(String[] args) {
		int a = 10, b = 22;
		int c = 0;
		double d = 0.0;
		
		c = a + b;
		System.out.println("a+b = "+c);
		
		c = a - b;
		System.out.println("a-b = "+c);
		
		c = a * b;
		System.out.println("a*b = "+c);
		
		c = b / a;
		System.out.println("b/a = "+c);
		
		d = (double)b / a;
		System.out.println("(double)b/a = "+d);
		
		c = b % a;
		System.out.println("b%a = "+c);
		
		
		System.out.println("=========");
		if(a%2==0) {
			System.out.println("짝수 :)");
		}else {
			System.out.println("홀수 :)");
		}
		
		
		System.out.println("=========");
		//복합대입 연산자
		a += b ; // a = a+b;
		System.out.println("a+=b : "+a);
		
		int sum = 0;
		for(int i=0; i<=100; i++) {
			sum += i;
		}
		System.out.println(sum);
		
		
		System.out.println("=========");
		//증감 연산자
		a++;
		++b;
		
		System.out.println(a); //33
		System.out.println(b);

		a=10;
		//대입후 증가
		c = a++;
		System.out.println("a++ : "+c);
		
		a=10; //a를 10으로 초기화한다.
		//증가후 대입
		c = ++a;
		System.out.println("++a :" +a);

		
		System.out.println("=========");
		//비교 연산자
		a = 10;
		b = 20;
		
		boolean isSuccess = a > b;
		System.out.println(isSuccess);
		
		if(a>b) {
			System.out.println("a가 b보다 크다");
		}else {
			System.out.println("a가 b보다 작다");
		}
		
		d = 10.0;
		isSuccess = a==d;
		System.out.println(isSuccess);
		
		
		System.out.println("=========");
		//논리연산자
		a=10; b=20;
		//A && B => A가 false이면 B을 연산하지 않음(short circuit발생)
		isSuccess = (a==b) && (++a == b++);
		System.out.println(isSuccess);
		System.out.println(a);
		System.out.println(b);
		
		System.out.println("--------");
		//A || B => A가 true이면 B을 연산하지 않음(short circuit발생)
		isSuccess = (a==b) || (++a == b++);
		System.out.println(isSuccess);
		System.out.println(a);
		System.out.println(b);		
		
	}
}
