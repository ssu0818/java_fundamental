package java_20210513;

public class StringDemo {
	public static void main(String[] args) {
		char[] c= {'h','e','l','l','o'};		
		String str = new String(c);
		//String str = new String(c,2,2); 두번째 두개
		System.out.println(str);
		//String str = new String("hello");
		
		//charAt() : 문자열 중에 특정 문자 하나만 반환하는 메서드. index는 0부터 시작.
		char c1 = str.charAt(1);
		System.out.println(c1);
		
		//concat() : 문자열 연결하는 메서드
		str = str.concat("123");
		System.out.println(str);
		
		//endsWith(String msg) : msg문자열로 끝나면 true, 그렇지 않으면 false. 
		str = new String("abc.zip");
		if(str.endsWith("zip")) {
			System.out.println("압축파일 입니다 :D");
		}else if(str.endsWith("doc")){
			System.out.println("워드문서 입니다 :D");
		}else {
			System.out.println("파일 입니다.");
		}

		//startsWith(String msg) : msg문자열로 시작하면 true, 그렇지 않으면 false.
		String path = new String("/news/board.do?id=123&cat1");
		if(path.startsWith("/news")) {
			System.out.println("뉴스 페이지 입니다.");
		}else if(path.startsWith("/sports")){
			System.out.println("스포츠 페이지 입니다.");
		}else {
			System.out.println("페이지가 존재하지 않습니다.");
		}
		
		//equals() : 문자열 비교
		//equalsIgnoreCase() : 대소문자 구분하지 않고 비교
		//.trim() : 앞 뒤 공백제거
		String m1 = new String(" hello ").trim();
		String m2 = new String("hello");
		if(m1.equals(m2)) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
		
		//getBytes() : 문자열을 바이트 배열로 반환하는 메서드
		String m3 = new String("안녕하세요.");
		byte[] b = m3.getBytes();
		System.out.println("getBytes: "+b.length);
				
		//indexOf() 
		String m4 = new String("111111-1111118");
		int index = m4.indexOf("-");
		System.out.println("index: "+index);
		
		//lastIndexOf()
		String m5 = new String("a.b.c.zip");
		int lastIndexOf = m5.lastIndexOf(".");
		System.out.println("lastIndexOf: "+lastIndexOf);
		
		//substring()
//		System.out.println(m4.substring(0, 6));
//		System.out.println(m4.substring(7));
		System.out.println("===substring()===");
		System.out.println(m4.substring(0, m4.indexOf("-")));
		System.out.println(m4.substring(m4.indexOf("-")+1));
		
		System.out.println(m5.substring(0, m5.lastIndexOf(".")));
		System.out.println(m5.substring(m5.indexOf(".")+1));
		
		String m6 = new String("010-1234-5432");
		System.out.println(m6.substring(0,m6.indexOf("-")));
		System.out.println(m6.substring(m6.indexOf("-")+1,m6.lastIndexOf("-")));
		System.out.println(m6.substring(m6.lastIndexOf("-")+1));
		
		//valueOf() : primitive -> string
		int a1 = Integer.parseInt(m4.substring(0,1));
//		String m7 = 123+"";
		String m8 = String.valueOf(123);
		
		//replaceAll()
		System.out.println("==replaceAll==");
		String m9 = m6.replaceAll("-", "*");
		System.out.println(m9);
		
		//toUpperCase, toLowerCase
		System.out.println("==toUpperCase,toLowerCase==");
		String m10 = new String("hello");
		String m11 = m10.toUpperCase();
		System.out.println(m11);
		String m12 = m11.toLowerCase();
		System.out.println(m12);
		
		//split()
		System.out.println("==split==");
		String[] temp = m6.split("-");
		for(String value : temp) {
			System.out.println(value);
		}
		 
		//format()
		System.out.println("==format==");
		double d = 123456.342;
		String m13 = String.format("%,.2f", d);
		System.out.println(m13);
		System.out.format("%s %n", m13);
		System.out.printf("%s %n", String.format("%,.2f", d));
		
	}
}
