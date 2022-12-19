package ex0214_set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

//public class SetExam extends HashSet<String>{//HashSet�� �ߺ��� �ȵǰ� ���� ����.
public class SetExam extends TreeSet<String>{//TreeSet�� �ߺ��� �ȵǰ� ��Ұ� ������ �ȴ�.
	public SetExam() {
		//super(5);//5������
	}
	
	/**
	 * �߰�
	 * */
	public void addSet(String[] args) {
		for(String name : args) {
			//set
			boolean result = super.add(name);
			System.out.println(name + "�߰����: " + result );
		}
		
		System.out.println("�߰��� ����: " + super.size());
		System.out.println(this);
		////////////////////////////////////////
		System.out.println("------------------------------------");
		/**
		 * set�ȿ� �ִ� ��Ҹ� �ϳ��� ������
		 * */
		Iterator<String> it = super.iterator();
		while(it.hasNext()) {// ��Ұ� �� ���� �ϴ� �� üũ
			String name = it.next(); //��Ҹ� ������.
			System.out.println(name);
		}
		
		System.out.println("------------������ for��------------");
		for(String name : this) {
			System.out.println(name);
		}
		
		System.out.println("---------------------------------");
		boolean result = this.remove("����");
		System.out.println("result:" + result);
		System.out.println(this);
		
	}
	

	public static void main(String[] args) {
		SetExam se = new SetExam();
		se.addSet(args);

	}

}
