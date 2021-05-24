package java_20210512;

//클래스에서 인터페이스를 상속받을 때는 implements 키워드 사용.
public class ImplementClass implements InterA{
	//overriding 하기전 오류발생.
	public void mA() {
		System.out.println("mA 메서드");
	}
	
	public void mB() {
		System.out.println("mB 메서드");
	}
	
	public void mC() {
		System.out.println("mC 메서드");
	}
}
