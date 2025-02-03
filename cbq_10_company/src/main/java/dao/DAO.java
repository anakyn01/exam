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
	
	//사원목록조회
public ArrayList<DTO> getEmployeeList(){
ArrayList<DTO> dtos = new ArrayList<DTO>();
String query="select e.e_no, e.e_name, d.name e_depart, l.name e_level, w.name e_work_place, e.performance, to_char(to_date(e.e_join_date),'yyyy-MM-dd')e_join_date\r\n"
+ " from E10_황영일_employee e, E10_황영일_work w, E10_황영일_depart d, E10_황영일_level l\r\n"
+ " where e.e_depart=d.depart_code and e.e_work_place=w.work_place and e.e_level=l.level_code\r\n"
+ " order by e.e_no asc";
	try {
		con = DBConnection.getConnection();
		ps = con.prepareStatement(query);
		rs = ps.executeQuery();
		while(rs.next()) {
String e_no = rs.getString("e_no");			
String e_name = rs.getString("e_name");	
String e_depart = rs.getString("e_depart");	
String e_level = rs.getString("e_level");	
String e_work_place = rs.getString("e_work_place");	
String performance = rs.getString("performance");	
String e_join_date = rs.getString("e_join_date");	
			
DTO dto = new DTO();
dto.setE_no(e_no);
dto.setE_name(e_name);
dto.setE_depart(e_depart);
dto.setE_level(e_level);
dto.setE_work_place(e_work_place);
dto.setPerformance(performance);
dto.setE_join_date(e_join_date);

dtos.add(dto);
		}
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		DBConnection.closeDB(con, ps, rs);
	}
	return dtos;
}
	
	//사원등록
public int saveEmployee(String e_no, String e_name, String e_depart, String e_level, String e_work_place, String perfomance ){
    int r = 0;
String query="insert into E10_황영일_employee values('"+e_no+"','"+e_name+"','"+e_depart+"','"+e_level+"',"
+ "'"+e_work_place+"','"+perfomance+"',to_char(sysdate,'yyyyMMdd'))";
try {
		con = DBConnection.getConnection();
		ps = con.prepareStatement(query);
		r = ps.executeUpdate();
	}catch(Exception e) {
		e.printStackTrace();
		System.out.println(query);
	}finally {
		DBConnection.closeDB(con, ps, rs);
	}
	return r;
}
	//사원수정
public int updateEmployee(String e_no, String e_name, String e_depart, String e_level, String e_work_place, String perfomance){
    int r = 0;
String query="update E10_황영일_employee\r\n"
+" set e_name='"+e_name+"', e_depart='"+e_depart+"', e_level='"+e_level+"', e_work_place='"+e_work_place+"', perfomance='"+perfomance+"'\r\n" + 
" where e_no = '"+e_no+"'";
	try {
		con = DBConnection.getConnection();
		ps = con.prepareStatement(query);
		r = ps.executeUpdate();
	}catch(Exception e) {
		e.printStackTrace();
		System.out.println(query);
	}finally {
		DBConnection.closeDB(con, ps, rs);
	}
	return r;
}
	//급여목록조회
public ArrayList<DTO> getMoneyList(){
	ArrayList<DTO> dtos = new ArrayList<DTO>();
String query="select e_no, e_name, e_depart, e_level, e_work_place, performance,\r\n "
+ " to_char(gibon + (gibon * plus), '999,999,999')salary from(\r\n"
+ " select e.e_no, e.e_name, d.name e_depart, l.name e_level, w.name e_work_place, e.performance,\r\n"
+ " to_number(decode(e.performance, 'A','0.1', 'B','0.08', 'C','0.05','D','0'))plus, to_number(l.salary)gibon\r\n"
+ " from E10_황영일_employee e, E10_황영일_work w, E10_황영일_depart d, E10_황영일_level l\r\n"
+ " where e.e_depart=d.depart_code and e.e_work_place = w.work_place and e.e_level=l.level_code\r\n"
+ " order by l.level_code desc)";
/*
Oracle SQL의 오류는 ORA-00920: invalid relational operator
일반적으로 쿼리의 관계 연산자와 관련된 구문 문제가 있을 때 발생합니다. 
관계 연산자는 =, !=, <, >, <=, >=, BETWEEN, IN, LIKE, 등과 같은 것입니다.
*/
	try {
		con = DBConnection.getConnection();
		ps = con.prepareStatement(query);
		rs = ps.executeQuery();
		while(rs.next()) {
String e_no = rs.getString("e_no");
String e_name = rs.getString("e_name");
String e_depart = rs.getString("e_depart");
String e_level = rs.getString("e_level");
String e_work_place = rs.getString("e_work_place");
String performance = rs.getString("performance");
String salary = rs.getString("salary");
DTO dto = new DTO();
dto.setE_no(e_no);
dto.setE_name(e_name);
dto.setE_depart(e_depart);
dto.setE_level(e_level);
dto.setE_work_place(e_work_place);
dto.setPerformance(performance);
dto.setSalary(salary);
			
			dtos.add(dto);
		}
	}catch(Exception e) {
		e.printStackTrace();
		
	}finally {
		DBConnection.closeDB(con, ps, rs);
	}
	return dtos;
}
	//부서별월급
public ArrayList<DTO> getDepartMoneyList(){
	ArrayList<DTO> dtos = new ArrayList<DTO>();
    String query="select depart_code, e_depart, to_char(sum(salary),'999,999,999')salary from(\r\n" + 
" select depart_code, e_depart, gibon+(gibon*plus)salary from(\r\n" + 
" select d.name e_depart, d.depart_code,\r\n" + 
"       to_number(decode(e.performance,'A','0.1','B','0.08','C','0.05','D','0'))plus ,to_number(l.salary)gibon\r\n" + 
" from E10_황영일_employee e,E10_황영일_work w, E10_황영일_depart d, E10_황영일_level l\r\n" + 
" where e.e_depart=d.depart_code and e.e_work_place=w.work_place and e.e_level=l.level_code\r\n" + 
" order by e.e_no asc))\r\n" + 
" group by depart_code, e_depart";
	try {
		con = DBConnection.getConnection();
		ps = con.prepareStatement(query);
		rs = ps.executeQuery();
		while(rs.next()) {
String e_depart = rs.getString("e_depart");
String depart_code = rs.getString("depart_code");
String salary = rs.getString("salary");
			
DTO dto = new DTO();

dto.setE_depart(e_depart);
dto.setDepart_code(depart_code);
dto.setSalary(salary);
			
dtos.add(dto);
		}
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		DBConnection.closeDB(con, ps, rs);
	}
	return dtos;
}
	//지역별월급
public ArrayList<DTO> getWorkplaceMoneyList(){
	ArrayList<DTO> dtos = new ArrayList<DTO>();
String query="select work_place, e_work_place, to_char(sum(salary),'999,999,999')salary from(\r\n" + 
" select work_place, e_work_place, gibon+(gibon*plus)salary from(\r\n" + 
" select w.name e_work_place, w.work_place,\r\n" + 
" to_number(decode(e.performance,'A','0.1','B','0.08','C','0.05','D','0'))plus ,to_number(l.salary)gibon\r\n" + 
" from E10_황영일_employee e, E10_황영일_work w, E10_황영일_level l\r\n" + 
" where e.e_work_place=w.work_place and e.e_level=l.level_code))\r\n" + 
" group by work_place, e_work_place\r\n" + 
" order by to_number(work_place) asc";
	try {
		con = DBConnection.getConnection();
		ps = con.prepareStatement(query);
		rs = ps.executeQuery();
		while(rs.next()) {
String work_place = rs.getString("work_place");
String e_work_place = rs.getString("e_work_place");
String salary = rs.getString("salary");
DTO dto = new DTO();
dto.setWork_place(work_place);
dto.setE_work_place(e_work_place);
dto.setSalary(salary);
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
