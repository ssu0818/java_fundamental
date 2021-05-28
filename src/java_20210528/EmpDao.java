package java_20210528;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpDao {
	private static EmpDao kim;
	
	private EmpDao() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static EmpDao getInstance() {
		if(kim == null) {
			kim = new EmpDao();
		}
		return kim;
	}
	
	public boolean insert(EmpDto dto) {
		boolean success = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/kpc","kpc12","kpc1212");
			
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO emp(empno, ename, job, mgr, hiredate, sal, comm, deptno)  ");
//			sql.append("VALUES (9003, 'KIM', 'MANAGER', 7839, CURDATE(), 50000, 40000, 30) ");
			sql.append("VALUES (?, ?, ?, ?, curdate(), ?, ?, ?) ");
			
			pstmt = con.prepareStatement(sql.toString());
			
			int index = 1;
			pstmt.setInt(index++, dto.getNo());
			pstmt.setString(index++, dto.getName());
			pstmt.setString(index++, dto.getJob());
			pstmt.setInt(index++, dto.getMgr());
			pstmt.setDouble(index++, dto.getSal());
			pstmt.setDouble(index++, dto.getComm());
			pstmt.setInt(index++, dto.getDeptNo());
			
			pstmt.executeUpdate();
			success = true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(con!=null) con.close();
				if(pstmt!=null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return success;
	}
	
	public boolean update(EmpDto dto) {
		boolean success = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/kpc","kpc12","kpc1212");
			
			StringBuilder sql = new StringBuilder();
			sql.append("update ");
			sql.append(" ");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success;
	}
	
	public boolean delete(int no) {
		boolean success = false;
		
		return success;
	}
	
	public ArrayList<EmpDto> select(int start, int len){
		ArrayList<EmpDto> list = new ArrayList<EmpDto>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost/kpc","kpc12","kpc1212");
			
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT empno, ename, job, mgr, date_format(hiredate, '%Y/%m/%d') hiredate, sal, nvl(comm,0) nvl, deptno ");
			sql.append("FROM emp ");
			sql.append("ORDER BY hiredate DESC ");
			sql.append("LIMIT ?, ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			
			int index = 1;
			pstmt.setInt(index++, start);
			pstmt.setInt(index++, len);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				index = 1;
				int no = rs.getInt(index++);
				String name = rs.getString(index++);
				String job = rs.getString(index++);
				int mgr = rs.getInt(index++);
				String hiredate = rs.getString(index++);
				double sal = rs.getDouble(index++);
				double comm = rs.getDouble(index++);
				int deptNo = rs.getInt(index++);
				
				list.add(new EmpDto(no, name, job, mgr, hiredate, sal, comm, deptNo));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				try {
					if(con!=null) con.close();
					if(pstmt!=null) pstmt.close();
					if(rs!=null) rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return list;
	}
	
}
