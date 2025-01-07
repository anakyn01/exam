package gas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class GasDAO {

	private Connection conn;
	private ResultSet rs;
	
    //생성자
	public GasDAO() {
		try {
			String dbURL = "jdbc:oracle:thin:@localhost:1521/xe";
			String dbID = "SYSTEM";
			String dbPassword = "1234";
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//시간
	public String getDate() {
		String sql = "select sysdate from TBL_CUSTINFO_202010";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	//순번 oil_seq, sale_seq, gas_seq
	public int getNext() {
		int num =0;
		String sql = "select GAS_SEQ.NEXTVAL from dual";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public ArrayList<Gas> getList(){
	String sql = "select * from TBL_CUSTINFO_202010 order by bno asc";
	ArrayList<Gas> list = new ArrayList<Gas>();
	try {
		PreparedStatement pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			Gas gas = new Gas();
			gas.setBno(rs.getInt(1));
			gas.setCustno(rs.getString(2));
			gas.setCustname(rs.getString(3));
			gas.setCustjumin(rs.getString(4));
			gas.setCusttel1(rs.getString(5));
			gas.setCusttel2(rs.getString(6));
			gas.setCusttel3(rs.getString(7));
			list.add(gas);
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
	return list;
}
	
	public ArrayList<Money> getList2(){
		String sql = "select * from TBL_SALEINFO_202010 order by salebno asc";
		ArrayList<Money> list = new ArrayList<Money>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Money money = new Money();
				money.setSalebno(rs.getInt(1));
				money.setSaleno(rs.getString(2));
				money.setOildate(rs.getString(3));
				money.setOiltype(rs.getString(4));
				money.setAmount(rs.getInt(5));
				money.setPaytype(rs.getString(6));
				money.setCustno(rs.getString(7));
				money.setCreditcard(rs.getString(8));
				money.setOilcost(rs.getInt(9));
				list.add(money);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/*

	*/
	
	
	
	
}
