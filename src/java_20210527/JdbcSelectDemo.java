package java_20210527;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcSelectDemo {
	public static void main(String[] args) {
		// 1. 드라이브 로드.
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 2. 데이터베이스와 연결할 수 있는 Connection 객체 생성.
			con = DriverManager.getConnection("jdbc:mysql://localhost/kpc", "kpc12", "kpc1212");

			// 3. SQL문을 전송할 수 있는 PreparedStatement 객체 생성.
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT num, NAME, addr ");
			sql.append("FROM member ");
			sql.append("ORDER BY num desc ");
			sql.append("LIMIT ?, ? ");

			pstmt = con.prepareStatement(sql.toString());

			// 4. 바인딩 변수 설정.
			int index = 1;
			pstmt.setInt(index++, 0);
			pstmt.setInt(index, 2);

			// 5. SQL문을 전송(executeQuery())하여 ResultSet객체를 생성.
			rs = pstmt.executeQuery();

			// 6. ResultSet에서 데이터를 추출 -> getXXX(index or column)
			while (rs.next()) {
				index = 1;
				int num = rs.getInt(index++); //rs.getInt(1); // or rs.getInt("num");
				String name = rs.getString(index++); //rs.getInt(2); // rs.getString("name");
				String addr = rs.getString(index); //rs.getInt(3); // rs.getString("addr");
				System.out.printf("%d, %s, %s %n", num, name, addr);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // 7. 모든 자원을 반납
			try {
				if (con != null) con.close();
				if (pstmt != null) pstmt.close();
				if (rs != null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
