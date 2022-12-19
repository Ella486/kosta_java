package ex0302.transaction;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ex0228.dao.DbUtil;



public class TransactionDAO {
  /**
   * ������ü ��� ����
   * */
	public void transfer(String inputAccount, String outputAccount, int money) {//�Աݰ���, ��ݰ���, �ݾ�
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			con= DbUtil.getConnection();
			con.setAutoCommit(false); //�ڵ�Ŀ������
			
			//1. ����Ѵ�.
			int re =this.withDraw(con, outputAccount, money);
			if(re==0) throw new SQLException(outputAccount + "���¹�ȣ �����Դϴ�.(��ݰ��¿���) - ��ü����");
			
			//2. �Ա��Ѵ�.
			re=this.deposit(con, inputAccount, money);
			if(re==0) throw new SQLException(inputAccount + "���� �����Դϴ�.(�Աݰ��¿���) - ��ü����");
			
			//3. �ܾ�Ȯ���Ѵ�.
			if(this.isCheckBalance(con, inputAccount)) throw new SQLException("�Աݰ����� �Ѿ��� �ִ�ݾ��� �ʰ��Ͽ� ��ü �����Ͽ����ϴ�.");
			
			//4. ���� �����̸� ����Ϸ�
			con.commit();
			System.out.println("������ü �����Ͽ����ϴ�.");
		
			
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
	}//�޼ҵ� ��
	
	/**
	 * ����ϱ�
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
	 * �Ա��ϱ�
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
	 * �ܾ�Ȯ��(�Աݵ� ����� �Ѿ��� 1000�� �̸��̾�� �Ѵ�.)
	 * @return : true�̸� �ʰ�, false �̸� �ʰ� �ƴϴ�.
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
		System.out.println("--1. ��ݰ��� ����----");
		//dao.transfer("A02", "A05",200);//�Ա�, ���, �ݾ�
		
		System.out.println("--2. �Աݰ��� ����----");
		//dao.transfer("A04", "A01",200);//�Ա�, ���, �ݾ�
		
		
		System.out.println("--3. �Աݰ����� �Ѿ� 1000�� �̻��ΰ��----");
		//dao.transfer("A02", "A01",700);//�Ա�, ���, �ݾ�
		
		System.out.println("--4. ����----------");
		//dao.transfer("A02", "A01",100);//�Ա�, ���, �ݾ�
	}
}











