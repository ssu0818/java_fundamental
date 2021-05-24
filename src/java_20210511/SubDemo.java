package java_20210511;

public class SubDemo {

	public static void main(String[] args) {
		Sub sub = new Sub();
		System.out.println(sub.money);
		sub.makeMoney();
		System.out.println(sub.chicken);
		sub.gotoSchool();
		sub.play("");
		
		Super sup = new Super();
		System.out.println(sup.money);
		sup.makeMoney();
		sup.play("");
		
		System.out.println("----------");
		
		Super sup1 = new Sub(); //overriding된 것은 하위 클래스에 있는 메서드 호출.
		System.out.println(sup1.money);
		sup1.makeMoney();
		sup1.play(""); //Sub에 있는 play()호출됨
		
		System.out.println("------------"); // 재정의한 것이 호출됨. (Sub.java --> toString() )
		System.out.println(sub);
		System.out.println(sub.toString());
		
		
		Object obj = new Sub(); // 객체의 형변환
		System.out.println(obj.toString()); // overriding된 메서드 toString() 호출됨 
		
	}

}
