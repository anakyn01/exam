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

	//후보조회
	public ArrayList<DTO> getMemberList(){
	 ArrayList<DTO> dtos = new ArrayList<>();
	 String query="select m.m_no, m.m_name, p.p_name, decode(m.p_school,'1','고졸','2','학사',decode(m.p_school,'3','석사','박사'))as p_school,\r\n"
	 		+ " m.m_jumin, m.m_city, p.p_tel1, p.p_tel2, p.p_tel3\r\n"
	 		+ "from tbl_member_202005 m, tbl_party_202005 p\r\n"
	 		+ "where m.p_code=p.p_code\r\n"
	 		+ "order by m.m_no asc";
	 try {
		 con = DBConnection.getConnection();
		 ps = con.prepareStatement(query);
		 rs = ps.executeQuery();
		 while(rs.next()) {
			 String m_no = rs.getString("m_no");
			 String m_name = rs.getString("m_name");
			 String p_name = rs.getString("p_name");
			 String p_school = rs.getString("p_school");
			 String m_jumin = rs.getString("m_jumin");
			 String m_city = rs.getString("m_city");
			 String p_tel1 = rs.getString("p_tel1");
			 String p_tel2= rs.getString("p_tel2");
			 String p_tel3= rs.getString("p_tel3");
			 
			 DTO dto = new DTO();
			 dto.setM_no(m_no);
			 dto.setM_name(m_name);
			 dto.setP_name(p_name);
			 dto.setP_school(p_school);
			 dto.setM_jumin(m_jumin);
			 dto.setM_city(m_city);
			 dto.setP_tel1(p_tel1);
			 dto.setP_tel2(p_tel2);
			 dto.setP_tel3(p_tel3);
			 
			 dtos.add(dto);			 
		 }
	 }catch(Exception e) {
		 e.printStackTrace();
	 }finally {
		 DBConnection.closeDB(con, ps, rs);
	 }
	 return dtos;
	}
	
	//투표하기
	public int doVote(String v_jumin, String v_name, String m_no, String v_time, String v_area, String v_confirm){
		 int re = 0;
		 String query="insert into tbl_vote_202005"
		 		+ " values('"+v_jumin+"','"+v_name+"','"+m_no+"','"+v_time+"', '"+v_area+"','"+v_confirm+"')";
		 try {
			 con = DBConnection.getConnection();
			 ps = con.prepareStatement(query);
			 rs = ps.executeQuery();
		 }catch(Exception e) {
			 e.printStackTrace();
		 }finally {
			 DBConnection.closeDB(con, ps, rs);
		 }
		 return re;
		}
	
	//투표검수조회
	public ArrayList<DTO> getVoteList(){
		 ArrayList<DTO> dtos = new ArrayList<>();
		 String query="select v.v_name, a.v_birth, 2022-to_number(substr(a.v_birth,1,4))v_age, decode(a.gender,'1','남','여')v_gender, v.m_no,\r\n" + 
					"       concat(concat(substr(v.v_time,1,2),':'),substr(v.v_time,3,4))v_time, decode(v.v_confirm,'Y','확인','미확인')v_confirm\r\n" + 
					" from tbl_vote_202005 v,\r\n" + 
					"    (select v_jumin, to_char(to_date(substr(v_jumin,1,6)),'yyyy\"년\"MM\"월\"dd\"일생\"')v_birth, substr(v_jumin,7,1)gender from tbl_vote_202005) a\r\n" + 
					" where v.v_jumin = a.v_jumin and v_area='제1투표장'";
/*
v.v_name : 유권자의 이름
a.v_birth : 생년월일을 형식으로 표현 'yyyy\"년\"MM\"월\"dd\"일생\"'
2022-to_number(substr(a.v_birth,1,4))v_age => 2022년 유권자 연령은 2022년에서 생년월일(년도)의 처음 4글자를 뺀값
decode(a.gender, '1','남', '여')v_gender => '1','남성 그외 여성
v.m_no => 투표의 행위를 식별하는 식별자
concat(concat(substr(v.v_time,1,2),':'),substr(v.v_time,3,4))v_time
하위 문자열 연산을 사용하여 형식화된 투표시간 HH:MM
decode(v.v_confirm, 'Y','확인','미확인')v_confirm => 투표의 확인상태는 '확인', '미확인'
*/
		 try {
			 con = DBConnection.getConnection();
			 ps = con.prepareStatement(query);
			 rs = ps.executeQuery();
			 while(rs.next()) {
				 String v_name = rs.getString("v_name");
				 String v_birth = rs.getString("v_birth");
				 String v_age = rs.getString("v_age");
				 String v_gender = rs.getString("v_gender");
				 String m_no = rs.getString("m_no");
				 String v_time = rs.getString("v_time");
				 String v_confirm = rs.getString("v_confirm");

				 
				 DTO dto = new DTO();
				 dto.setV_name(v_name);
				 dto.setV_birth(v_birth);
				 dto.setV_age(v_age);
				 dto.setV_gender(v_gender);
				 dto.setM_no(m_no);
				 dto.setV_time(v_time);
				 dto.setV_confirm(v_confirm);				 
				 dtos.add(dto);			
				 
			 }
		 }catch(Exception e) {
			 e.printStackTrace();
		 }finally {
			 DBConnection.closeDB(con, ps, rs);
		 }
		 return dtos;
		}
	
	//후보자등수
	public ArrayList<DTO> getRanking(){
		 ArrayList<DTO> dtos = new ArrayList<>();
			String query="select m_no, m_name, count, round(count/aa*100,2)as per from(\r\n" + 
					" select m.m_no, m.m_name, count(m_name)as count, a.aa\r\n" + 
					" from tbl_member_202005 m, tbl_vote_202005 v, (select count(*)as aa from tbl_vote_202005 where v_confirm='Y')a\r\n" + 
					" where m.m_no=v.m_no and v_confirm = 'Y'\r\n" + 
					" group by m.m_no, m.m_name, a.aa\r\n" + 
					" order by count desc)";
		 try {
			 con = DBConnection.getConnection();
			 ps = con.prepareStatement(query);
			 rs = ps.executeQuery();
			 while(rs.next()) {
				 String m_no = rs.getString("m_no");
				 String m_name = rs.getString("m_name");
				 String count = rs.getString("count");
				 String per = rs.getString("per");


				 
				 DTO dto = new DTO();
				 dto.setM_no(m_no);
				 dto.setM_name(m_name);
				 dto.setCount(count);
				 dto.setPer(per);			 
				 dtos.add(dto);		
			 }
		 }catch(Exception e) {
			 e.printStackTrace();
		 }finally {
			 DBConnection.closeDB(con, ps, rs);
		 }
		 return dtos;
		}
	
}
