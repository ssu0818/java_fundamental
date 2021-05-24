package java_20210517;

import java.util.ArrayList;

public class ExceptionDemo {
	public static void main(String[] args) {
		
		//java.lang.NumberFormatException => 예외처리 해야 함.
		//1111a => 예외처리를 해야 함.
		//11.34 => 코드를 변경해야 함.
		int i = Integer.parseInt("1111");
//		int i = Integer.parseInt("1111a");
		System.out.println(i);
		double d = Double.parseDouble("11.34");
//		int i = Integer.parseInt("11.34");
		System.out.println(d);
		
		
		//java.lang.ArrayIndexOutOfBoundsException
		//배열의 범위를 벗어나면 발생하는 예외
		int[] a = {1,2,3,4};
		System.out.println(a[3]);
//		System.out.println(a[4]);
		
		
		//java.lang.IndexOutOfBoundsException 
		//Collection에서 범위를 벗어나면 발생하는 예외
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(123); //auto-boxing
//		System.out.println(list.get(1));
		System.out.println(list.get(0));
		
		
		//java.lang.NullPointerException
		//객체를 생성하지 않고 메서드를 사용하면 발생하는 예외
		String str = "hello";
//		String str = null;
		System.out.println(str.length());
		
		
		//java.lang.ArithmeticException
		int b = 10;
		int c = 0;
//		System.out.println(b/c); //분모가 0일 경우 오류발생 / 분자가 0일 경우 실행됨
		
		
	}
}
