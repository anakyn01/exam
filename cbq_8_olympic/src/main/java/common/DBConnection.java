package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {

	public static Connection getConnection() {
		Connection con = null;		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","exam_usr","1234");
			if(con==null) {
				System.out.println("DB접속오류");
			}
		}catch(Exception e) {
			e.printStackTrace();
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
				rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
