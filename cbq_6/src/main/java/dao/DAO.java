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
	 String query="";
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
			 String p_tel1 = rs.getString("m_tel1");
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
	public int doVote(){
		 int re = 0;
		 String query="";
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
		 String query="";
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
		 String query="";
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
