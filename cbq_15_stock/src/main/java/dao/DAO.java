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
	
	//주식 종목 조회
	public ArrayList<DTO> getStockList(){
		ArrayList<DTO> dtos = new ArrayList<DTO>();
		String query="";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
String s_code= rs.getString("s_code");
String s_name= rs.getString("s_name");
String s_market= rs.getString("s_market");
String s_category= rs.getString("s_category");
String s_listed_date= rs.getString("s_listed_date");
				
DTO dto = new DTO();
dto.setS_code(s_code);
dto.setS_name(s_name);
dto.setS_market(s_market);
dto.setS_category(s_category);
dto.setS_listed_date(s_listed_date);
				
				dtos.add(dto);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(query);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dtos;
	}
	
	//매수등록
public int saveStockBuy(String buy_date, String s_code, String buy_number, String buy_price, String dept_code) {
	int result = 0;
	String query="";
	try {
		con = DBConnection.getConnection();
		ps = con.prepareStatement(query);
		result = ps.executeUpdate();
	}catch(Exception e) {
		e.printStackTrace();
		System.out.println(query);
	}finally {
		DBConnection.closeDB(con, ps, rs);
	}
	return result;
	}

//주식 매수내역 조회
public ArrayList<DTO> getBuyList(){
	ArrayList<DTO> dtos = new ArrayList<DTO>();
	String query="";
	try {
		con = DBConnection.getConnection();
		ps = con.prepareStatement(query);
		rs = ps.executeQuery();
		while(rs.next()) {
String buy_date= rs.getString("buy_date");
String s_code= rs.getString("s_code");
String s_name= rs.getString("s_name");
String buy_number= rs.getString("buy_number");
String buy_price= rs.getString("buy_price");
String dept_name= rs.getString("dept_name");

DTO dto = new DTO();
dto.setBuy_date(buy_date);
dto.setS_code(s_code);
dto.setS_name(s_name);
dto.setBuy_number(buy_number);
dto.setBuy_price(buy_price);
dto.setDept_name(dept_name);
dtos.add(dto);
		}
		
	}catch(Exception e) {
		e.printStackTrace();
		System.out.println(query);
	}finally {
		DBConnection.closeDB(con, ps, rs);
	}
	return dtos;
}

//부서별 주식 매수 통계
public ArrayList<DTO> getDeptTotal(){
	ArrayList<DTO> dtos = new ArrayList<DTO>();
	String query="";
	try {
		con = DBConnection.getConnection();
		ps = con.prepareStatement(query);
		rs = ps.executeQuery();
		while(rs.next()) {
String dept_code= rs.getString("dept_code");
String dept_name= rs.getString("dept_name");
String buy_number= rs.getString("buy_number");
String total= rs.getString("total");
			
DTO dto = new DTO();
dto.setDept_code(dept_code);
dto.setDept_name(dept_name);
dto.setBuy_number(buy_number);
dto.setS_total(total);

dtos.add(dto);
		}
		
	}catch(Exception e) {
		e.printStackTrace();
		System.out.println(query);
	}finally {
		DBConnection.closeDB(con, ps, rs);
	}
	return dtos;
}



}
	
	
	
	
	
	
	
	

