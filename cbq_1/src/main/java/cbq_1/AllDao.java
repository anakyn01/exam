package cbq_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class AllDao {

	private Connection conn;
	private ResultSet rs;
	
	public AllDao() {
		try {
			String dbURL = "jdbc:oracle:thin:@localhost:1521/xe";
			String dbID = "system";
			String dbPassword ="1234";
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getDate() {
		String sql = "select sysdate from tbl_inout";
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
	
	public int getNext() {
		int num = 0;
		String sql = "select seq_p_nums.NEXTVAL from dual";
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
	
	public ArrayList<Product> getList(){
		String sql = "select * from tbl_product order by p_nums asc";
		ArrayList<Product> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setP_nums(rs.getInt(1));
				product.setP_code(rs.getString(2));
				product.setP_name(rs.getString(3));
				product.setP_size(rs.getInt(4));
				product.setP_incost(rs.getInt(5));
				product.setP_outcost(rs.getInt(6));
				list.add(product);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<InOut> getList2(){
		String sql = "select * from tbl_inout order by t_no asc";
		ArrayList<InOut> list2 = new ArrayList<>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				InOut inOut = new InOut();
				inOut.setT_no(rs.getString(1));
				inOut.setP_code(rs.getString(2));
				inOut.setT_type(rs.getString(3));
				inOut.setT_cnt(rs.getString(4));
				inOut.setT_date(rs.getString(5));
				inOut.setC_code(rs.getString(6));
				list2.add(inOut);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list2;
	}
	
	//입출고
	public int write(String t_no, String p_code, String t_type, String t_cnt, String t_date, String c_code) {
		String sql = "insert into tbl_inout values(?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, t_no );
			pstmt.setString(2, p_code );
			pstmt.setString(3, t_type );
			pstmt.setString(4, t_cnt );
			pstmt.setString(5, t_date );
			pstmt.setString(6, c_code);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	
	
	
	
	
	
}

