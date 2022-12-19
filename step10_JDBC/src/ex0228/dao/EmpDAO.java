package ex0228.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class EmpDAO {
/**
 * 사원의 모든 이름을 검색하기
 * */
	public void selectNames() {
		//로드
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try {
		//연결
		con = DbUtil.getConnection();
		
		//실행
		st = con.createStatement();
		rs = st.executeQuery("select ename from emp");
		while(rs.next()) {
			String ename = rs.getString(1);
			System.out.println(ename);
		}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			//닫기
			DbUtil.dbClose(null, null, null);
		}	
		
	}
	/**
	 * 사원등록하기
	 * 
	 * */
	 
	public void insert(Emp emp){
		Connection con = null;
		Statement st = null;
		String sql = "insert into emp(empno, ename, job,sal,hiredate) values("+emp.getEmpno()+",'"+emp.getEname()+"','"+emp.getJob()+"',"+emp.getSal()+",sysdate)";
		try {
			System.out.println("sql =" + sql);
			con= DbUtil.getConnection();
			st= con.createStatement();
			int result = st.executeUpdate(sql);
			System.out.println("result: " + result);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(con, st);
		}
		
	}
	 
	/**
	 * 사원등록하기 -PrepareStatement
	 * 
	 * */
	public void preparedInsert(Emp emp){
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into emp(empno, ename, job, sal, hiredate) values(?,?,?,?,sysdate)";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			//?의 개수만큼 순서대로 setXxx()설정한다.
			ps.setInt(1, emp.getEmpno());
			ps.setString(2, emp.getEname());
			ps.setString(3, emp.getJob());
			ps.setInt(4, emp.getSal());
			
			
			int result = ps.executeUpdate();
			System.out.println("result : " + result);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(con, ps);
		}
		
	}
	/**
	 * 전체 사원 검색
	 * SELECT empno, ename, job, sal, hiredate FROM EMP
	 * */
	public void preparedSelectAll() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT empno, ename, job, sal, hiredate FROM EMP";
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			//?의 값 설정
			rs = ps.executeQuery();
			//컬럼의 정보
			ResultSetMetaData rmd = rs.getMetaData();
			for(int i=1; i<=rmd.getColumnCount(); i++) {
				String columnName = rmd.getColumnName(i);
				System.out.print(columnName +"\t\t");
			}
			
			System.out.println("\n------------------------------");
			while(rs.next()) {
				int empno = rs.getInt(1);
				String ename = rs.getString(2);
				String job = rs.getString("job");
				int sal = rs.getInt("SAL");
				String hiredate  = rs.getString(5);
				
				
				Emp emp = new Emp(empno, ename, job, sal, hiredate);
				System.out.println(emp); //emp.toString() 호출
			}
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DbUtil.dbClose(con, ps);
		}
	}
	
	
	
}//클래스 끝









