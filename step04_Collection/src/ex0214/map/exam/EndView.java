package ex0214.map.exam;

import java.util.Map;
import java.util.Map.Entry;

public class EndView {
	/**
	 * ��ü�˻� ���
	 * */
	public static void printAll(Map<String,Person> map) {
		System.out.println("****** ���� (" + map.size() +") �� *******");
		
		/*for( Entry<String, Person> me : map.entrySet()) {
			System.out.println(me.getKey() + " : " + me.getValue());
		}*/ //�̹���� ��
		
		for(String key : map.keySet()) {
			Person v = map.get(key); //Person �Ǵ� Student
			System.out.println(v);
		}
		
	}
	
	/**
	 * key=id�� �ش��ϴ� �������
	 * */
	public static void printSearch(Person person) {
		System.out.println(person.getName());
		
		if((person instanceof Student)) {
			Student student = (Student)person;
			
			System.out.println(" |  "+student.getSum());
		}
		System.out.println();
		
	}
	
	/**
	 * ���� �Ǵ� ���п� ���õ� �޼��� ���
	 * */
	public static void printMessage(String message) {
		System.out.println(message);
	}
}
