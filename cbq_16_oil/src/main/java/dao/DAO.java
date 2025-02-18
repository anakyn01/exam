package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.DBConnection;
import dto.DTO;

/*
TBL_CUSTINFO_202010,TBL_OILINFO_202010,TBL_SALEINFO_202010
*/
public class DAO {

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	//매출등록
public int saveOilSale(String saleno, String oildate, String oiltype, String amount, String paytype, String creditcart, String custno, String oilcost) {
		int result = 0;
String query="insert into TBL_SALEINFO_202010\r\n"
+ "(saleno,oildate,oiltype,amount,paytype,creditcart,custno,oilcost)\r\n"
+ "values('"+saleno+"','"+oildate+"','"+oiltype+"','"+amount+"','"+paytype+"','"+creditcart+"','"+custno+"','"+oilcost+"')";
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
String query ="select s.saleno, to_char(to_date(s.oildate), 'yyyy\"년\"MM\"월\"dd\"일\"')oildate, o.oilname, s.amount,\r\n "
+ "	decode(s.paytype, '1', '현금', '카드')paytype, nvl(c.custname,'비회원')custname, nvl(c.custno,'비회원')custno,\r\n"
+ "	nvl(c.custtel1,'000')custtel1, nvl(c.custtel2,'0000')custtel2,  nvl(c.custtel3,'0000')custtel3,\r\n"
+ "	nvl(s.creditcart, ' ')creditcart, to_char(s.oilcost, '999,999')oilcost\r\n "
+ "from TBL_CUSTINFO_202010 c,TBL_OILINFO_202010 o,TBL_SALEINFO_202010 s\r\n"
+ "where s.oiltype=o.oiltype and s.custno=c.custno(+)\r\n"
+ "order by saleno asc";
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
String query="select to_char(sum(oilcost), '999,999') total from\r\n "
+ "(select s.saleno, to_char(to_date(s.oildate), 'yyyy\"년\"MM\"월\"dd\"일\"')oildate, o.oilname, s.amount,\r\n"
+ "	decode(s.paytype, '1', '현금', '카드')paytype, nvl(c.custname,'비회원')custname, nvl(c.custno,'비회원')custno,\r\n"
+ "	nvl(c.custtel1,'000')custtel1, nvl(c.custtel2,'0000')custtel2,  nvl(c.custtel3,'0000')custtel3,\r\n"
+ "	nvl(s.creditcart, ' ')creditcart, s.oilcost\r\n "
+ "from TBL_CUSTINFO_202010 c,TBL_OILINFO_202010 o,TBL_SALEINFO_202010 s\r\n"
+ "where s.oiltype=o.oiltype and s.custno=c.custno(+))";
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
String query ="select oildate, oilname, count(*)count, to_char(sum(oilcost),'999,999')oilcost from(\r\n"
+ "select to_char(to_date(s.oildate),'yyyy\"년\"MM\"월\"dd\"일\"')oildate, o.oiltype,o.oilname, s.oilcost\r\n"
+ "from TBL_OILINFO_202010 o,TBL_SALEINFO_202010 s\r\n"
+ "where s.oiltype=o.oiltype)\r\n"
+ "group by oildate, oilname, oiltype\r\n"
+ "order by oildate asc, oiltype desc";
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
