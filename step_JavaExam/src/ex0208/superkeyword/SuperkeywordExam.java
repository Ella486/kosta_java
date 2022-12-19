package ex0208.superkeyword;

class Parent{
	int a=5;
	int b=10;
	public void aa() {
		System.out.println("Parent의 aa() 호출됨");
	}
	public void bb() {
		System.out.println("Parent의 bb() 호출됨");
	}
}
/////////////////////////////////////////////////////////////////
class Child extends Parent{
	int a=100;
	int c=50;
	
	@Override
	public void aa() {
		System.out.println("Child의 aa() 호출됨");
		
	}
	public void cc() {
		System.out.println("Child의 cc() 호출됨");
		
	}
	public void dd() {
		System.out.println(a); //100
		System.out.println(this.a); //100
		System.out.println(super.a);//5
		
		System.out.println("--------------------------------");
		System.out.println(b); //10
		System.out.println(this.b); //10
		System.out.println(super.b); //10
		
		System.out.println("--------------------------------");
		System.out.println(c); //
		System.out.println(this.c);//
		//System.out.println(super.c); //자신에게 있는 필드를 super 접근이 안됨
		
		System.out.println("---------메소드 호출----------");
	
		aa();//자식부분
		this.aa();//자식부분
		super.aa();//부모부분
		
		System.out.println("--------------------------------");
		bb();//부모부분
		this.bb();//부모부분
		super.bb();//부모부분
		
		System.out.println("--------------------------------");
		cc();
		this.cc();
		//super.cc();//에러 (현재객체에 있는 메소드를 super로 접근불가)
	}
	
	
}
///////////////////////////////////

public class SuperkeywordExam {

	public static void main(String[] args) {
		//new Child().dd();

		Child ch = new Child();
		System.out.println("ch: " + ch); //ch.toString()
		
		System.out.println("------필드 접근--------------");
		System.out.println(ch.a);//100
		System.out.println(ch.b);//10
		System.out.println(ch.c);//50
		
		System.out.println("------메소드 접근--------------");
		ch.aa();
		ch.bb();
		ch.cc();
		
		System.out.println("--------------------");
		Parent p = new Child(); //다형성 //p변수로 Parent부분만 접근가능
		System.out.println("p: " + p);
		
		System.out.println("------필드 접근--------------");
		System.out.println(p.a);//5
		System.out.println(p.b);//10
		//System.out.println(p.c);//자식필드 접근 불가!
		
		System.out.println("------메소드 접근--------------");
		p.aa(); // 자식부분의 aa 호출 (재정의된 메소드는 부모타입이라도 재정의된 메소드가 호출됨)
		p.bb();
		//p.cc(); //자식메소드를 부모타입변수로 접근불가!
		
		System.out.println("------캐스팅하자--------------");
		//Parent 타입의 p 변수에는 Child부분이 있기 때문에 캐스팅을 해서 자식부분을 접근가능하도록 할 수 있음.
		if(p instanceof Child) {
		Child ch2 = (Child)p;//부모 >자식
		
		System.out.println("ch2: " + ch2);
		System.out.println(ch2.c);
		ch2.cc();
		}
		
		System.out.println("*********주의사항****************");
		Parent p2 = new Parent();
		System.out.println("p2: " + p2);
		System.out.println(p2.a);
		System.out.println(p2.b);
		//System.out.println(p2.c);
		
		if(p2 instanceof Child) {
		Child ch3 = (Child)p2;//안된다.!!!!
		System.out.println(ch3.c);
		
		}
		
	}

}
