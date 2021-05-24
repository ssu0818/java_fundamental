package java_20210506;

public class CustomerDemo {
	public static void main(String[] args) {
		Customer c1 = new Customer();
		c1.name = "가나다";
		c1.age = 20;
		c1.email = "test@test.com";
		c1.phone = "010-9090-9090";
		c1.balance = 1_000_000;
		c1.released = false;
//		c1.interestRate = 6.2;
		//클래스변수(static 변수)는 클래스 이름으로 접근하는 것이 관례
		//변수로도 접근가능하나 권장하지 않음 예) c1.interestRate = 6.2
		Customer.interestRate = 6.2; 
		//final 변수는 값을 재할당 할 수 없음
		//Customer.BANKNAME = "국민은행";
		
		System.out.printf("%s, %d, %s, %s, %f, %s %n", c1.name, c1.age, c1.email, c1.phone, c1.balance, c1.released);

		Customer c2 = new Customer();
		c2.name = "라마바";
		c2.age = 30;
		c2.email = "c0c@test.com";
		c2.phone = "010-3232-3232";
		c2.balance = 50_000_000_000_000l;
		c2.released = false;
//		c2.interestRate = 8.2;
		Customer.interestRate = 8.2;
		
		
		System.out.printf("%s, %d, %s, %s, %f, %s %n", c2.name, c2.age, c2.email, c2.phone, c2.balance, c2.released);
		
		Customer c3 = c2;
		c3.name = "라마바2";
		
		System.out.printf("%s, %s %n", c2.name, c3.name); //동일값 출력
		
		System.out.printf("%f %n", Customer.interestRate);
		
	}
}
