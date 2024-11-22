package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MemberDAO {

	private Connection conn;
	private ResultSet rs;
	
	//생성자
	public MemberDAO() {
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
		String sql = "select sysdate from MEMBER_TBL_02";
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
	
	//글의 순번
	public int getNext() {
		int num = 0;
		String sql = "select MEMBER_SEQ.NEXTVAL from dual";
		//NEXTVAL => 시퀀스 값 증가 현재 시퀀스 값 => CURRVAL
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
	public ArrayList<Member> getList(){
		String sql = "select * from MEMBER_TBL_02 order by custno asc";
		ArrayList<Member> list = new ArrayList<Member>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {//들어가는 항목에 순번으로 표기
				Member member = new Member();
				member.setCustno(rs.getInt(1));
				member.setCustname(rs.getString(2));
				member.setPhone(rs.getString(3));
				member.setAddress(rs.getString(4));
				member.setJoindate(rs.getDate(5));
				member.setGrade(rs.getString(6));
				member.setCity(rs.getString(7));
				list.add(member);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int write() {
		String sql = "";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	
	
	
	
}
