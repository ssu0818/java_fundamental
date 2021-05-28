package java_20210528;

import java.util.ArrayList;

public class EmpDemo {
	public static void main(String[] args) {
		EmpDao dao = EmpDao.getInstance();

		/*
		//INSERT
		EmpDto dto = new EmpDto(9003, "KIM", "MANAGER", 7839, null, 50000, 40000, 30);
		boolean success = dao.insert(dto);
		if(success) {
			System.out.println("insert 성공");
		}else {
			System.out.println("insert 실패");
		}
		*/
		
		
		
		//SELECT
		ArrayList<EmpDto> list = dao.select(0,10);
		for(EmpDto dto : list) {
			System.out.printf("%d, %s, %s, %d, %s, %.1f, %.1f, %d %n", 
					dto.getNo(),dto.getName(),dto.getJob(),dto.getMgr(),
					dto.getHiredate(),dto.getSal(),dto.getComm(),dto.getDeptNo());
		}
		
		
	}
}
