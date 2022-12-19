package ex0228.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLInjectionTest {

	/**
	 * Statement 인 경우
	 * select empno, ename, job, sal, hiredate from emp where empno='8002'
	 * */
	public void statementTest(String empno) {
		Connection con =null;
		Statement stm = null;
		ResultSet rs=null;
		String sql = "select empno, ename, job, sal, hiredate from emp where empno="+ empno;
		try {
			con = DbUtil.getConnection();
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			while(rs.next()) {
				int no = rs.getInt(1);
				String ename = rs.getString(2);
				String job = rs.getString(3);
				int sal = rs.getInt(4);
				String hiredate  = rs.getString(5);
				
				
				Emp emp = new Emp(no, ename, job, sal, hiredate);
				System.out.println(emp); //emp.toString() 호출
				
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(con, stm, rs);
		}
	}
	
	
	
	
	/**
	 * PreparedStatement 인 경우
	 * */
	public void preparedTest(String empno) {
		Connection con =null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		String sql = "select empno, ename, job, sal, hiredate from emp where empno=?";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, empno);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				int no = rs.getInt(1);
				String ename = rs.getString(2);
				String job = rs.getString(3);
				int sal = rs.getInt(4);
				String hiredate  = rs.getString(5);
				
				
				Emp emp = new Emp(no, ename, job, sal, hiredate);
				System.out.println(emp); //emp.toString() 호출
				
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(con, ps, rs);
		}
	}
	
	
	public static void main(String[] args) {
		SQLInjectionTest st = new SQLInjectionTest();
		
		
		System.out.println("1. Statement Test------");
		//st.statementTest("8002");
		//st.statementTest("9000");
		
		//OWASP top 10: 전세계적으로 매년 웹의 취약점 사례를 조사한 top10가지를 제공
		//st.statmentTest("9000 or 1=1"); //9000 or 1 =0 --> SQLInjection 공격 (행안부 제공하는 자바 시큐어코딩가이드 - pdf)
		
		System.out.println("\n2.PreparedStatement  Test------");
		//st.preparedTest("8002");
		//st.preparedTest("9000");
		
		//st.preparedTest("9000 or 1=1");
		
		
	}

}
