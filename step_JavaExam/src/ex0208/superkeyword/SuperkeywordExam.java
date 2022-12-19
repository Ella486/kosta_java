package ex0208.superkeyword;

class Parent{
	int a=5;
	int b=10;
	public void aa() {
		System.out.println("Parent�� aa() ȣ���");
	}
	public void bb() {
		System.out.println("Parent�� bb() ȣ���");
	}
}
/////////////////////////////////////////////////////////////////
class Child extends Parent{
	int a=100;
	int c=50;
	
	@Override
	public void aa() {
		System.out.println("Child�� aa() ȣ���");
		
	}
	public void cc() {
		System.out.println("Child�� cc() ȣ���");
		
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
		//System.out.println(super.c); //�ڽſ��� �ִ� �ʵ带 super ������ �ȵ�
		
		System.out.println("---------�޼ҵ� ȣ��----------");
	
		aa();//�ڽĺκ�
		this.aa();//�ڽĺκ�
		super.aa();//�θ�κ�
		
		System.out.println("--------------------------------");
		bb();//�θ�κ�
		this.bb();//�θ�κ�
		super.bb();//�θ�κ�
		
		System.out.println("--------------------------------");
		cc();
		this.cc();
		//super.cc();//���� (���簴ü�� �ִ� �޼ҵ带 super�� ���ٺҰ�)
	}
	
	
}
///////////////////////////////////

public class SuperkeywordExam {

	public static void main(String[] args) {
		//new Child().dd();

		Child ch = new Child();
		System.out.println("ch: " + ch); //ch.toString()
		
		System.out.println("------�ʵ� ����--------------");
		System.out.println(ch.a);//100
		System.out.println(ch.b);//10
		System.out.println(ch.c);//50
		
		System.out.println("------�޼ҵ� ����--------------");
		ch.aa();
		ch.bb();
		ch.cc();
		
		System.out.println("--------------------");
		Parent p = new Child(); //������ //p������ Parent�κи� ���ٰ���
		System.out.println("p: " + p);
		
		System.out.println("------�ʵ� ����--------------");
		System.out.println(p.a);//5
		System.out.println(p.b);//10
		//System.out.println(p.c);//�ڽ��ʵ� ���� �Ұ�!
		
		System.out.println("------�޼ҵ� ����--------------");
		p.aa(); // �ڽĺκ��� aa ȣ�� (�����ǵ� �޼ҵ�� �θ�Ÿ���̶� �����ǵ� �޼ҵ尡 ȣ���)
		p.bb();
		//p.cc(); //�ڽĸ޼ҵ带 �θ�Ÿ�Ժ����� ���ٺҰ�!
		
		System.out.println("------ĳ��������--------------");
		//Parent Ÿ���� p �������� Child�κ��� �ֱ� ������ ĳ������ �ؼ� �ڽĺκ��� ���ٰ����ϵ��� �� �� ����.
		if(p instanceof Child) {
		Child ch2 = (Child)p;//�θ� >�ڽ�
		
		System.out.println("ch2: " + ch2);
		System.out.println(ch2.c);
		ch2.cc();
		}
		
		System.out.println("*********���ǻ���****************");
		Parent p2 = new Parent();
		System.out.println("p2: " + p2);
		System.out.println(p2.a);
		System.out.println(p2.b);
		//System.out.println(p2.c);
		
		if(p2 instanceof Child) {
		Child ch3 = (Child)p2;//�ȵȴ�.!!!!
		System.out.println(ch3.c);
		
		}
		
	}

}
