package ex0211.list;

import java.util.List;

public class MainApp {

	public static void main(String[] args) {//view //
		StudentService service = new StudentServiceImpl();
		
		System.out.println("1. 전체검색 ---------------");
		List<Student> list = service.selectAll();
		printList(list);
		
		System.out.println("\n2. 등록하기 (중복없이)---------------");
		boolean result = service.insert(new Student("A06","순이",27,"서울"));
		System.out.println("result= " + result);
		
		list = service.selectAll();
		printList(list);
		
		System.out.println("\n2. 등록하기 (중복인경우)---------------");
		result = service.insert(new Student("A03","민영",25,"대구"));
		System.out.println("result= " + result);
		
		list = service.selectAll();
		printList(list);
		
		System.out.println("\n3. 학번에 해당하는 정보 검색(존재하는경우) ---------------");
		Student st = service.selectBySno("A04");
		System.out.println("st =" + st);
		
		System.out.println("\n3. 학번에 해당하는 정보 검색(없는경우) ---------------");
		st = service.selectBySno("A08");
		System.out.println("st =" + st);
		/////////////////////////////////////////////////////////
		
		System.out.println("\n4. 학번에 해당하는 정보 수정하기(수정되는 경우) ---------------");
		result = service.update(new Student("A03", 30, "서울"));
		System.out.println("result= " + result);
		
		System.out.println("\n4. 학번에 해당하는 정보 수정하기(수정안되는 경우) ---------------");
		result = service.update(new Student("A09", 40, "대구"));
		System.out.println("result= " + result);

		list = service.selectAll();
		printList(list);
		
		
		System.out.println("\n 5.학번에 해당하는 정보 삭제하기(삭제되는 경우)---------------");
		result = service.delete("A03");
		System.out.println("result= " + result);
		
		System.out.println("\n 5.학번에 해당하는 정보 삭제하기(삭제 안되는 경우)--------------");
		result = service.delete("A09");
		System.out.println("result= " + result);
		
		//결과확인
		list = service.selectAll();
		printList(list);

	}
	
	/**
	 * List 출력하기
	 * */
	public static void printList(List<Student> list) {
		System.out.println("***********총" + list.size()+ "명***************");
		for(Student st: list) {
			System.out.println(st);//st.toString()호출
		}
		
		System.out.println();
	}
	

}
