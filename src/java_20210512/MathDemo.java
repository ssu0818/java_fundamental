package java_20210512;

public class MathDemo {
	public static void main(String[] args) {
		double d = Math.ceil(4.3);
		System.out.println(d);
		
		d = Math.floor(4.9);
		System.out.println(d);
		
		int i = Math.round(2.6f);
		System.out.println(i);
		
		long l = Math.round(4.2); //int 에러 --> int l = (int)Math.round(4.2); nono (API대로 코딩해)
		System.out.println(l);
		
		d = Math.abs(-4.2);
		System.out.println(d);
		
		d = Math.max(4.2, 5.2);
		System.out.println(d);
		
		d = Math.min(2.4, 1002.56);
		System.out.println(d);
		
		d = Math.sqrt(4); //2.0
		l = (long)Math.sqrt(4); //2
		d = Math.sqrt(3);
		System.out.println(d);
		
		d = Math.pow(2.0, 3.0);
		l = (long)Math.pow(2, 3); //승수 - 소수점이하x / int 사용시 값 범위 넘어가서 수 변질생김.
		System.out.println(d);
		
		d = Math.random();
		System.out.println(d);
		
		
		
	}
}
