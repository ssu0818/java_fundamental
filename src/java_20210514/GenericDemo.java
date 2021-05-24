package java_20210514;

import java.util.ArrayList;

public class GenericDemo {
	public static void main(String[] args) {
//		ArrayList list = new ArrayList(); //데이터 안정성이 없다... 3오류 안남.(실행하고 오류)
		ArrayList<String> list = new ArrayList<String>(); //3오류 남.
		list.add("1");
		list.add("2");
//		list.add(3); //auto-boxing , object type이기 때문에 >> 제너릭타입 명시 안되었을 때.
		list.add("3");			  
		
		for(int i=0; i<list.size(); i++) {
//			String value = (String)list.get(i); //3때문에 안됨. class casting오류. 
			String value = list.get(i); 
			System.out.println(value);
		}
		
		System.out.println("------");
		
		for(String value : list) {
			System.out.println(value);
		}
		
		
	}
}
