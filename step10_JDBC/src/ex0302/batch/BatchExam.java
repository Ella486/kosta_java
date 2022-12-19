package ex0302.batch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ex0228.dao.DbUtil;

public class BatchExam {
	/**
	 * copy_emp ���� �����ȣ�� �ش��ϴ� ������ �����Ѵ�.( �ѹ��� �������� delete�� ����)
	 * */
	public void delete(List<Integer> empnoList) {
		Connection con=null;
		PreparedStatement ps = null;
		String sql = "delete copy_emp where empno=?";
		try {
			con = DbUtil.getConnection();
			con.setAutoCommit(false);//�ڵ�Ŀ������
			
			ps= con.prepareStatement(sql);
			for(int empno : empnoList) {
				ps.setInt(1, empno);
				ps.addBatch(); //�ϰ��۾�ó���� ���� ������ �߰��Ѵ�.
				ps.clearParameters(); // �Ķ���Ϳ� ���� ������ ��������
			}
			
			/**
			 * executeBatch() �� ��� ���� 11g ������ ������ ������ �ƴϸ�
			 * ������ -2�� �����Ѵ�.
			 * 
			 * 12c version���� ������ �ݿ��� ���ڵ� ���� ���� ���ϵȴ�.
			 * */
			int result [] = ps.executeBatch();
			for(int re: result) {
				System.out.println(re); //�ּҰ�
			}
			
			con.commit();
			
		}catch(SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
		}finally {
			DbUtil.dbClose(con, ps);
		}
	}
	
	
	
	public static void main(String[] args) {
		BatchExam be = new BatchExam();
		List<Integer> empnoList = Arrays.asList(7369,8004,8001,7934,8003,9000);
		be.delete(empnoList);

	}

}
