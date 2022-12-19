package ex0214.map.exam;

import java.util.Map;
import java.util.Map.Entry;

public class EndView {
	/**
	 * 전체검색 출력
	 * */
	public static void printAll(Map<String,Person> map) {
		System.out.println("****** 정보 (" + map.size() +") 명 *******");
		
		/*for( Entry<String, Person> me : map.entrySet()) {
			System.out.println(me.getKey() + " : " + me.getValue());
		}*/ //이방법도 됨
		
		for(String key : map.keySet()) {
			Person v = map.get(key); //Person 또는 Student
			System.out.println(v);
		}
		
	}
	
	/**
	 * key=id에 해당하는 정보출력
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
	 * 성공 또는 실패에 관련된 메세지 출력
	 * */
	public static void printMessage(String message) {
		System.out.println(message);
	}
}
