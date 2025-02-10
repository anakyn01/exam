package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.DBConnection;
import dto.DTO;
import dto.DTO2;

public class DAO {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	//사원별 예약 집계
	public ArrayList<DTO2> getContractTotal(){
		ArrayList<DTO2> dtos = new ArrayList<>();
String query="select"
+ ""
+ ""
+ ""
+ ""
+ ""
+ ""
+ ""
+ ""
+ "";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
	String empno = rs.getNString("empno");
	//National 다국어 유니코드 문자열을 처리할때 사용
	String empname = rs.getNString("empname");
	String deptname = rs.getNString("deptname");
	String count = rs.getNString("count");
//
DTO2 dto = new DTO2(empno, empname, deptname, count );
dtos.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
System.out.println("getContractTotal() : " + query);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dtos;
	}
	
	//예약저장
public int contractSave(String resvno, String empno, String resvdate, String seatno) {
	int result = 0;
	String query = "insert into ";
	try {
		con = DBConnection.getConnection();
		ps = con.prepareStatement(query);
		result = ps.executeUpdate();
	}catch(Exception e) {
		System.out.println("getContractList() : " + query);
		e.printStackTrace();
	}finally {
		DBConnection.closeDB(con, ps, rs);
	}
	return result;
}
	//예약목록조회
	public ArrayList<DTO> getContractList(String empno){
		ArrayList<DTO> dtos = new ArrayList<>();
String query="select "
+ ""
+ ""
+ ""
+ ""
+ ""
+ ""
+ ""
+ ""
+ ""
+ "";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
	String empname = rs.getNString("empname");
	String resvdate = rs.getNString("resvdate");
	String seatno = rs.getNString("seatno");
	String office = rs.getNString("office");
	String callno = rs.getNString("callno");
//
DTO dto = new DTO(empno, empname,resvdate,seatno,office,callno);
dtos.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
System.out.println("getContractList() : " + query);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dtos;
	}

//예약번호 중복검사
public int checkresvno(String resvno) {
	int result = 0;
	String query = "select ";
	try {
		con = DBConnection.getConnection();
		ps = con.prepareStatement(query);
		result = ps.executeUpdate();
	}catch(Exception e) {
		System.out.println("getContractList() : " + query);
		e.printStackTrace();
	}finally {
		DBConnection.closeDB(con, ps, rs);
	}
	return result;
}

}
