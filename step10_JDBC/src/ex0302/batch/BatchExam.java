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
	 * copy_emp 에서 사원번호에 해당하는 정보를 삭제한다.( 한번에 여러개의 delete를 실행)
	 * */
	public void delete(List<Integer> empnoList) {
		Connection con=null;
		PreparedStatement ps = null;
		String sql = "delete copy_emp where empno=?";
		try {
			con = DbUtil.getConnection();
			con.setAutoCommit(false);//자동커밋해지
			
			ps= con.prepareStatement(sql);
			for(int empno : empnoList) {
				ps.setInt(1, empno);
				ps.addBatch(); //일괄작업처리를 위한 문장을 추가한다.
				ps.clearParameters(); // 파라미터에 대한 정보를 제거해줌
			}
			
			/**
			 * executeBatch() 의 결과 값이 11g 까지는 쿼리가 오류가 아니면
			 * 무조건 -2를 리턴한다.
			 * 
			 * 12c version부터 쿼리가 반영된 레코드 행의 수가 리턴된다.
			 * */
			int result [] = ps.executeBatch();
			for(int re: result) {
				System.out.println(re); //주소값
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
