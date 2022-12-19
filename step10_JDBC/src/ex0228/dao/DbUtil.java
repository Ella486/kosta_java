package ex0228.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * DB를 연동을 위한 연결 실행
 * */

public class DbUtil {
/**
 * 로드
 * */
	static {
		try{
		Class.forName(DBProperties.DRIVER_NAME); //오라클 드라이버를 찾는다.
		
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
/**
* 연결
* */
	public static Connection getConnection() throws SQLException{
		Connection con = DriverManager.getConnection(DBProperties.url,DBProperties.user_id,DBProperties.user_pwd);
		return con;
	}
	
	/*public static void main(String [] args) {
		try {
			System.out.println("시작 -----");
			Connection con = DbUtil.getConnection();
			System.out.println("con:" + con);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}*/
	
/**
* 닫기(DDL 또는 DML 인 경우 - create , insert, update, delete)
* */
	public static void dbClose(Connection con, Statement st) {
		try {
			if(st!=null)st.close();
			if(con!=null)con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	* 닫기(Select 인 경우)
	* */
		public static void dbClose(Connection con, Statement st, ResultSet rs) {
			try {
				if(rs!=null)rs.close();
				dbClose(con, st);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	
	
	
}






