package sport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SportDAO {

	private Connection conn;
	private ResultSet rs;
	
	public SportDAO() {//컴포넌트
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
		String sql="select sysdate from E08_HYI_PLAYER";		
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
	//수동순번
	public int getNext() {
		int num = 0;
		String sql="select PLAYER_SEQ.NEXTVAL from dual";
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
	public ArrayList<Sport> getList(){
		String sql="select * from E08_HYI_PLAYER order by player_no asc";
		ArrayList<Sport> list = new ArrayList<Sport>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Sport sport = new Sport();
				sport.setPlayer_no(rs.getString(1));
				sport.setName(rs.getString(2));
				sport.setBirth(rs.getString(3));
				sport.setNation_code(rs.getString(4));
				sport.setSkill_level(rs.getString(5));
				list.add(sport);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//write
	public int write(String player_no, String name, String birth, String nation_code, String skill_level) {
		String sql="insert into E08_HYI_PLAYER values(?,?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, player_no);
			pstmt.setString(2, name);
			pstmt.setString(3, birth);
			pstmt.setString(4, nation_code);
			pstmt.setString(5, skill_level);
			return pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	//read
	public Sport getMember(String player_no) {
		String sql="select * from E08_HYI_PLAYER where player_no = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				Sport sport = new Sport();
				sport.setPlayer_no(rs.getString(1));
				sport.setName(rs.getString(2));
				sport.setBirth(rs.getString(3));
				sport.setNation_code(rs.getString(4));
				sport.setSkill_level(rs.getString(5));
				return sport;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	//update
	public int update(String player_no, String name, String birth, String nation_code, String skill_level) {
		String sql="update E08_HYI_PLAYER set player_no=?, name=?, birth=?, ation_code=?, skill_level=? ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, player_no);
			pstmt.setString(2, name);
			pstmt.setString(3, birth);
			pstmt.setString(4, nation_code);
			pstmt.setString(5, skill_level);
			return pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	//delete
	public int delete(String  player_no) {
		String sql="delete from E08_HYI_PLAYER where player_no = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, player_no);
			return pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	
	
}
