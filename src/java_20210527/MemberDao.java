package java_20210527;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDao {
	// 1. MemberDao 변수인 single을 static 변수로 설정.
	private static MemberDao single;

	// 2. 생성자의 접근한정자를 private으로 설정 -> (이유) 외부에서 객체생성 못하게 하기 위함.
	private MemberDao() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 3. MemberDao의 객체는 getInstance() 메서드로만 생성.
	// getInstance() 메서드의 구현은 MemberDao 객체를 한개만 생성할 수 있도록 만들어야함.
	// static 메서드로 구현한 이유는 MemberDao 객체를 외부에서 생성할 수 없기 때문.
	public static MemberDao getInstance() {
		if (single == null) {
			single = new MemberDao();
		}
		return single;
	} // ===> singleton 단축 만들어놨었음.
	
	
	public boolean insert(MemberDto dto) {
//	public boolean insert(int num, String name, String addr) {
		boolean success = false;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kpc", "kpc12", "kpc1212"); // url(mariaDB
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO member(num, NAME, addr)");
			sql.append("VALUES(?, ?, ?)");

			pstmt = con.prepareStatement(sql.toString());

			int index = 1;
//			pstmt.setInt(index++, num);
			pstmt.setInt(index++, dto.getNum());
//			pstmt.setString(index++, name);
			pstmt.setString(index++, dto.getName());
//			pstmt.setString(index++, addr);
			pstmt.setString(index++, dto.getAddr());
			
			pstmt.executeUpdate();
			success = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) con.close();
				if (pstmt != null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return success;
	}

	
	
	public boolean update(MemberDto dto) {
		boolean success = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/kpc","kpc12","kpc1212");
			
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE member ");
			sql.append("SET NAME=?, addr=? ");
			sql.append("WHERE num=? ");
			pstmt = con.prepareStatement(sql.toString());
			
			int index = 1;
			/*
			pstmt.setString(index++, "봄이이2");
			pstmt.setString(index++, "충청도");
			pstmt.setInt(index, 11);
			*/
			pstmt.setString(index++, dto.getName());
			pstmt.setString(index++, dto.getAddr());
			pstmt.setInt(index, dto.getNum());
			
			pstmt.executeUpdate();
			success = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { 
				try {
					if(con != null) con.close();
					if (pstmt != null) pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return success;
	}

	
	
	public boolean delete(int num) { //MemberDto넘길 필요는 없음...값 한개이기 때문.
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean success = false;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/kpc","kpc12","kpc1212");
			
			StringBuilder sql = new StringBuilder();
			sql.append("delete from member ");
			sql.append("where num = ? ");

			pstmt = con.prepareStatement(sql.toString());
			
			int index = 1;
			pstmt.setInt(index, num);
			
			pstmt.executeUpdate();
			success = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				try {
					if(con != null) con.close();
					if(pstmt != null) pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return success;
	}

	
	
	public ArrayList<MemberDto> select(int start, int len) {
		ArrayList<MemberDto> list = new ArrayList<MemberDto>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/kpc", "kpc12", "kpc1212");

			StringBuilder sql = new StringBuilder();
			sql.append("SELECT num, NAME, addr ");
			sql.append("FROM member ");
			sql.append("ORDER BY num desc ");
			sql.append("LIMIT ?, ? ");

			pstmt = con.prepareStatement(sql.toString());

			int index = 1;
			pstmt.setInt(index++, start);
			pstmt.setInt(index, len);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				index = 1;
				int num = rs.getInt(index++); 
				String name = rs.getString(index++);
				String addr = rs.getString(index);
				list.add(new MemberDto(num, name, addr));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) con.close();
				if (pstmt != null) pstmt.close();
				if (rs != null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
}
