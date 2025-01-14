package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.DBConnection;
import dto.DTO;

/*
tbl_product_0107, tbl_worklist_0107, tbl_process_0107
*/
public class DAO {
	//맴버변수 선언
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
//제품조회
	public ArrayList<DTO> getProductList(){
		ArrayList<DTO> dtos = new ArrayList<DTO>();//1)어레이 리스트 객체
//String query="SELECT p_code, p_name, p_size, p_type, p_price FROM TBL_PRODUCT_0107 ORDER BY p_code ASC";
	      String query="select p.p_code, p.p_name, s.p_size, p.p_type, to_char(p.p_price, '999,999')as p_price\r\n"
	              + "from tbl_product_0107 p, tbl_product_0107 s\r\n"
	              + "where p.p_size = s.p_size\r\n "
	              + "order by p_code asc";//2)sql 명령



		try {//3)접속
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {//4) 나열
				//1)getter, 2)객체 3)add
				String p_code = rs.getString("p_code");
				String p_name = rs.getString("p_name");
				String p_size = rs.getString("p_size");
				String p_type = rs.getString("p_type");
				String p_price = rs.getString("p_price");
				
				DTO dto = new DTO();//5) 데이타트랜스퍼 오브젝트로 객체만듬
				dto.setP_code(p_code);
				dto.setP_name(p_name);
				dto.setP_size(p_size);
				dto.setP_type(p_type);
				dto.setP_price(p_price);
				
				dtos.add(dto);
				//6) dtos객체에 항목 dto 추가
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("getProductList 오류"+query);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return  dtos;//7) 어레이 리스트 리턴
	}
//제품코드목록 셀렉트박스에 선택옵션을 리스트로 받아옴
	public ArrayList<DTO> getProductCodeList(){
		ArrayList<DTO> dtos = new ArrayList<DTO>();
		String query="select p_code, p_name from tbl_product_0107 order by p_code asc";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				String p_code = rs.getString("p_code");
				String p_name = rs.getString("p_name");
				
				DTO dto = new DTO();
				dto.setP_code(p_code);
				dto.setP_name(p_name);
				dtos.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("getProductcodeList 오류"+query);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dtos;
	}
//작업지시조회
	public ArrayList<DTO> getWorkList(){
		ArrayList<DTO> dtos = new ArrayList<DTO>();
String query="select concat(concat(substr(w.w_workno,1,4),'-'),\r\n"
+ "substr(w.w_workno,5,8)) as w_workno,\r\n"
+ "w.p_code, p.p_name, s.p_size, p.p_type, w.w_quentity,\r\n"
+ "to_char(w.w_workdate, 'yyyy-MM-dd')as w_workdate\r\n"
+ "from tbl_product_0107 p, tbl_worklist_0107 w, tbl_product_0107 s\r\n"
+ "where p.p_code = w.p_code and s.p_size = p.p_size\r\n"
+ "order by w.w_workno asc";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				String w_workno = rs.getString("w_workno");
				String p_code = rs.getString("p_code");
				String p_name = rs.getString("p_name");
				String p_size = rs.getString("p_size");
				String p_type = rs.getString("p_type");
				String w_quentity = rs.getString("w_quentity");
				String w_workdate = rs.getString("w_workdate");
				
				DTO dto = new DTO();
				dto.setW_workno(w_workno);
				dto.setP_code(p_code);
				dto.setP_name(p_name);
				dto.setP_size(p_size);
				dto.setP_type(p_type);
				dto.setW_quentity(w_quentity);
				dto.setW_workdate(w_workdate);
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
//작업공정조회
	public ArrayList<DTO> getProcessList(){
ArrayList<DTO> dtos = new ArrayList<DTO>();
String query="select concat(concat(substr(w.w_workno,1,4),'-'),substr(w.w_workno,5,8))as w_workno, p.p_code, p.p_name, decode(s.p_p1,'Y','완료','~') p_p1, decode(s.p_p2,'Y','완료','~') p_p2,\r\n" + 
" decode(s.p_p3,'Y','완료','~') p_p3, to_char(to_date(s.w_lastdate),'yyyy\"년\"MM\"월\"dd\"일\"')w_lastdate,\r\n" +
" concat(concat(substr(s.w_lasttime,1,2),':'),substr(s.w_lasttime,3,4))w_lasttime\r\n" + 
" from tbl_product_0107 p, tbl_worklist_0107 w, tbl_process_0107 s\r\n" + 
" where w.w_workno = s.w_workno and p.p_code = w.p_code\r\n" + 
" order by w.w_workno asc";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				String w_workno = rs.getString("w_workno");
			    String p_code = rs.getString("p_code");
			    String p_name = rs.getString("p_name");
			    String p_p1 = rs.getString("p_p1");
			    String p_p2 = rs.getString("p_p2");
			    String p_p3 = rs.getString("p_p3");
			    String w_lastdate = rs.getString("w_lastdate");
			    String w_lasttime = rs.getString("w_lasttime");
			    
			    DTO dto = new DTO();
			    dto.setW_workno(w_workno);
			    dto.setP_code(p_code);
			    dto.setP_name(p_name);
			    dto.setP_p1(p_p1);
			    dto.setP_p2(p_p2);
			    dto.setP_p3(p_p3);
			    dto.setW_lastdate(w_lastdate);
			    dto.setW_lasttime(w_lasttime);
			    dtos.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("getProcessList 오류"+query);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dtos;
	}
//작업지시등록	
	public int saveWorkList(){
		int result = 0;
		String query="";
		System.out.println(query);
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(""+query);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
//작업공정등록
	public int saveWorkProcess(String w_workno, String p_p1, String p_p2, String p_p3 ,String w_lastdate, String w_lasttime){
		int result = 0;
String query="insert into TBL_PROCESS_0107 (w_workno,p_p1,p_p2,p_p3,w_lastdate,w_lasttime) values (?,?,?,?,?,?)";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			
	        ps.setString(1, w_workno);
	        ps.setString(2, p_p1);
	        ps.setString(3, p_p2);
	        ps.setString(4, p_p3);
	        ps.setString(5, w_lastdate);
	        ps.setString(6, w_lasttime);
			
			result = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("saveWorkProcess 오류"+query);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
//작업공정수정
	public int updateWorkProcess(String w_workno, String p_p1, String p_p2, String p_p3, String w_lastdate, String w_lasttime){
		int result = 0;
		/*String query="update tbl_process_0107"
				+ "set p_p1 ='"+p_p1+"', p_p2='"+p_p2+"', p_p3='"+p_p3+"',w_lastdate='"+w_lastdate+"',w_lasttime='"+w_lasttime+"'\r\n"
				+ "where w_workno ='"+w_workno+"'";*/
		
		String query = "update tbl_process_0107 set p_p1 = ?, p_p2 = ?, p_p3 = ?, w_lastdate =?, w_lasttime = ? where w_workno= ?";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
	       
	        ps.setString(1, p_p1);
	        ps.setString(2, p_p2);
	        ps.setString(3, p_p3);
	        ps.setString(4, w_lastdate);
	        ps.setString(5, w_lasttime);
	        ps.setString(6, w_workno);
			
			
			result = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(""+query);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	
	
	
}
