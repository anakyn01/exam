package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.DBConnection;
import dto.DTO;

public class DAO {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	//참가번호 자동생성
	public String getAutoNo() {
		String autoNo = "";
String query="select to_char(max(entry_no+1),'FM0000')no from TBL_ENTRY_202106";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			if(rs.next()) {
autoNo = rs.getString("no");			
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(" "+query );
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return autoNo;
	}
	//참가자 등록
public int saveEntry(String entry_no, String entry_name, String entry_jumin, String entry_type, String entry_area) {
		int result = 0;
String query="insert into TBL_ENTRY_202106 values ('"+entry_no+"','"+entry_name+"','"+entry_jumin+"','"+entry_type+"','"+entry_area+"')";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(" "+query );
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	//경연점수 등록
public int saveScore(String entry_no, int score1,int score2,int score3,int score4,int score5,int max, int min, int total, double ave ) {
int result = 0;
String query="insert into TBL_RECORD_202106 values ('"+entry_no+"',"+score1+","+score2+","+score3+","+score4+","+score5+","+max+","+min+","+total+","+ave+")";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(" "+query );
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	//경연결과 조회
	public DTO getResultList(String e_no) {
        DTO dto = new DTO();
String query="select e.entry_no, concat(e.entry_name,decode(b.gender,'1','(남)','(여)'))entry_name,\r\n" + 
"        to_char(to_date(substr(e.entry_jumin,1,6)),'yy\"년\"MM\"월\"dd\"일\"')entry_jumin,\r\n" + 
"        decode(e.entry_type,'1','기악','2','민요','3','무용','판소리')entry_type,\r\n" + 
"        e.entry_area, r.score1,r.score2,r.score3,r.score4,r.score5,r.s_tot,r.s_ave\r\n" + 
" from TBL_ENTRY_202106 e, TBL_RECORD_202106 r, (select entry_no, substr(entry_jumin,7,1)gender from TBL_RECORD_202106)b\r\n" + 
" where e.entry_no = r.entry_no and e.entry_no = b.entry_no\r\n" + 
" and e.entry_no='"+e_no+"'";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			if(rs.next()) {
String entry_no = rs.getString("entry_no");
String entry_name = rs.getString("entry_name");	
String entry_jumin = rs.getString("entry_jumin");	
String entry_type = rs.getString("entry_type");	
String entry_area = rs.getString("entry_area");	
int score1 = rs.getInt("score1");
int score2 = rs.getInt("score2");
int score3 = rs.getInt("score3");
int score4 = rs.getInt("score4");
int score5 = rs.getInt("score5");
int s_tot = rs.getInt("s_tot");
double s_ave = rs.getDouble("s_ave");

dto.setEntry_no(entry_no);
dto.setEntry_name(entry_name);
dto.setEntry_jumin(entry_jumin);
dto.setEntry_type(entry_type);
dto.setEntry_area(entry_area);
dto.setScore1(score1);
dto.setScore2(score2);
dto.setScore3(score3);
dto.setScore4(score4);
dto.setScore5(score5);
dto.setS_tot(s_tot);
dto.setS_ave(s_ave);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(" "+query );
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dto;
	}
	//최종등수 조회
	public ArrayList<DTO> getRanking() {
		ArrayList<DTO> dtos = new ArrayList<DTO>();
String query="select tbl.* , rownum from(\r\n" + 
" select e.entry_no, concat(e.entry_name,decode(b.gender,'1','(남)','(여)'))entry_name,\r\n" + 
"        to_char(to_date(substr(e.entry_jumin,1,6)),'yy\"년\"MM\"월\"dd\"일\"')entry_jumin,\r\n" + 
"        decode(e.entry_type,'1','기악','2','민요','3','무용','판소리')entry_type,\r\n" + 
"        e.entry_area,r.s_tot,r.s_ave\r\n" + 
" from TBL_ENTRY_202106 e, TBL_RECORD_202106 r, (select entry_no, substr(entry_jumin,7,1)gender from TBL_ENTRY_202106)b\r\n" + 
" where e.entry_no = r.entry_no and e.entry_no = b.entry_no\r\n" + 
" order by s_tot desc, entry_no desc)tbl";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			if(rs.next()) {
				String entry_no = rs.getString("entry_no");
				String entry_name = rs.getString("entry_name");	
				String entry_jumin = rs.getString("entry_jumin");	
				String entry_type = rs.getString("entry_type");	
				String entry_area = rs.getString("entry_area");	
				int s_tot = rs.getInt("s_tot");
				double s_ave = rs.getInt("s_ave");
				String rank = rs.getString("rownum");
				
				DTO dto = new DTO();
				dto.setEntry_no(entry_no);
				dto.setEntry_name(entry_name);
				dto.setEntry_jumin(entry_jumin);
				dto.setEntry_type(entry_type);
				dto.setEntry_area(entry_area);
				dto.setS_tot(s_tot);
				dto.setS_ave(s_ave);
				dto.setRank(rank);				
				dtos.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(" "+query );
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dtos;
	}
	

}
