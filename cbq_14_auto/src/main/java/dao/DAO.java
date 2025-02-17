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
	
	//사원별 예약 집계 인코딩[컴퓨터가 이해할수 있게{바이너리 데이터} A 01000001] 데이터 압축, 다른형식으로 변환 
	//디코딩은 인코딩에 역과정 [사람이 알아볼수 있게 해줌]
	//류 메시지는 ORA-00904: "E"."EMPNAME": invalid identifier일반적으로 Oracle SQL에서 쿼리의 열 이름이 잘못 철자되었거나, 존재하지 않거나, 올바르게 참조되지 않았을 때 발생합니다.
	public ArrayList<DTO2> getContractTotal(){
		ArrayList<DTO2> dtos = new ArrayList<DTO2>();
String query="select e.empno, e.empname,\r\n"
+ "decode(e.deptcode, '10', '영업팀',\r\n"
+ " '20', '총무팀', \r\n"
+ " '30', '구매팀') as deptname, \r\n"
+ " count(*) as count \r\n"
+ " from EXAM_AUTO_EMP e,\r\n"
+ " EXAM_AUTO_CONTRACT c\r\n"
+ "where e.empno = c.empno\r\n"
+ "GROUP BY e.empno, e.empname, e.deptcode\r\n"
+ "order by empno";
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
	
	//예약목록조회
		public ArrayList<DTO> getContractList(String empno){
			ArrayList<DTO> dtos = new ArrayList<>();
String query="select c.empno, e.empname, \r\n"
+ " to_char(to_date(c.resvdate), 'yyyy\"년\"MM\"월\"dd\"일\"') resvdate, \r\n"
+ " c.seatno, \r\n"
+ " s.office, s.callno \r\n"
+ "from EXAM_AUTO_CONTRACT c,\r\n"
+ " EXAM_AUTO_EMP e,\r\n"
+ " EXAM_AUTO_SEAT s\r\n"
+ "where c.empno = e.empno\r\n"
+ "and c.seatno = s.seatno\r\n"
+ "and c.empno = '"+empno+"'\r\n"
+ "order by c.resvdate desc";
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
	
	//예약저장
public int contractSave(String resvno, String empno, String resvdate, String seatno) {
	int result = 0;
	String query = "insert into EXAM_AUTO_CONTRACT\r\n"
			+ "values\r\n"
			+ "('"+resvno+"','"+empno+"','"+resvdate+"','"+seatno+"')";
	try {
		con = DBConnection.getConnection();
		ps = con.prepareStatement(query);
		result = ps.executeUpdate();
	}catch(Exception e) {
		System.out.println("getContractListSave() : " + query);
		e.printStackTrace();
	}finally {
		DBConnection.closeDB(con, ps, rs);
	}
	return result;
}
	

//예약번호 중복검사
public int checkResvno(String resvno) {
	int count = 0;
	String query = "select count(*) count\r\n"
+ "EXAM_AUTO_CONTRACT\r\n"
+ "where resvno ='"+resvno+"'";
	try {
		con = DBConnection.getConnection();
		ps = con.prepareStatement(query);
		rs = ps.executeQuery();
	}catch(Exception e) {
		System.out.println("getContractList() : " + query);
		e.printStackTrace();
	}finally {
		DBConnection.closeDB(con, ps, rs);
	}
	return count;
}

}
