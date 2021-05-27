package java_20210527;

import java.util.ArrayList;

public class MemberDemo {
	public static void main(String[] args) {
		MemberDao dao = MemberDao.getInstance();
		/* MemberDao dao2 = MemberDao.getInstance();
		System.out.println(dao == dao2); //true. 같은 레퍼런스 참조. */
		
		
		/* 
		 **INSERT
		 
		int num = 12;
		String name = "김범수";
		String addr = "한국";
		
		MemberDto dto = new MemberDto(num, name, addr); 
		boolean success = dao.insert(dto);
		if(success) {
			System.out.println("insert 성공!");
		} else {
			System.out.println("insert 실패..");
		}
		*/
		
		
		
		/* 
		 ** UPDATE 
		 
		int num = 12;
		String name = "김범수1";
		String addr = "한국1";
		
		MemberDto dto = new MemberDto(num, name, addr); 
//		MemberDto dto = new MemberDto(); 
//		dto.setNum(12); ==> 생성자 사용 못했을 경우 이렇게...
		boolean success = dao.update(dto);
		if(success) {
			System.out.println("update 성공!");
		} else {
			System.out.println("update 실패..");
		}
		 */
		
		
		
		/* 
		 ** DELETE
	
		int num = 12;
		
		boolean success = dao.delete(num);
		if(success) {
			System.out.println("delete 성공!");
		} else {
			System.out.println("delete 실패..");
		}
		 */
		
		
		
		
		/* 
		 ** SELECT
		*/
		int start = 0;
		int len = 10;
		
		ArrayList<MemberDto> list = dao.select(start, len);
		for(MemberDto dto : list) {
			int num = dto.getNum();
			String name = dto.getName();
			String addr = dto.getAddr();
			System.out.printf("%d, %s, %s %n", num, name, addr);
		}
	}
}
