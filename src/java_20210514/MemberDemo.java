package java_20210514;

import java.util.ArrayList;

public class MemberDemo {
	public static void main(String[] args) {
		MemberManager m = new MemberManager();
		m.insert("id1111","이름1",20);
		m.insert("id2222","이름2",30);
		m.insert("id3333","이름3",40);
		m.insert("id4444","이름4",50);
		
		ArrayList list = m.select();
		for(int i=0; i<list.size(); i++) {
			Member m2 = (Member)list.get(i);
			System.out.printf("%s, %s, %d %n",m2.getId(),m2.getName(),m2.getAge());
		}
		System.out.println("-----------");
		
		
		
		m.delete("id1111");
		for(int i=0; i<list.size(); i++) {
			Member m2 = (Member)list.get(i);
			System.out.printf("%s, %s, %d %n",m2.getId(),m2.getName(),m2.getAge());
		}
		System.out.println("-----------");
		
		
		
		m.update("id3333","이름5",10);
		for(int i=0; i<list.size(); i++) {
			Member m2 = (Member)list.get(i);
			System.out.printf("%s, %s, %d %n",m2.getId(),m2.getName(),m2.getAge());
		}
		System.out.println("-----------");
		
		
		
		Member m3 = m.select("id3333");
		System.out.printf("%s, %s, %d %n",m3.getId(),m3.getName(),m3.getAge());
		
	}
}
