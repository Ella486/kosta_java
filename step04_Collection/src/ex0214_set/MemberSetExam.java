package ex0214_set;

import java.util.HashSet;
import java.util.Set;

public class MemberSetExam {
	Set<Member> set = new HashSet<Member>();
	public MemberSetExam() {
		//추가
		//add메소드는 먼저 저장하려는 객체의 hashCode()를 호출해서 비교하고 다르면 저장한다.
		//								객체의 hashCode()를 호출해서 비교하고 같으면 
		//									equals()호출해서 true 리턴하면 중복, false 리턴하면 
		set.add(new Member("희정", 10, "서울"));
		System.out.println("------------------------------------");
		set.add(new Member("나영", 13, "대구"));
		System.out.println("------------------------------------");
		set.add(new Member("희정", 10, "서울"));
		System.out.println("------------------------------------");
		set.add(new Member("희정", 14, "서울"));
		
		
		//
		System.out.println("저장된 개수: " + set.size());
	}
	
	
	public static void main(String[] args) {
		new  MemberSetExam();

	}

}
