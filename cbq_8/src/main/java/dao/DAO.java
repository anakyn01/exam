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
	
	//참가자 조회
	public ArrayList<DTO> getPlayerList(){
		ArrayList<DTO> dtos = new ArrayList<DTO>();
		String query="";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				
				DTO dto = new DTO();
				
				dtos.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(""+query);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dtos;
	}
	//기술레벨 가져오기
	public String getSkill_level(String player_no) {
		String sl = "";
		String query="";
		try {
			con = DBConnection.getConnection();
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("getSkill_level 오류 :" + query);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return sl;
	}
	
	//심사점수 등록
	public int pointSave() {
		int r = 0;
		String query="";
		try {
			con = DBConnection.getConnection();
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("getSkill_level 오류 :" + query);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return r;
	}
	
	//심사점수 조회
	public ArrayList<DTO> getPointList(){
		ArrayList<DTO> dtos = new ArrayList<DTO>();
		String query="";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				
				DTO dto = new DTO();
				
				dtos.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("getPointList 오류"+query);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dtos;
	}
	
	
	//참가자 등수 조회
	public ArrayList<DTO> getRanking(){
		ArrayList<DTO> dtos = new ArrayList<DTO>();
		String query="";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				
				DTO dto = new DTO();
				
				dtos.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("getRanking 오류"+query);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dtos;
	}
	
	//심사점수 수정
	public int pointUpdate() {
		int r = 0;
		String query="";
		try {
			con = DBConnection.getConnection();
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("pointUpdate 오류 :" + query);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return r;
	}

}
