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
	
	//오디션 등록
	public int ArtistSave(String a_no, String a_name, String a_birth, String gender, String talent, String agency) {
		int result = 0;
		//String query = "insert into artist values ('"+a_no+"','"+a_name+"','"+gender+"','"+a_birth+"','"+talent+"','"+agency+"')";
		String query = "insert into artist (a_no,a_name,gender,a_birth,talent,agency) values (?,?,?,?,?,?)";
		/*try {
		con = DBConnection.getConnection();
		ps = con.prepareStatement(query);
	    result = ps.executeUpdate();*/
		try(Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
			ps.setString(1, a_no);
			ps.setString(2, a_name);
			ps.setString(3, gender);
			ps.setString(4, a_birth);
			ps.setString(5, talent);
			ps.setString(6, agency);

		    result = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("ArtistSave 오류 : " + query);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	//참가자 목록 조회
	public ArrayList<DTO> getArtistList(){
		ArrayList<DTO> dtos = new ArrayList<>();
	      String query="select artist_id, artist_name, decode(artist_gender,'M','남성','F','여성')as artist_gender,\r\n" + 
	              " to_char(to_date(artist_birth, 'YYYY-MM-DD'),'yyyy\"년\"MM\"월\"dd\"일\"')as artist_birth, decode(talent,'1','댄스','2','랩','노래')as talent, agency\r\n" + 
	              " from tbl_artist\r\n" + 
	              " order by artist_id asc";
	      try {
	  		con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
		    rs = ps.executeQuery();
		    
		    while(rs.next()) {
		    	String a_id = rs.getString("artist_id");
		    	String a_name = rs.getString("artist_name");
		    	String a_gender = rs.getString("artist_gender");
		    	String a_birth = rs.getString("artist_birth");
		    	String talent = rs.getString("talent");
		    	String agency = rs.getString("agency");
		    	
		    	DTO dto = new DTO();
		    	dto.setA_id(a_id);
		    	dto.setA_name(a_name);
		    	dto.setA_gender(a_gender);
		    	dto.setA_birth(a_birth);
		    	dto.setTalent(talent);
		    	dto.setAgency(agency);
		    	dtos.add(dto);
		    }
	      }catch(Exception e) {
				e.printStackTrace();
				System.out.println("getArtistList 오류 : " + query); 
	      }finally {
	    	  DBConnection.closeDB(con, ps, rs);
	      }
	      return dtos;
	}
	//점수 없는 참가자 목록조회
	public ArrayList<DTO> getNoPointArtist(){
	      ArrayList<DTO> dtos = new ArrayList<DTO>();
	      String query="select a.artist_id, a.artist_name\r\n" + 
	            " from tbl_point p right outer join tbl_ARTIST a on p.artist_id = a.artist_id\r\n" + 
	            " where p.artist_id is null\r\n" + 
	            " order by a.artist_id asc";
	      
	      try{
	         con = DBConnection.getConnection();
	         ps = con.prepareStatement(query);
	         rs = ps.executeQuery();
	         while(rs.next()) {
	            String a_id = rs.getString("artist_id");
	            String a_name = rs.getString("artist_name");
	            
	            DTO dto = new DTO();
	            dto.setA_id(a_id);
	            dto.setA_name(a_name);
	            
	            dtos.add(dto);
	         }
	      }catch(Exception e) {
	         e.printStackTrace();
	         System.out.println("getNoPointArtist 오류 : "+query);
	      }finally{
	         DBConnection.closeDB(con, ps, rs);
	      }
	      
	      return dtos;
	}
	//멘토점수 등록
	public int PointSave(int serial_no, String a_id, String point_1, String point_2, String point_3) {
		int result = 0;
		int s2 = serial_no + 1;
		int s3 = serial_no + 2;
		String query = "insert all\r\n"+
		" into tbl_point(serial_no, artist_id, mento_id, point)\r\n"+
		"values('"+serial_no+"','"+a_id+"','J001','"+point_1+"')\r\n"+
		" into tbl_point('"+s2+"', artist_id, mento_id, point)\r\n"+
		"values('"+serial_no+"','"+a_id+"','J002','"+point_2+"')\r\n"+
		" into tbl_point('"+s2+"', artist_id, mento_id, point)\r\n"+
		"values('"+serial_no+"','"+a_id+"','J003','"+point_2+"')\r\n"+
		"select * from dual";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			result = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("PointSave 오류 : " + query);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return result;
	}
	
	   //시리얼넘버  최신순
	   public int getMaxNo() {
	      int no = 0;
	      String query="select max(serial_no+1)as no\r\n" + 
	            " from tbl_point";
	      
	      try{
	         con = DBConnection.getConnection();
	         ps = con.prepareStatement(query);
	         rs = ps.executeQuery();
	         if(rs.next()) {
	            no = rs.getInt("no");
	         }
	      }catch(Exception e) {
	         e.printStackTrace();
	         System.out.println("getMaxNo 오류 : "+query);
	      }finally{
	         DBConnection.closeDB(con, ps, rs);
	      }
	      
	      return no;
	   }
	
	   //멘토점수 조회
	public ArrayList<DTO> getMentoPointList(){
		ArrayList<DTO> dtos = new ArrayList<DTO>();
String query="select p.serial_no, p.artist_id, a.artist_name, to_char(to_date(a.artist_birth),'yyyy\"년\"MM\"월\"dd\"일\"')as artist_birth, p.point, m.mento_name\r\n"+
	" from tbl_artist a, tbl_point p, tbl_memto m\r\n"+
	" where a.artist_id = p.artist_id and m.mento_id = p.mento_id\r\n"+
	" order by p.serial_no asc";
try {
	con = DBConnection.getConnection();
	ps = con.prepareStatement(query);
	rs = ps.executeQuery();
	while(rs.next()) {
		String s_no = rs.getString("serial_no");
		String a_id = rs.getString("artist_id");
		String a_name = rs.getString("artist_name");
		String a_birth = rs.getString("artist_birth");
		String point = rs.getString("point");
		String m_name = rs.getString("mento_name");
		
		DTO dto = new DTO();
		dto.setS_no(s_no);
		dto.setA_id(a_id);
		dto.setA_name(a_name);
		dto.setA_birth(a_birth);
		dto.setPoint(point);
		dto.setM_name(m_name);
		dtos.add(dto);
	}
}catch(Exception e) {
	e.printStackTrace();
	System.out.println("getMentoPointList 오류 : " + query);
}finally {
	DBConnection.closeDB(con, ps, rs);
}
return dtos;		
	}
	
	//참가자 등수조회 round(x.ava, 2) 값을 소수점 둘째 자리까지 반올림 한다 to_char 특정 형식의 문자열로 포멧합니다 FM채우기 모드를 의미하고 결과에서 앞뒤 공백을 제거합니다 x.ava 앞이나 뒤에 공백없이 소수점 2자리까지 반올림한 문자열을 리턴한다
	//AVG(point):열의 평균값을 계산합니다 As ava:계산된 평균의 별칭, group by artist_id : 결과를 기준으로 그룹화 하여 artist_id별로 평균을 계산합니다
	public ArrayList<DTO> getRanking(){
		ArrayList<DTO> dtos = new ArrayList<DTO>();
		String query="select a.artist_id, a.artist_name, decode(artist_gender,'M','남성','F','여성')as artist_gender, x.total, to_char(round(x.ava,2), 'FM90.00')as ava\r\n"+
		"from tbl_artist a, tbl_point p,\r\n"+
		"(select artist_id, sum(point)as total, avg(point)as ava from tbl_point group by artist_id) x\r\n"+		
		"where a.artist_id=p.artist_id and p.artist_id=x.artist_id\r\n"+
		"group by a.artist_id, a.artist_name, a.artist_gender, x.total, x.ava\r\n"+
		"order by x.total desc";
		

		try {
			con = DBConnection.getConnection();
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()) {
				String a_id = rs.getString("artist_id");
				String a_name = rs.getString("artist_name");
				String a_gender = rs.getString("artist_gender");
				String total = rs.getString("total");
				String ava = rs.getString("ava");
				
				DTO dto = new DTO();
				dto.setA_id(a_id);
				dto.setA_name(a_name);
				dto.setA_gender(a_gender);
				dto.setTotal(total);
				dto.setAva(ava);
				dtos.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("getRanking 오류 :" + query);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dtos;
	}
	
	
	
	
	
	
	
	
	
	

}
