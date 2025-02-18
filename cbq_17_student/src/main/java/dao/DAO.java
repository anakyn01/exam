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
	
	//전체점수 조회
	public ArrayList<DTO> getAllScore(){
		ArrayList<DTO> dtos = new ArrayList<DTO>();
String query="select st.studentid s_id, st.studentname s_name, decode(substr(st.jumin,8,1),'1','남자','3','남자','여자')as gender,\r\n" + 
"       sb.subjectcode sbj_code, sb.subjectname sbj_name, sb.professorname p_name, decode(sb.classifiaction,'01','전공필수','02','전공선택','03','교양필수','교양선택')classf,\r\n" + 
"       g.mid, g.final, g.attend, g.report, g.etc, round((mid*0.3)+(final*0.3)+(report*0.2)+(attend*0.1)+(etc*0.1),2)total\r\n" + 
" from TBL_GRADE_202205 g,TBL_SUBJECT_202205 sb, TBL_STUDENT_202205 st\r\n" + 
" where st.studentid = g.studentid and sb.subjectcode = g.subjectcode\r\n" + 
" order by st.studentid asc, sb.subjectcode desc";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
while(rs.next()) {
	String s_id = rs.getString("s_id");
	String s_name = rs.getString("s_name");
	String jumin = rs.getString("gender");
	String sbj_code = rs.getString("sbj_code");
	String sbj_name = rs.getString("sbj_name");
	String p_name = rs.getString("p_name");
	String classf = rs.getString("classf");
	
	int mid = rs.getInt("mid");
	int finals = rs.getInt("final");
	int attend = rs.getInt("attend");
	int report = rs.getInt("report");
	int etc = rs.getInt("etc");
	
	double total = rs.getDouble("total");
	
	String grade = "F";
	if(total >= 90.0) grade = "A";
	else if(total >= 80.0) grade = "B";
	else if(total >= 70.0) grade = "C";
	else if(total >= 60.0) grade = "D";
	
	DTO dto = new DTO();
	dto.setS_id(s_id);
	dto.setS_name(s_name);
	dto.setJumin(jumin);
	dto.setSbj_code(sbj_code);
	dto.setSbj_name(sbj_name);
	dto.setP_name(p_name);
	dto.setClassf(classf);
	dto.setMid(mid);
	dto.setFinals(finals);
	dto.setReport(report);
	dto.setAttend(attend);
	dto.setEtc(etc);
	dto.setTotal(total);
	dto.setGrade(grade);
	
	dtos.add(dto);
	
}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(" :" + query);
		}finally{
			DBConnection.closeDB(con, ps, rs);
		}
		return dtos;
	}
	
	//점수등록
public int saveScore(String s_id,String sbj_code,int mid,int finals,int report,int attend,int etc) {
		int rst = 0;
		String query=" insert into TBL_GRADE_202205 values ('"+s_id+"','"+sbj_code+"',"+mid+","+finals+","+report+","+attend+","+etc+")";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rst = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(" :" + query);
		}finally{
			DBConnection.closeDB(con, ps, rs);
		}
		return rst;
	}
	
	//개인성적조회
	public ArrayList<DTO> getStudentScore(){
		ArrayList<DTO> dtos = new ArrayList<DTO>();
		String query="select studentid, studentname, course, count(*)count, to_char(sum(total),'FM900.0')total, to_char(round(avg(total),1),'FM00.0')avg from(\r\n" + 
				" select s.studentid, s.studentname, decode(s.course,'AD','전문학사','BD','학사','CD','석사','박사')course,\r\n" + 
				"       round((mid*0.3)+(final*0.3)+(report*0.2)+(attend*0.1)+(etc*0.1),2)total\r\n" + 
				" from TBL_GRADE_202205 g, TBL_STUDENT_202205 s\r\n" + 
				" where g.studentid = s.studentid)\r\n" + 
				" group by studentid, studentname, course\r\n" + 
				" order by studentid desc";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
while(rs.next()) {
	String s_id = rs.getString("studentid");
	String s_name = rs.getString("studentname");
	String course = rs.getString("course");
	int mid = rs.getInt("count");
	String total = rs.getString("total");
	String avg = rs.getString("avg");
	
	DTO dto = new DTO();
	dto.setS_id(s_id);
	dto.setS_name(s_name);
	dto.setCourse(course);
	dto.setMid(mid);
	dto.setStrtotal(total);
	dto.setStravg(avg);
	
	dtos.add(dto);
}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(" :" + query);
		}finally{
			DBConnection.closeDB(con, ps, rs);
		}
		return dtos;
	}
	
	
	
	
	
	

}
