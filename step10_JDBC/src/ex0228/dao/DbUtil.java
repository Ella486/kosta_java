package ex0228.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * DB�� ������ ���� ���� ����
 * */

public class DbUtil {
/**
 * �ε�
 * */
	static {
		try{
		Class.forName(DBProperties.DRIVER_NAME); //����Ŭ ����̹��� ã�´�.
		
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
/**
* ����
* */
	public static Connection getConnection() throws SQLException{
		Connection con = DriverManager.getConnection(DBProperties.url,DBProperties.user_id,DBProperties.user_pwd);
		return con;
	}
	
	/*public static void main(String [] args) {
		try {
			System.out.println("���� -----");
			Connection con = DbUtil.getConnection();
			System.out.println("con:" + con);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}*/
	
/**
* �ݱ�(DDL �Ǵ� DML �� ��� - create , insert, update, delete)
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
	* �ݱ�(Select �� ���)
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






