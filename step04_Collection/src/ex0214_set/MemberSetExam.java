package ex0214_set;

import java.util.HashSet;
import java.util.Set;

public class MemberSetExam {
	Set<Member> set = new HashSet<Member>();
	public MemberSetExam() {
		//�߰�
		//add�޼ҵ�� ���� �����Ϸ��� ��ü�� hashCode()�� ȣ���ؼ� ���ϰ� �ٸ��� �����Ѵ�.
		//								��ü�� hashCode()�� ȣ���ؼ� ���ϰ� ������ 
		//									equals()ȣ���ؼ� true �����ϸ� �ߺ�, false �����ϸ� 
		set.add(new Member("����", 10, "����"));
		System.out.println("------------------------------------");
		set.add(new Member("����", 13, "�뱸"));
		System.out.println("------------------------------------");
		set.add(new Member("����", 10, "����"));
		System.out.println("------------------------------------");
		set.add(new Member("����", 14, "����"));
		
		
		//
		System.out.println("����� ����: " + set.size());
	}
	
	
	public static void main(String[] args) {
		new  MemberSetExam();

	}

}
