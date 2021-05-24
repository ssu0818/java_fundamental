package java_20210511;

public class Parent {
	String name;
	String address;
	int age;
	
	//alt+shift+s -> C : 디폴트 생성자 만듬.
	public Parent() {
		super();
	}
	
	//alt+shift+s -> O : 매개변수 있는 생성자 만듬.
	public Parent(String name, String address, int age) {
		super();
		this.name = name;
		this.address = address;
		this.age = age;
	}

}
