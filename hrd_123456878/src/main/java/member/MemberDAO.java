package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MemberDAO {

	private Connection conn;
	private ResultSet rs;
	
	//�깮�꽦�옄
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
	
	//�떆媛�
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
	
	//湲��쓽 �닚踰�
	public int getNext() {
		int num = 0;
		String sql = "select MEMBER_SEQ.NEXTVAL from dual";
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
	public ArrayList<Member> getList(){
		String sql = "select * from MEMBER_TBL_02 order by custno asc";
		ArrayList<Member> list = new ArrayList<Member>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {//�뱾�뼱媛��뒗 �빆紐⑹뿉 �닚踰덉쑝濡� �몴湲�
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
	
	public int write(String custname, String phone, String address, String grade, String city ) {
		String sql = "insert into member_tbl_02 values(?,?,?,?,to_char(to_date(?,'YYYY-MM-DD hh24:mi:ss'),'YYYY-MM-DD'),?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, getNext());
			pstmt.setString(2, custname);
			pstmt.setString(3, phone);
			pstmt.setString(4, address);
			pstmt.setString(5, getDate());
			pstmt.setString(6, grade);
			pstmt.setString(7, city);
			return pstmt.executeUpdate();//잊어먹지 말자 리턴 
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public Member getMember(int custno) {
		String sql="select * from MEMBER_TBL_02 where custno = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, custno);//순번으로 글선택
			rs=pstmt.executeQuery();//잊어먹지 말자 커리
			if(rs.next()) {
				Member member = new Member();
				member.setCustno(rs.getInt(1));
				member.setCustname(rs.getString(2));
				member.setPhone(rs.getString(3));
				member.setAddress(rs.getString(4));
				member.setJoindate(rs.getDate(5));
				member.setGrade(rs.getString(6));
				member.setCity(rs.getString(7));
				return member;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//게시글 수정 메소드
	public int update(String custname, String phone, String address, int custno) {
		String sql = "update MEMBER_TBL_02 set custname=?, phone=?, address=? where custno = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, custname);
			pstmt.setString(2, phone);
			pstmt.setString(3, address);
			pstmt.setInt(4, custno);
			return pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	//게시글 삭제 메소드
	public int delete(int custno) {
		String sql = "delete from MEMBER_TBL_02 where custno = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, custno);
			return pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
