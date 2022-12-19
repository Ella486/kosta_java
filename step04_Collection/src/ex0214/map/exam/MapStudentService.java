package ex0214.map.exam;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapStudentService {
	private Map<String, Person> map = new HashMap<String, Person>();
	
	/**
	 * 생성자를 이용해서 map 에 초기치데이터 세팅
	 * */
	public MapStudentService() {
		//Map에 추가
		map.put("jang", this.create("jang", "장희정", 20));//Person
		map.put("hee", this.create("hee", "김희선", 25));//Person
		
		map.put("king", this.create("king", "송중기", 30, 80, 90, 40));//Student
		map.put("girl", this.create("girl", "김미희", 22, 90, 95, 90));//Student
		map.put("queen", this.create("queen", "고소영", 35, 70, 90, 85));//Student
	}
	
	/**
	 * Student 또는 Person을 생성해서 리턴해주는 메소드
	 * */
	public Person create(String id, String name, int age, int ...params) {
		if(params.length==0) {
			return new Person(id,name,age);
			
		}else if(params.length==3) {
			return new Student(id,name,age,params[0],params[1],params[2]);
		}else {
			throw new RuntimeException("전달된 인수가 잘못되어 생성할 수 없어요");
		}
		
		
	}
	
	
	/**
	 * 전체검색
	 * */
	public Map<String, Person> selectAll(){
		if(map.isEmpty() || map.size()==0) {
			throw new RuntimeException("저장된 정보가 없습니다.");
		}
		return map;
	}
	
	/**
	 * key에 해당하는 정보 검색하기
	 *  key에 해당하는 정보 검색
	 *   :key해당하는 정보를 출력할때 
	 *    [ Person인경우는 이름만 출력
	 *     Student인경우는 이름과 총점 출력 ] -> EndView에서 
	 *     없는경우는 "id는 없습니다." 예외발생
	 * */
	public Person searchByKey(String key) {
		Person p = map.get(key);
		if(p == null ) 
				throw new RuntimeException(key + "에 해당하는 정보는 없습니다.");
				
				return p;
		
			/**Person person = new Person();
		for( Entry<String, Person> me : map.entrySet()) {
			if(me.getKey()==key) {
				person = me.getValue();
			}
		}
		if(person.getId()==null) {
			throw new RuntimeException("id가 없어요.");
		}
		return person;*/
	}
	
	/**
	 * 등록하기
	 * 	: key(id로 관리한다)와 Person의 정보를 받아 등록하는 메소드
	 *        등록이 실패하면(id중복체크!!) 예외발생시킨다.("등록되지 않았습니다.")
	 * */
	public void insert(Person person) {//Student 또는 Person 가능하다
		if(map.containsKey(person.getId()))
			throw new RuntimeException(person.getId() + "는 중복이므로 등록할수 없습니다.");
		map.put(person.getId(),person);
		
			/**Person check = new Person();
			for( Entry<String, Person> me : map.entrySet()) {
				if(me.getKey()==person.getId()) {
					check = me.getValue();
				}
			}
			if(check.getId()!=null) {
				throw new RuntimeException("아이디 중복");
			}else {
				if((person instanceof Student)) {
					System.out.println("학생");
					Student student = (Student)person;
					map.put(student.getId(), student);
				}else {
					System.out.println("사람");
					map.put(person.getId(), person);
				}
			
			}*/
			
	}
	
	/**
	 * 삭제하기
	 *   : id(key)에 해당하는 value가 삭제되지 않으면 예외발생
	 *      (삭제되지 않았습니다.)
	 * */
	public void delete(String key) {
		Person person = map.remove(key); // 삭제가 되면 삭제된 value를 리턴해준다. 삭제 안되면 null
		
		if(person==null) {
			throw new RuntimeException(key + "에 해당하는 정보를 삭제할 수 없습니다.");
		}
		/**Person check = new Person();
		for( Entry<String, Person> me : map.entrySet()) {
			if(me.getKey()==key) {
				check = me.getValue();
			}
		}
		if(check.getId()==null) {
			throw new RuntimeException("없는 id 입니다.");
		}else {
			map.remove(key);
		}*/
	}
	
	/**
	 * 수정하기
	 *   만약, Person인경우 - 이름만 수정
	 *         Student인경우  - 이름, 국어 ,영어,수학수정(총점 변경)
	 *         
	 *    수정이 안된다면 예외발생
	 *    
	 * */
	public void update(Person person) {//아이디, 이름 추가적으로 국,영,수
		Person searchP = map.get(person.getId());
		if(searchP==null) //전달된 id에 해당하는 정보가 없다.
			throw new RuntimeException(person.getId()+ "는 잘못되어 수정할 수 없습니다.");
			
		//key에 해당하는 정보가 있으니 type이 일치하는지 체크	
			if((person instanceof Student)) {
				if(searchP instanceof Student) {
					//2)변경하고 싶다.
					Student searchSt = (Student)searchP;
					Student paramSt = (Student)person;
					
					searchSt.setName(paramSt.getName());
					searchSt.setKor(paramSt.getKor());
					searchSt.setEng(paramSt.getEng());
					searchSt.setMath(paramSt.getMath());
					
					//총점변경
					int sum = paramSt.getKor() + paramSt.getEng() + paramSt.getMath();
					
					searchSt.setSum(sum); //총점변경
					
				}else {
					//3) 타입오류
					throw new RuntimeException("타입 오류로 수정에 실패했습니다.");
				}
					
			}else {
				//이름 변경
				searchP.setName(person.getName());
			}
			
			
		
	}//메소드
		
		/**Person check = new Person();
		for( Entry<String, Person> me : map.entrySet()) {
			if(me.getKey()==person.getId()) {
				check = me.getValue();
			}
		}
		
		if((person instanceof Student)) {
			if(person.getClass()==check.getClass()) {
				System.out.println("같음");
				System.out.println("학생");
				Student student = (Student)person;
				System.out.println("=>"+student);
				map.replace(student.getId(),this.create(student.getId(),student.getName(),check.getAge(),student.getKor(),student.getEng(),student.getMath()));
				System.out.println("---수정 성공");
			}else {
				throw new RuntimeException("-----수정 실패");
			}
		}else {
			System.out.println("사람");
			map.replace(person.getId(), this.create(person.getId(),person.getName(),check.getAge()));
			System.out.println("---수정 성공");
		}*/
		
		
 
}
