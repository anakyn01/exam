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
	
	public ArrayList<DTO> sub1(){
		
		ArrayList<DTO> dtos = new ArrayList<>();
String query="select p_no, p_name, p_birth, p_gender, p_tel1, p_tel2, p_tel3, p_city from tbl_cust_201004 order by p_no asc ";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				String p_no = rs.getString("p_no");
				String p_name = rs.getString("p_name");
				String p_birth = rs.getString("p_birth");
				String p_gender = rs.getString("p_gender");
				String p_tel1 = rs.getString("p_tel1");
				String p_tel2 = rs.getString("p_tel2");
				String p_tel3 = rs.getString("p_tel3");
				String p_city = rs.getString("p_city");
				
				DTO dto = new DTO();
				dto.setP_no(p_no);
				dto.setP_name(p_name);
				dto.setP_birth(p_birth);
				dto.setP_gender(p_gender);
				dto.setP_tel1(p_tel1);
				dto.setP_tel2(p_tel2);
				dto.setP_tel3(p_tel3);
				dto.setP_city(p_city);
				
				dtos.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dtos;		
	}
	
	//쓰기
	public int sub2(String p_seno, String p_no, String i_code, String p_date){
		int result = 0;
		String query ="insert into tbl_order_201004 values(?,?,?,?)";
		try{
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
		ps.setString(1, p_seno);
		ps.setString(2, p_no);
		ps.setString(3, i_code);
		ps.setString(4, p_date);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
}


