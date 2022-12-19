package ex0211.list;

import java.util.List;

/**
 * �л��� ������ CRUD�۾��ϴ� ���� ����
 * */

public interface StudentService {

	/**
	 * ����ϱ�
	 * @return : �����̸� true, �ƴϸ� false
	 * */
	boolean insert(Student student);
	
	/**
	 * ��ü�˻�
	 * */
	List<Student>selectAll();
	
	/**
	 * �й��� �ش��ϴ� ���� �˻�
	 * */
	Student selectBySno(String sno);
	
	/**
	 * �й��� �ش��ϴ� �л� �����ϱ�
	 * @return : �����̸� true, �ƴϸ� false
	 * */
	boolean delete(String sno);
	
	/**
	 * �й��� �ش��ϴ� �л��� ���� �����ϱ�(����, �ּҸ� ���氡��)
	 * */
	boolean update(Student student);
	
	
}
