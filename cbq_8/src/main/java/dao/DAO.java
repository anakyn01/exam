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
String query="select p.player_no, p.name, n.nation_name, to_char(to_date(p.birth), 'yyyy\"년\"MM\"월\"dd\"일\"')as birth,\r\n"
+ " decode(substr(p.player_no, 0, 1),'1','남','여')as gender, p.skill_level, s.skill_name\r\n"
+ " from \"E08_홍길동_PLAYER\" p, \"E08_홍길동_NATION\" n, \"E08_홍길동_SKILL\" s\r\n"
+ " where p.nation_code = n.nation_code and p.skill_level=s.skill_level\r\n"
+ " order by birth asc";
/*
to_char(to_date(p.birth), 'yyyy\"년\"월\"dd\"일\"')as birth => yyyy년 MM월 dd일
decode(substr(p.player_no, 0, 1),'1','남','여')as gender 1 남 그렇지 않으면 여
두가지 조건에 따라 세개의 테이블을 조인
order by birth asc => 날짜를 기준으로 오름차순으로 정렬
*/
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				
String player_no = rs.getString("player_no");				
String name = rs.getString("name");		
String nation_name = rs.getString("nation_name");
String birth = rs.getString("birth");
String gender = rs.getString("gender");
String skill_level = rs.getString("skill_level");
String skill_name = rs.getString("skill_name");

DTO dto = new DTO();
				
dto.setPlayer_no(player_no);
dto.setName(name);
dto.setNation_name(nation_name);
dto.setBirth(birth);
dto.setGender(gender);
dto.setSkill_level(skill_level);
dto.setSkill_name(skill_name);
dtos.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("getPlayerList오류"+query);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return dtos;
	}
	//기술레벨 가져오기
	public String getSkill_level(String player_no) {
		String sl = "";
		String query="select skill_level from E08_홍길동_PLAYER where player_no ='"+player_no+"' ";
		try {
			con = DBConnection.getConnection();
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				sl = rs.getString("skill_level");
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
public int pointSave(String player_no, int point_1, int point_2, int point_3, int point_4, int total, double realava) {
int r = 0;
//String query="insert into E08_홍길동_point (player_no, point_1, point_2, point_3, point_4, total, realava) values (?,?,?,?,?,?,?)";
String query="insert into E08_홍길동_point values ('"+player_no+"','"+point_1+"','"+point_2+"','"+point_3+"',"
        + "'"+point_4+"','"+total+"','"+realava+"')";
		try {
			con = DBConnection.getConnection();
			ps=con.prepareStatement(query);
			r = ps.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("pointSave 오류 :" + query);
		}finally {
			DBConnection.closeDB(con, ps, rs);
		}
		return r;
	}
	
	//심사점수 조회
	public ArrayList<DTO> getPointList(){
		ArrayList<DTO> dtos = new ArrayList<DTO>();
String query="select p.player_no, p.name, t.point_1, t.point_2, t.point_3, t.point_4, t.total, t.ave\r\n"
+ " from E08_홍길동_player p, E08_홍길동_point t \r\n"
+ " where p.player_no=t.player_no";
		try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();

			while(rs.next()) {
String player_no = rs.getString("player_no");
String name = rs.getString("name");
int point_1 = rs.getInt("point_1");
int point_2 = rs.getInt("point_2");
int point_3 = rs.getInt("point_3");
int point_4 = rs.getInt("point_4");
int total = rs.getInt("total");
double ava = rs.getDouble("ave");

DTO dto = new DTO();
dto.setPlayer_no(player_no);
dto.setName(name);
dto.setPoint_1(point_1);
dto.setPoint_2(point_2);
dto.setPoint_3(point_3);
dto.setPoint_4(point_4);
dto.setTotal(total);
dto.setAva(ava);
				
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
String query="select p.player_no, p.name, n.nation_name, s.skill_name, t.total, t.ave, rank()over(order by t.ave desc) as rank\r\n"
+ " from E08_홍길동_player p, E08_홍길동_nation n, E08_홍길동_skill s, E08_홍길동_point t\r\n"
+ " where p.player_no = t.player_no and p.skill_level = s.skill_level and p.nation_code = n.nation_code \r\n"
+ " order by rank asc";
/*
rank()over(order by t.ave desc) as rank : 플레이어의 평균점수 (t.ave)를 기준으로 내림차순으로 순위를 지정하는 창 함수이다
평균 점수가 높을수록 더 나은 순위를 받습니다
*/
try {
			con = DBConnection.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
while(rs.next()) {
String player_no = rs.getString("player_no");
String name = rs.getString("name");
String nation_name = rs.getString("nation_name");
String skill_name = rs.getString("skill_name");
int total = rs.getInt("total");
double ava = rs.getDouble("ave");
String rank = rs.getString("rank");
//금은동을 써야하기 때문에
if(rank.equals("1")) rank="금";
else if(rank.equals("2")) rank="은";
else if(rank.equals("3")) rank="동";	

DTO dto = new DTO();
dto.setPlayer_no(player_no);
dto.setName(name);
dto.setNation_name(nation_name);
dto.setSkill_name(skill_name);
dto.setTotal(total);
dto.setAva(ava);
dto.setRank(rank);
				
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
