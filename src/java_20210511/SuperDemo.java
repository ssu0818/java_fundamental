package java_20210511;

class A{
	int a;
	A(int a){
		super(); //Object 클래스 -> 초기화.
		this.a = a;
	}
}

class B extends A{
	B(){ //없으면 오류 발생.
		super(10);
	}
}

public class SuperDemo {
	public static void main(String[] args) {
		B b = new B();
		System.out.println(b.a);
	}
}
