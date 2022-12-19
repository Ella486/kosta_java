package ex0302.transaction;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ex0228.dao.DbUtil;



public class TransactionDAO {
  /**
   * 계좌이체 기능 구현
   * */
	public void transfer(String inputAccount, String outputAccount, int money) {//입금계좌, 출금계좌, 금액
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			con= DbUtil.getConnection();
			con.setAutoCommit(false); //자동커밋해지
			
			//1. 출금한다.
			int re =this.withDraw(con, outputAccount, money);
			if(re==0) throw new SQLException(outputAccount + "계좌번호 오류입니다.(출금계좌오류) - 이체실패");
			
			//2. 입금한다.
			re=this.deposit(con, inputAccount, money);
			if(re==0) throw new SQLException(inputAccount + "계좌 오류입니다.(입금계좌오류) - 이체실패");
			
			//3. 잔액확인한다.
			if(this.isCheckBalance(con, inputAccount)) throw new SQLException("입금계좌의 총액이 최대금액을 초과하여 이체 실패하였습니다.");
			
			//4. 모든게 정상이면 저장완료
			con.commit();
			System.out.println("계좌이체 성공하였습니다.");
		
			
		}catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
				System.out.println(e.getMessage());
			}catch (Exception ex) {
				ex.printStackTrace();
			}
			
		}finally {
		
			DbUtil.dbClose(con,null);
		}
	}//메소드 끝
	
	/**
	 * 출금하기
	 * update bank set balance=balance-? where account = ?
	 */
	public int withDraw(Connection con, String outputAccount, int money) throws SQLException {
		PreparedStatement ps=null;
		int result=0;
		String sql = "update bank set balance=balance-? where account = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, money);
			ps.setString(2, outputAccount);
			
			result = ps.executeUpdate();
		 
		}finally {
			DbUtil.dbClose(null, ps);
		}
		
		return result;
	}
	
	
	/**
	 * 입금하기
	 * 
	 */
	public int deposit(Connection con, String inputAccount, int money) throws SQLException  {
		PreparedStatement ps=null;
		int result=0;
		String sql = "update bank set balance=balance-? where account = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, money);
			ps.setString(2, inputAccount);
			
			result = ps.executeUpdate();
		 
		}finally {
			DbUtil.dbClose(null, ps);
		}
		
		return result;
	}
	
	/**
	 * 잔액확인(입금된 계돠의 총액이 1000원 미만이어야 한다.)
	 * @return : true이면 초과, false 이면 초과 아니다.
	 */
	public boolean isCheckBalance(Connection con, String inputAccount)throws SQLException {
		PreparedStatement ps=null;
		ResultSet rs = null;
		String sql = "select balance from bank where account=?";
		boolean result = false;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, inputAccount);
			
			rs= ps.executeQuery();
			if(rs.next()) {
				int balance = rs.getInt(1);
				if(balance>=1000) result=true;
			}
			
			
		} finally {
			DbUtil.dbClose(null, ps,rs);
		}
			
		
		return false;
	}
	
	
	public static void main(String[] args) {
		TransactionDAO dao = new TransactionDAO();
		System.out.println("--1. 출금계좌 오류----");
		//dao.transfer("A02", "A05",200);//입금, 출금, 금액
		
		System.out.println("--2. 입금계좌 오류----");
		//dao.transfer("A04", "A01",200);//입금, 출금, 금액
		
		
		System.out.println("--3. 입금계좌의 총액 1000원 이상인경우----");
		//dao.transfer("A02", "A01",700);//입금, 출금, 금액
		
		System.out.println("--4. 성공----------");
		//dao.transfer("A02", "A01",100);//입금, 출금, 금액
	}
}











