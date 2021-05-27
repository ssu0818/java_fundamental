package java_20210527;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcDeleteDemo {
	public static void main(String[] args) {
		try {
			// 1. 드라이버를 로드한다.
			Class.forName("org.mariadb.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			// 2. 데이터베이스와 연결할 수 있는 Connection 객체를 생성.
			con = DriverManager.getConnection("jdbc:mysql://localhost/kpc","kpc12","kpc1212");
			
			// 3. SQL을 전송할 수 있는 PrepraredStatement 객체를 생성.
			StringBuilder sql = new StringBuilder();
			sql.append("delete from member ");
			sql.append("where num = ? ");

			pstmt = con.prepareStatement(sql.toString());
			
			// 4. 바인딩 변수를 설정.
			int index = 1;
			pstmt.setInt(index, 11);
//			pstmt.setString(index, String.valueOf(11));
			
			// 5. SQL문을 전송.
			int resultCount = pstmt.executeUpdate();
			System.out.println("갱신된 행의 수 : " + resultCount);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 6. 모든 자원을 반납.
				try {
					if(con != null) con.close();
					if(pstmt != null) pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
}
