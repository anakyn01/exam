package common;

import java.sql.*;

public class DBConnection {
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","exam_usr","1234");
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(con==null) {
		System.out.println("DB 접속오류");
		}
		return con;
	}
	
	public static void closeDB(Connection con, PreparedStatement ps, ResultSet rs) {
		if(con != null) {
			try {
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(ps != null) {
			try {
				ps.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(rs != null) {
			try {
				ps.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
