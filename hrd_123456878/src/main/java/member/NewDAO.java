package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class NewDAO {
	
	private Connection conn;
	private ResultSet rs;

	public NewDAO() {
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
	

	public int getNext() {
		int num = 0;
		String sql = "select NEW_SEQ.NEXTVAL from dual";
		//NEXTVAL => �떆���뒪 媛� 利앷� �쁽�옱 �떆���뒪 媛� => CURRVAL
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
	public ArrayList<New> getListt(){
		String sql = "select * from NA_TBL order by custno asc";
		ArrayList<New> list = new ArrayList<New>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				New neww = new New();
				neww.setCustno(rs.getInt(1));
				neww.setCustname(rs.getString(2));
				neww.setVip(rs.getString(3));
				neww.setPrice(rs.getInt(4));
				list.add(neww);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	
	
	
	
	
}
