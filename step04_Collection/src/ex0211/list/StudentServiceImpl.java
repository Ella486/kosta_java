package ex0211.list;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {
	
	private List<Student> list = new ArrayList<Student>();

	/**
	 * 5���� �л��� �����͸� �����ϱ� ���� ������
	 * */
	public StudentServiceImpl() {//Controller
		//list�� �߰�
		list.add(new Student("A01","����",20,"����"));
		list.add(new Student("A02","ȿ��",22,"���ֵ�"));
		list.add(new Student("A03","����",20,"�λ�"));
		list.add(new Student("A04","�̼�",23,"����"));
		list.add(new Student("A05","����",21,"����"));
	}
	
	@Override
	public boolean insert(Student student) {
		
		//�߰����� �ߺ����θ� üũ���� :�μ��� ���޵� �й��� list�� �����  Student�� �ִ��� ã�´�.
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
			//����������
			saveSt.setAge(student.getAge());
			saveSt.setAddr(student.getAddr());
			
			return true;
		}
		return false;
	}

}
