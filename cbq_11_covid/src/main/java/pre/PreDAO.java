package pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PreDAO {

	private Connection conn;
	private ResultSet rs;
	
	//생성자
	public PreDAO() {
		try {
			String dbURL = "jdbc:oracle:thin:@localhost:1521/xe";
			String dbID = "SYSTEM";
			String dbPassword = "1234";
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//시간
	public String getDate() {
		String sql = "select sysdate from TBL_CUST_201004";
		try {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			return rs.getString(1);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	//순번
	public int getNext() {
		String sql = "select PRE_SEQ.NEXTVAL from dual";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt("NEXTVAL");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	//list
	public ArrayList<Pre> getList(){
		String sql = "select * from TBL_CUST_201004 order by p_no asc";
		ArrayList<Pre> list = new ArrayList<Pre>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				Pre pre = new Pre();
				pre.setP_no(rs.getString(1));
				pre.setP_name(rs.getString(2));
				pre.setP_birth(rs.getString(3));
				pre.setP_gender(rs.getString(4));
				pre.setP_tel1(rs.getString(5));
				pre.setP_tel2(rs.getString(6));
				pre.setP_tel3(rs.getString(7));
				pre.setP_city(rs.getString(8));
				list.add(pre);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//write
	 public int write(String p_name, String p_birth, String p_gender, String p_tel1, String p_tel2, String p_tel3, String p_city) {
			String sql = "insert into TBL_CUST_201004 values()";
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, getNext());
				pstmt.setString(2, p_name);
				pstmt.setString(3, p_birth);
				pstmt.setString(4, p_gender);
				pstmt.setString(5, p_tel1);
				pstmt.setString(6, p_tel2);
				pstmt.setString(7, p_tel3);
				pstmt.setString(8, p_city);
				return pstmt.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}
			return -1;
	 }
	
	 //read
	 public Pre getMember(int p_no) {
			String sql = "select * from TBL_CUST_201004 where p_no = ?";
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, p_no);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					Pre pre = new Pre();
					pre.setP_no(rs.getString(1));
					pre.setP_name(rs.getString(2));
					pre.setP_birth(rs.getString(3));
					pre.setP_gender(rs.getString(4));
					pre.setP_tel1(rs.getString(5));
					pre.setP_tel2(rs.getString(6));
					pre.setP_tel3(rs.getString(7));
					pre.setP_city(rs.getString(8));
					return pre;
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			return null;
	 }
	 
	 //수정 
	 public int update(String p_name, String p_birth, String p_gender, String p_tel1, String p_tel2, String p_tel3, String p_city) {
			String sql = "update TBL_CUST_201004 set where p_no = ?";
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, getNext());
				pstmt.setString(2, p_name);
				pstmt.setString(3, p_birth);
				pstmt.setString(4, p_gender);
				pstmt.setString(5, p_tel1);
				pstmt.setString(6, p_tel2);
				pstmt.setString(7, p_tel3);
				pstmt.setString(8, p_city);
				return pstmt.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}
			return -1;
	 }
	
	 //삭제 메소드
	public int delete(int p_no) {
		String sql = "delete from TBL_CUST_201004 where p_no = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, p_no);
			return pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	
	
	
}
