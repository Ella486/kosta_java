package ex0207.superEx;

class Parent{
	/*Parent(){
		System.out.println("Parent() �⺻������ -1");
	}*/
	Parent(int i){
		System.out.println("Parent(int i) �⺻������-2");
	}
	Parent(String s){
		System.out.println("Parent(String s) �⺻������-3");
	}
}
//////////////////////////////////////////////////////////
class Child extends Parent{
	Child(){
		//super();
		this(5);
		System.out.println("Child() �⺻������-4");
	}
	Child(int i){
		//super();
		super(i);
		System.out.println("Child(int i) ������-5");
	}
	Child(boolean b){
		//super();
		super("�ȳ�");
		System.out.println("Child(blooean b) ������-6");
	}
}

/////////////////////////////////////////////////

public class SuperConstructorExam {

	public static void main(String[] args) {
		// new Child(); //1, 4
		// new Child(10); //1, 5
		//new Child(true); //1, 6
		
		//���� 1,2,3 ���ٸ� - �θ� ������ �Ѱ��� �ۼ����� �ʾҴٸ�
		new Child();
		new Child(10);
	}

}
