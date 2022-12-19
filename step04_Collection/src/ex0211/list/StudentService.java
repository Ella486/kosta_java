package ex0211.list;

import java.util.List;

/**
 * 학생의 정보를 CRUD작업하는 서비스 영역
 * */

public interface StudentService {

	/**
	 * 등록하기
	 * @return : 성공이면 true, 아니면 false
	 * */
	boolean insert(Student student);
	
	/**
	 * 전체검색
	 * */
	List<Student>selectAll();
	
	/**
	 * 학번에 해당하는 정보 검색
	 * */
	Student selectBySno(String sno);
	
	/**
	 * 학번에 해당하는 학생 삭제하기
	 * @return : 성공이면 true, 아니면 false
	 * */
	boolean delete(String sno);
	
	/**
	 * 학번에 해당하는 학생의 정보 수정하기(나이, 주소만 변경가능)
	 * */
	boolean update(Student student);
	
	
}
