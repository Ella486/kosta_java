package ex0214_set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

//public class SetExam extends HashSet<String>{//HashSet은 중복이 안되고 순서 없다.
public class SetExam extends TreeSet<String>{//TreeSet은 중복이 안되고 요소가 정렬이 된다.
	public SetExam() {
		//super(5);//5개공간
	}
	
	/**
	 * 추가
	 * */
	public void addSet(String[] args) {
		for(String name : args) {
			//set
			boolean result = super.add(name);
			System.out.println(name + "추가결과: " + result );
		}
		
		System.out.println("추가된 개수: " + super.size());
		System.out.println(this);
		////////////////////////////////////////
		System.out.println("------------------------------------");
		/**
		 * set안에 있는 요소를 하나씩 꺼내기
		 * */
		Iterator<String> it = super.iterator();
		while(it.hasNext()) {// 요소가 더 존재 하는 지 체크
			String name = it.next(); //요소를 꺼내기.
			System.out.println(name);
		}
		
		System.out.println("------------개선된 for문------------");
		for(String name : this) {
			System.out.println(name);
		}
		
		System.out.println("---------------------------------");
		boolean result = this.remove("나영");
		System.out.println("result:" + result);
		System.out.println(this);
		
	}
	

	public static void main(String[] args) {
		SetExam se = new SetExam();
		se.addSet(args);

	}

}
