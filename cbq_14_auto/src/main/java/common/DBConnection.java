package common;

import java.sql.*;

public class DBConnection {
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버가 없스므니다");
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","exam_usr","1234");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void closeDB(Connection con, PreparedStatement ps, ResultSet rs) {
		if(con != null) {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		if(ps != null) {
			try {
				ps.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		if(rs != null) {
			try {
				rs.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	

}
