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
	
	//매출등록
public int saveOilSale(String saleno, String oildate, String oiltype, String amount, String paytype, String creditcart, String custno, String oilcost) {
		int result = 0;
		String query="";
		try {
			con = DBConnection.getConnection();
			ps=con.prepareStatement(query);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	//전체 매출조회
public ArrayList<DTO> getSalesList(){
		ArrayList<DTO> dtos = new ArrayList<DTO>();
		String query ="";
		try {
con = DBConnection.getConnection();
ps=con.prepareStatement(query);
rs = ps.executeQuery();
while(rs.next()) {
	String saleno = rs.getString("saleno");
	String oildate = rs.getString("oildate");
	String oilname = rs.getString("oilname");
	String amount = rs.getString("amount");
	String paytype = rs.getString("paytype");
	String custname = rs.getString("custname");
	String custno = rs.getString("custno");
	String custtel1 = rs.getString("custtel1");
	String custtel2 = rs.getString("custtel2");
	String custtel3 = rs.getString("custtel3");
	String creditcart = rs.getString("creditcart");
	String oilcost = rs.getString("oilcost");
	
	DTO dto = new DTO();
	
	dto.setSaleno(saleno);
	dto.setOildate(oildate);
	dto.setOilname(oilname);
	dto.setAmount(amount);
	dto.setPaytype(paytype);
	dto.setCustname(custname);
	dto.setCustno(custno);
	dto.setCusttel1(custtel1);
	dto.setCusttel2(custtel2);
	dto.setCusttel3(custtel3);
	dto.setCreditcart(creditcart);
	dto.setOilcost(oilcost);
	
	dtos.add(dto);				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dtos;
	}
	//매출 총액
	public String getTotalCost() {
		String total = "";
		String query="";
		try {
			con = DBConnection.getConnection();
			ps=con.prepareStatement(query);
			rs = ps.executeQuery();
			if(rs.next()) {
				total = rs.getString("total");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return total;
	}
	
	//일 매출
	public ArrayList<DTO> getDateSales(){
		ArrayList<DTO> dtos = new ArrayList<DTO>();
		String query ="";
		try {
			con = DBConnection.getConnection();
			ps=con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
String oildate = rs.getString("oildate");	
String oilname = rs.getString("oilname");
String count = rs.getString("count");
String oilcost = rs.getString("oilcost");

DTO dto = new DTO();
dto.setOildate(oildate);
dto.setOilname(oilname);
dto.setCount(count);
dto.setOilcost(oilcost);
dtos.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dtos;
	}
	
	
	
	
}
