package java_20210510;

public class MemberDemo {
	public static void print(Member m) {
		System.out.println(m.getName());
		System.out.println(m.getEmail());
		System.out.println(m.getZipcode());
		System.out.println(m.getAddr1());
		System.out.println(m.getAddr2());
		System.out.println(m.getAge());		
	}
	
	public static void main(String[] args) {
		Member m = new Member();
		m.setName("이름");
		m.setEmail("email@naver.com");
		m.setZipcode("09877");
		m.setAddr1("서울 용산구 이태원동");
		m.setAddr2("한강아파트 110동");
		m.setAge(20);
		
		print(m);
	}
}
