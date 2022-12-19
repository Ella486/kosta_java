package ex0214.map.exam;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapStudentService {
	private Map<String, Person> map = new HashMap<String, Person>();
	
	/**
	 * �����ڸ� �̿��ؼ� map �� �ʱ�ġ������ ����
	 * */
	public MapStudentService() {
		//Map�� �߰�
		map.put("jang", this.create("jang", "������", 20));//Person
		map.put("hee", this.create("hee", "����", 25));//Person
		
		map.put("king", this.create("king", "���߱�", 30, 80, 90, 40));//Student
		map.put("girl", this.create("girl", "�����", 22, 90, 95, 90));//Student
		map.put("queen", this.create("queen", "��ҿ�", 35, 70, 90, 85));//Student
	}
	
	/**
	 * Student �Ǵ� Person�� �����ؼ� �������ִ� �޼ҵ�
	 * */
	public Person create(String id, String name, int age, int ...params) {
		if(params.length==0) {
			return new Person(id,name,age);
			
		}else if(params.length==3) {
			return new Student(id,name,age,params[0],params[1],params[2]);
		}else {
			throw new RuntimeException("���޵� �μ��� �߸��Ǿ� ������ �� �����");
		}
		
		
	}
	
	
	/**
	 * ��ü�˻�
	 * */
	public Map<String, Person> selectAll(){
		if(map.isEmpty() || map.size()==0) {
			throw new RuntimeException("����� ������ �����ϴ�.");
		}
		return map;
	}
	
	/**
	 * key�� �ش��ϴ� ���� �˻��ϱ�
	 *  key�� �ش��ϴ� ���� �˻�
	 *   :key�ش��ϴ� ������ ����Ҷ� 
	 *    [ Person�ΰ��� �̸��� ���
	 *     Student�ΰ��� �̸��� ���� ��� ] -> EndView���� 
	 *     ���°��� "id�� �����ϴ�." ���ܹ߻�
	 * */
	public Person searchByKey(String key) {
		Person p = map.get(key);
		if(p == null ) 
				throw new RuntimeException(key + "�� �ش��ϴ� ������ �����ϴ�.");
				
				return p;
		
			/**Person person = new Person();
		for( Entry<String, Person> me : map.entrySet()) {
			if(me.getKey()==key) {
				person = me.getValue();
			}
		}
		if(person.getId()==null) {
			throw new RuntimeException("id�� �����.");
		}
		return person;*/
	}
	
	/**
	 * ����ϱ�
	 * 	: key(id�� �����Ѵ�)�� Person�� ������ �޾� ����ϴ� �޼ҵ�
	 *        ����� �����ϸ�(id�ߺ�üũ!!) ���ܹ߻���Ų��.("��ϵ��� �ʾҽ��ϴ�.")
	 * */
	public void insert(Person person) {//Student �Ǵ� Person �����ϴ�
		if(map.containsKey(person.getId()))
			throw new RuntimeException(person.getId() + "�� �ߺ��̹Ƿ� ����Ҽ� �����ϴ�.");
		map.put(person.getId(),person);
		
			/**Person check = new Person();
			for( Entry<String, Person> me : map.entrySet()) {
				if(me.getKey()==person.getId()) {
					check = me.getValue();
				}
			}
			if(check.getId()!=null) {
				throw new RuntimeException("���̵� �ߺ�");
			}else {
				if((person instanceof Student)) {
					System.out.println("�л�");
					Student student = (Student)person;
					map.put(student.getId(), student);
				}else {
					System.out.println("���");
					map.put(person.getId(), person);
				}
			
			}*/
			
	}
	
	/**
	 * �����ϱ�
	 *   : id(key)�� �ش��ϴ� value�� �������� ������ ���ܹ߻�
	 *      (�������� �ʾҽ��ϴ�.)
	 * */
	public void delete(String key) {
		Person person = map.remove(key); // ������ �Ǹ� ������ value�� �������ش�. ���� �ȵǸ� null
		
		if(person==null) {
			throw new RuntimeException(key + "�� �ش��ϴ� ������ ������ �� �����ϴ�.");
		}
		/**Person check = new Person();
		for( Entry<String, Person> me : map.entrySet()) {
			if(me.getKey()==key) {
				check = me.getValue();
			}
		}
		if(check.getId()==null) {
			throw new RuntimeException("���� id �Դϴ�.");
		}else {
			map.remove(key);
		}*/
	}
	
	/**
	 * �����ϱ�
	 *   ����, Person�ΰ�� - �̸��� ����
	 *         Student�ΰ��  - �̸�, ���� ,����,���м���(���� ����)
	 *         
	 *    ������ �ȵȴٸ� ���ܹ߻�
	 *    
	 * */
	public void update(Person person) {//���̵�, �̸� �߰������� ��,��,��
		Person searchP = map.get(person.getId());
		if(searchP==null) //���޵� id�� �ش��ϴ� ������ ����.
			throw new RuntimeException(person.getId()+ "�� �߸��Ǿ� ������ �� �����ϴ�.");
			
		//key�� �ش��ϴ� ������ ������ type�� ��ġ�ϴ��� üũ	
			if((person instanceof Student)) {
				if(searchP instanceof Student) {
					//2)�����ϰ� �ʹ�.
					Student searchSt = (Student)searchP;
					Student paramSt = (Student)person;
					
					searchSt.setName(paramSt.getName());
					searchSt.setKor(paramSt.getKor());
					searchSt.setEng(paramSt.getEng());
					searchSt.setMath(paramSt.getMath());
					
					//��������
					int sum = paramSt.getKor() + paramSt.getEng() + paramSt.getMath();
					
					searchSt.setSum(sum); //��������
					
				}else {
					//3) Ÿ�Կ���
					throw new RuntimeException("Ÿ�� ������ ������ �����߽��ϴ�.");
				}
					
			}else {
				//�̸� ����
				searchP.setName(person.getName());
			}
			
			
		
	}//�޼ҵ�
		
		/**Person check = new Person();
		for( Entry<String, Person> me : map.entrySet()) {
			if(me.getKey()==person.getId()) {
				check = me.getValue();
			}
		}
		
		if((person instanceof Student)) {
			if(person.getClass()==check.getClass()) {
				System.out.println("����");
				System.out.println("�л�");
				Student student = (Student)person;
				System.out.println("=>"+student);
				map.replace(student.getId(),this.create(student.getId(),student.getName(),check.getAge(),student.getKor(),student.getEng(),student.getMath()));
				System.out.println("---���� ����");
			}else {
				throw new RuntimeException("-----���� ����");
			}
		}else {
			System.out.println("���");
			map.replace(person.getId(), this.create(person.getId(),person.getName(),check.getAge()));
			System.out.println("---���� ����");
		}*/
		
		
 
}
