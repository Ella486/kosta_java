package ex0217.io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class ObjectLoadExam {

	public ObjectLoadExam(){
		//���Ͽ� ����� ��ü�� �������� - ObjectInputStream (�������ִ� ������ ��)
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/ex0217/io/objectSave.txt"))){
			Student st1 = (Student)ois.readObject();
			Student st2 = (Student)ois.readObject();
			
			List<Student> list = (List<Student>)ois.readObject();
			
			System.out.println("st1: " + st1);
			System.out.println("st2: " + st2);
			
			System.out.println("list: " + list);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new ObjectLoadExam();

	}

}
