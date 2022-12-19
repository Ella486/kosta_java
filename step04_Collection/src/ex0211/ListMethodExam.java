package ex0211;

import java.util.ArrayList;
import java.util.List;

public class ListMethodExam {
	List<String> list = new ArrayList<String>(5);
	
	/**
	 * ������ �߰�
	 * */
	public void addList(String [] args) {
		list.add("�׽�Ʈ");
		for(String name : args) {
			//����Ʈ�� �ֱ�
			if(!list.contains(name)) {
			list.add(name); //�����߰�
			//list.add(0,name); //������ 0������ �߰�
			
			//list.set(0.name); //0������ �ִ� ������ ��ü
			}
		}
	}
	
	
	/**
	 * ������ ���
	 * */
	public void printList() {
		System.out.println("------List �׸� (" +list.size() +"��)------------");
		for(int i=0; i<list.size(); i++) {
			String s = list.get(i);
			System.out.println(s);
		}
		
		System.out.println("---�����غ���----");
		list.remove(2);
		
		System.out.println("-------���� �� ��-----------------");
		System.out.println(list.toString());//list.toString()ȣ��

	}
	
	

	
	public static void main(String[] args) {
		ListMethodExam lm = new ListMethodExam();
		lm.addList(args);
		lm.printList();

	}

}
