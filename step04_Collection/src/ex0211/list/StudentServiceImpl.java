package ex0211.list;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {
	
	private List<Student> list = new ArrayList<Student>();

	/**
	 * 5명의 학생의 데이터를 세팅하기 위함 생성자
	 * */
	public StudentServiceImpl() {//Controller
		//list에 추가
		list.add(new Student("A01","희정",20,"서울"));
		list.add(new Student("A02","효리",22,"제주도"));
		list.add(new Student("A03","나영",20,"부산"));
		list.add(new Student("A04","미선",23,"서울"));
		list.add(new Student("A05","영미",21,"대전"));
	}
	
	@Override
	public boolean insert(Student student) {
		
		//추가전에 중복여부를 체크하자 :인수로 전달된 학번이 list에 저장된  Student에 있는지 찾는다.
		if(this.selectBySno(student.getSno() ) != null){
			
			return false;
		}
		
		boolean result = list.add(student);
		return result;
	}

	@Override
	public List<Student> selectAll() {
		return list;
	}

	@Override
	public Student selectBySno(String sno) {
		for(Student st: list) {
			if(st.getSno().equals(sno)) {
				return st;
			}
		}
		return null;
	}

	@Override
	public boolean delete(String sno) {
		Student savedst = this.selectBySno(sno);
		return list.remove(savedst);
	}

	@Override
	public boolean update(Student student) {
		Student saveSt = this.selectBySno(student.getSno());
		if(saveSt != null) {
			//값변경하자
			saveSt.setAge(student.getAge());
			saveSt.setAddr(student.getAddr());
			
			return true;
		}
		return false;
	}

}
