package ex0211.list;

import java.util.List;

public class MainApp {

	public static void main(String[] args) {//view //
		StudentService service = new StudentServiceImpl();
		
		System.out.println("1. ��ü�˻� ---------------");
		List<Student> list = service.selectAll();
		printList(list);
		
		System.out.println("\n2. ����ϱ� (�ߺ�����)---------------");
		boolean result = service.insert(new Student("A06","����",27,"����"));
		System.out.println("result= " + result);
		
		list = service.selectAll();
		printList(list);
		
		System.out.println("\n2. ����ϱ� (�ߺ��ΰ��)---------------");
		result = service.insert(new Student("A03","�ο�",25,"�뱸"));
		System.out.println("result= " + result);
		
		list = service.selectAll();
		printList(list);
		
		System.out.println("\n3. �й��� �ش��ϴ� ���� �˻�(�����ϴ°��) ---------------");
		Student st = service.selectBySno("A04");
		System.out.println("st =" + st);
		
		System.out.println("\n3. �й��� �ش��ϴ� ���� �˻�(���°��) ---------------");
		st = service.selectBySno("A08");
		System.out.println("st =" + st);
		/////////////////////////////////////////////////////////
		
		System.out.println("\n4. �й��� �ش��ϴ� ���� �����ϱ�(�����Ǵ� ���) ---------------");
		result = service.update(new Student("A03", 30, "����"));
		System.out.println("result= " + result);
		
		System.out.println("\n4. �й��� �ش��ϴ� ���� �����ϱ�(�����ȵǴ� ���) ---------------");
		result = service.update(new Student("A09", 40, "�뱸"));
		System.out.println("result= " + result);

		list = service.selectAll();
		printList(list);
		
		
		System.out.println("\n 5.�й��� �ش��ϴ� ���� �����ϱ�(�����Ǵ� ���)---------------");
		result = service.delete("A03");
		System.out.println("result= " + result);
		
		System.out.println("\n 5.�й��� �ش��ϴ� ���� �����ϱ�(���� �ȵǴ� ���)--------------");
		result = service.delete("A09");
		System.out.println("result= " + result);
		
		//���Ȯ��
		list = service.selectAll();
		printList(list);

	}
	
	/**
	 * List ����ϱ�
	 * */
	public static void printList(List<Student> list) {
		System.out.println("***********��" + list.size()+ "��***************");
		for(Student st: list) {
			System.out.println(st);//st.toString()ȣ��
		}
		
		System.out.println();
	}
	

}
