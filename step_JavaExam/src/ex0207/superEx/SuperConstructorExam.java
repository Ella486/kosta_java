package ex0207.superEx;

class Parent{
	/*Parent(){
		System.out.println("Parent() 기본생성자 -1");
	}*/
	Parent(int i){
		System.out.println("Parent(int i) 기본생성자-2");
	}
	Parent(String s){
		System.out.println("Parent(String s) 기본생성자-3");
	}
}
//////////////////////////////////////////////////////////
class Child extends Parent{
	Child(){
		//super();
		this(5);
		System.out.println("Child() 기본생성자-4");
	}
	Child(int i){
		//super();
		super(i);
		System.out.println("Child(int i) 생성자-5");
	}
	Child(boolean b){
		//super();
		super("안녕");
		System.out.println("Child(blooean b) 생성자-6");
	}
}

/////////////////////////////////////////////////

public class SuperConstructorExam {

	public static void main(String[] args) {
		// new Child(); //1, 4
		// new Child(10); //1, 5
		//new Child(true); //1, 6
		
		//만약 1,2,3 없다면 - 부모가 생성자 한개도 작성하지 않았다면
		new Child();
		new Child(10);
	}

}
