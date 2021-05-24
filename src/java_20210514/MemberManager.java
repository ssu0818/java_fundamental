package java_20210514;

import java.util.ArrayList;

public class MemberManager {
	private ArrayList list;
	
	public MemberManager() {
		list = new ArrayList();
	}
	
	public void insert(String id, String name, int age) {
		list.add(new Member(id,name,age));
	}
	
	public void update(String id, String name, int age) {
		for(int i=0; i<list.size(); i++) {
			Member m = (Member)list.get(i);
			if(id.equals(m.getId())) {
				/*
				list.remove(i);
				list.add(i,new Member(id, name, age));
				*/
				m.setAge(age);
				m.setName(name);
				break;
			}
		}
	}
	
	public void delete(String id) {
		for(int i=0; i<list.size(); i++) {
			Member m = (Member)list.get(i);
			if(id.equals(m.getId())) {
				list.remove(i);
				break;
			}
		}
	}
	
	public ArrayList select() {
		return list;
	}
	
	public Member select(String id) {
		Member member = null;
		for(int i=0; i<list.size(); i++) {
			Member m = (Member)list.get(i);
			if(id.equals(m.getId())) {
				member = m;
				break;
			}
		}
		return member;
	}
}
