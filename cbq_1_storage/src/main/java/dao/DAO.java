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
	
	//제품조회
	public ArrayList<DTO> getProductList(){
ArrayList<DTO> dtos = new ArrayList<DTO>();
String query="select p_code, p_name, p_size, to_char(p_incost, '999,999') as p_incost, to_char(p_outcost, '999,999')as p_outcost from t_product";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
		while(rs.next()) {
			String p_code = rs.getString("p_code");
			String p_name = rs.getString ("p_name");
			String p_size= rs.getString ("p_size");
			String p_incost= rs.getString ("p_incost");
			String p_outcost = rs.getString ("p_outcost");
			
			DTO dto = new DTO(p_code,p_name,p_size,p_incost,p_outcost);
			dtos.add(dto);
		}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(" 오류 " + query);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dtos;
	}
	//거래처목록 조회
	public ArrayList<DTO> getCompanyList(){
		ArrayList<DTO> dtos = new ArrayList<DTO>();
		String query="select c_code, c_name from t_company";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
		while(rs.next()) {
			String c_code = rs.getString("c_code");
			String c_name = rs.getString ("c_name");
			DTO dto = new DTO(c_code, c_name);
			dtos.add(dto);
		}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("getCompany 오류 " + query);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dtos;
	}
	
//입출고 번호 자동생성
	public String getAutoCode() {
		String num = "";
		String query = "select nvl(max(t_no), '20200000') as t_no from t_inout";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			if(rs.next()) {
				int max_no = rs.getInt("t_no");
				num = Integer.toString(max_no + 1);//언박싱
			}			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("getAutoCode 오류 " + query);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return num;
	}
	//입출고 저장
public int productSave(String t_no, String p_code, String t_type, String t_cnt, String t_date, String c_code) {
int result = 0;
String query = "insert into t_inout values ('"+t_no+"','"+p_code+"','"+t_type+"','"+t_cnt+"','"+t_date+"','"+c_code+"')";
try {
	con = DBConnection.getConnection();
	ps = con.prepareStatement(query);
	rs = ps.executeQuery();		
}catch(Exception e) {
	e.printStackTrace();
	System.out.println("getAutoCode 오류 " + query);
	}finally {
		DBConnection.closeDB(con, ps, rs);
	}
	return result;
}
	
	//입출고 내역조회
public ArrayList<DTO> getInoutList(){
		ArrayList<DTO> dtos = new ArrayList<DTO>();
String query="select t.t_no, t.p_code, p.p_name, decode(t.t_type, 'I','입고','출고') as t_type, t.t_cnt, c.c_name,\r\n"
+ " to_char(t.t_date, 'yyyy-MM-dd') as t_date\r\n"
+ " from t_product p, t_inout t, t_company c\r\n"
+ " where p.p_code = t.p_code and c.c_code = t.c_code\r\n"
+ " order by t_no asc";//t_no에 오름차순으로 정렬
//"where p.p_code = t.p_code 제품코드 일치 and c.c_code = t.c_code" 회사코드일치
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
		while(rs.next()) {
			String t_no = rs.getString ("t_no");
			String p_code = rs.getString ("p_code");
			String p_name = rs.getString ("p_name");
			String t_type = rs.getString ("t_type");
			String t_cnt = rs.getString ("t_cnt");
			String c_name = rs.getString ("c_name");
			String t_date = rs.getString ("t_date");
			
			DTO dto = new DTO(t_no,p_code,p_name,t_type,t_cnt,c_name,t_date);
			dtos.add(dto);
		}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("getInoutList 오류 " + query);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dtos;
	}
	//출고매출이익 조회
	public ArrayList<DTO> getSalesList(){
		ArrayList<DTO> dtos = new ArrayList<DTO>();
String query="select p.p_code, a.p_name, p.t_cnt, to_char(to_number(p.t_cnt*(a.p_outcost - a.p_incost)), '999,999') as result\r\n"
+ "from (select p_code, sum(t_cnt) as t_cnt from t_inout where t_type = 'O' group by p_code) p,\r\n"
+ "t_product a\r\n"
+ "where a.p_code = p.p_code\r\n"
+ "order by p.p_code asc";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
		while(rs.next()) {
			String p_code= rs.getString ("p_code");
			String p_name= rs.getString  ("p_name");
			String t_cnt= rs.getString  ("t_cnt");
			String result= rs.getString  ("result");

			DTO dto = new DTO(p_code, p_name, t_cnt, result);
			dtos.add(dto);
		}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("getSalesList 오류 " + query);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dtos;
	}
	
	
	
	
	
	
	
	
}
