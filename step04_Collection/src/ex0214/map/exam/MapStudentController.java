package ex0214.map.exam;

import java.util.Map;

public class MapStudentController {
	private static MapStudentService service = new  MapStudentService();
	
	/**
	 * 전체검색
	 * */
	public static void selectAll() {
		try{//서비스를 호출하고 그 결과를 받아서 결과뷰로 이동
		
		Map<String,Person> map = service.selectAll();
		EndView.printAll(map);
		
		}catch(RuntimeException e) {
			EndView.printMessage(e.getMessage());
		}
	}
	/**
	 *key(id)에 해당하는 정보 검색
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
	 * 등록하기
	 * */
	public static void insert(Person person) {
		try {
			service.insert(person);
			EndView.printMessage(person.getId()+ "님이 등록되었습니다.");
		}catch(RuntimeException e){
			EndView.printMessage(e.getMessage());
		}
		
		
	}
	
	/**
	 * 삭제하기
	 * */
	public static void delete(String key) {
		try {
			service.delete(key);
			EndView.printMessage(key + "제품을 삭제 했습니다.");
		}catch(Exception e){
			EndView.printMessage(e.getMessage());
		}
	}
	
	/**
	 * 수정하기
	 * */
	public static void update(Person person) {
		try {
			service.update(person);
			EndView.printMessage(person.getId() + " 님을 수정했습니다.");
		}catch(RuntimeException e){
			EndView.printMessage(e.getMessage());
		}
		
	}
	
}
