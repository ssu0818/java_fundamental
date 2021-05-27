package java_20210527;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DeptDao {
	//singleton
	private static DeptDao single;
	private DeptDao() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static DeptDao getInstance() {
		if(single == null) {
			single = new DeptDao();
		}
		return single;
	}
	
	public boolean insert(DeptDto dto) {
		boolean success = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/kpc","kpc12","kpc1212");
			StringBuilder sql = new StringBuilder();
			sql.append("insert into dept(deptno, dname, loc) ");
			sql.append("values(?, ?, ?) ");
			
			pstmt = con.prepareStatement(sql.toString());
			
			int index = 1;
			pstmt.setInt(index++, dto.getNo());
			pstmt.setString(index++, dto.getName());
			pstmt.setString(index, dto.getLoc());
			
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
	
	public boolean update(DeptDto dto) {
		boolean success = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/kpc", "kpc12","kpc1212");
			StringBuilder sql = new StringBuilder();
			sql.append("update dept ");
			sql.append("set dname = ? ");
			sql.append("where deptno = ? ");

			pstmt = con.prepareStatement(sql.toString());
			
			int index = 1;
			pstmt.setString(index++, dto.getName());
			pstmt.setInt(index, dto.getNo());
			
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
	
	public boolean delete(int no) {
		boolean success = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/kpc","kpc12","kpc1212");
			
			StringBuilder sql = new StringBuilder();
			sql.append("delete from dept ");
			sql.append("where deptno = ?");
			
			pstmt = con.prepareStatement(sql.toString());
			
			int index = 1;
			pstmt.setInt(index, no);
			
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
	

	public ArrayList<DeptDto> select(int start, int len){
		ArrayList<DeptDto> list = new ArrayList<DeptDto>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/kpc","kpc12","kpc1212");
			
			StringBuilder sql = new StringBuilder();
			sql.append("select deptno, dname, loc ");
			sql.append("from dept ");
			sql.append("order by dname ");
			sql.append("limit ?, ?");
			
			pstmt = con.prepareStatement(sql.toString());
			
			int index = 1;
			pstmt.setInt(index++, start);
			pstmt.setInt(index, len);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				index = 1;
				//deptno, dname, loc
				list.add(new DeptDto(rs.getInt(index++), rs.getString(index++), rs.getString(index++)));
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
