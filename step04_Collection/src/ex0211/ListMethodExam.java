package ex0211;

import java.util.ArrayList;
import java.util.List;

public class ListMethodExam {
	List<String> list = new ArrayList<String>(5);
	
	/**
	 * 데이터 추가
	 * */
	public void addList(String [] args) {
		list.add("테스트");
		for(String name : args) {
			//리스트에 넣기
			if(!list.contains(name)) {
			list.add(name); //끝에추가
			//list.add(0,name); //무조건 0번지에 추가
			
			//list.set(0.name); //0번지에 있느 정보를 교체
			}
		}
	}
	
	
	/**
	 * 데이터 출력
	 * */
	public void printList() {
		System.out.println("------List 항목 (" +list.size() +"개)------------");
		for(int i=0; i<list.size(); i++) {
			String s = list.get(i);
			System.out.println(s);
		}
		
		System.out.println("---제거해보자----");
		list.remove(2);
		
		System.out.println("-------제거 된 후-----------------");
		System.out.println(list.toString());//list.toString()호출

	}
	
	

	
	public static void main(String[] args) {
		ListMethodExam lm = new ListMethodExam();
		lm.addList(args);
		lm.printList();

	}

}
