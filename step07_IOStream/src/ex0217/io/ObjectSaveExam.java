package ex0217.io;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectSaveExam {
	public ObjectSaveExam(){
		Student st1 = new Student("희정", 20, "서울");
		Student st2 = new Student("나영", 32, "대구");
		
		//파일에 List 저장가능 - 이미 Serializable 구현해 놓았기에 직렬화 할 수 있다.
		List<Student> list = new ArrayList<Student>();
		list.add(new Student("효리", 23, "서울"));
		list.add(new Student("미선", 41, "대구"));
		list.add(new Student("중기", 23, "부산"));
		
		//저장
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/ex0217/io/objectSave.txt"))) {
			
			oos.writeObject(st1);
			oos.writeObject(st2);
			oos.writeObject(list);
			
			System.out.println("객체 저장 완료!!!");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public static void main(String[] args) {
		new ObjectSaveExam();

	}

}
