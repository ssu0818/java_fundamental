package java_20210510;

public class AdminDemo {
	public static void main(String[] args) {
		//Math m = new Math(); //에러발생 -> private. why? 대부분 public , 객체 생성하지 못하도록 막음.
		// Admin a = new Admin("id2021","123","email@naver.com"); // 3개 호출 가능. 
		Admin a = new Admin("id2021","123","email@naver.com",20); 
							  // Admin.java -> 디폴트 생성자 public Admin(){} 지우게 되면 에러발생.
							  // public Admin(String id, String pwd, String email, int level) {} 존재하기 때문
							  // 위 라인 지우게되면 에러발생하지 않음.(프로그램이 자동으로 디폴트값 생성하기 때문)
		
		System.out.println(a.getId());
		System.out.println(a.getPwd());
		System.out.println(a.getEmail());
		System.out.println(a.getLevel());
		
		Admin a1 = new Admin();
		a1.setEmail("email@naver.com"); // => 17,18라인 보다 7라인이 good.
	}
	
}
