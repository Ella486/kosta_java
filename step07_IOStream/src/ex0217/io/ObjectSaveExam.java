package ex0217.io;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectSaveExam {
	public ObjectSaveExam(){
		Student st1 = new Student("����", 20, "����");
		Student st2 = new Student("����", 32, "�뱸");
		
		//���Ͽ� List ���尡�� - �̹� Serializable ������ ���ұ⿡ ����ȭ �� �� �ִ�.
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("ȿ��", 23, "����"));
		list.add(new Student("�̼�", 41, "�뱸"));
		list.add(new Student("�߱�", 23, "�λ�"));
		
		//����
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/ex0217/io/objectSave.txt"))) {
			
			oos.writeObject(st1);
			oos.writeObject(st2);
			oos.writeObject(list);
			
			System.out.println("��ü ���� �Ϸ�!!!");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public static void main(String[] args) {
		new ObjectSaveExam();

	}

}
