package ex0214.map.exam;

import java.util.Map;

public class MapStudentController {
	private static MapStudentService service = new  MapStudentService();
	
	/**
	 * ��ü�˻�
	 * */
	public static void selectAll() {
		try{//���񽺸� ȣ���ϰ� �� ����� �޾Ƽ� ������ �̵�
		
		Map<String,Person> map = service.selectAll();
		EndView.printAll(map);
		
		}catch(RuntimeException e) {
			EndView.printMessage(e.getMessage());
		}
	}
	/**
	 *key(id)�� �ش��ϴ� ���� �˻�
	 * */
	public static void searchById(String id) {
		try{
		Person person = service.searchByKey(id);
		EndView.printSearch(person);
		}catch(RuntimeException e) {
			EndView.printMessage(e.getMessage());
		}
	}
	
	/**
	 * ����ϱ�
	 * */
	public static void insert(Person person) {
		try {
			service.insert(person);
			EndView.printMessage(person.getId()+ "���� ��ϵǾ����ϴ�.");
		}catch(RuntimeException e){
			EndView.printMessage(e.getMessage());
		}
		
		
	}
	
	/**
	 * �����ϱ�
	 * */
	public static void delete(String key) {
		try {
			service.delete(key);
			EndView.printMessage(key + "��ǰ�� ���� �߽��ϴ�.");
		}catch(Exception e){
			EndView.printMessage(e.getMessage());
		}
	}
	
	/**
	 * �����ϱ�
	 * */
	public static void update(Person person) {
		try {
			service.update(person);
			EndView.printMessage(person.getId() + " ���� �����߽��ϴ�.");
		}catch(RuntimeException e){
			EndView.printMessage(e.getMessage());
		}
		
	}
	
}
