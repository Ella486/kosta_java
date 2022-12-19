package ex0211;
import java.util.ArrayList;
import static java.lang.System.out; // �� import�� ���ָ� out.print();�� ���൵ �����ȶ�

class Test{
	int a=5;
	public void aa() {}
	
	/**@Override
	public String toString() {
		
		return "�������";
	}*/
}
///////////////////////////////////////////////////////////
class ArrayListExam extends ArrayList<Object>{//10������

	//���� Variable
	//Object Ÿ��1��, int Ÿ�� 1��;
	Object obj;
	int i;

	//Constractor
	public ArrayListExam(){
		super(5);	//�ʱ� �뷮 5�� ����
		
			
	}

	//method
	//method�̸�			����Ÿ��		�μ�						
	
	/*addInt				����			����(int)1��				
	�ϴ��� : �μ��� ���� ������ ��ü�� ����� list�� �߰�.*/
	public void addInt(int i) {
		//Integer it = new Integer(i);
		//super.add(it);
		
		super.add(i); //i�� ��ü�� ��ȯ�ؼ� �����Ѵ�.(����ڽ�)
		
		//int a = new Integer(5);
		
		//Integer it = new Integer(55);
		//int b = it;
		
		
	}
		
	
	
	/*addFloat				����			�Ǽ�(float)1��			
		�ϴ��� : �μ��� ���� �Ǽ��� ��ü�� ����� list�� �߰�.*/
	public void addFloat(float f) {
		this.add(new Float(f));
		
	}
	
	
	/*addString			����			String ���ڿ�1��		
		�ϴ��� : �μ��� ���� String �� list�� �߰�.*/
	public void addString(String s) {
		add(s); //super. , this. ����
		
		Test t = new Test();
		add(t);
	}	
	
	
	
	/*printList		����			����			
		������ ���������� ���� list�� ����ִ� ��ü�� ���� �Է��� �� �������� ���.
		List�� ����� �� ��ü�� �ɹ������� �������� ���*/
	public void printList() {
		this.i = super.size();
		System.out.println("list�� ����ִ� ��ü�� �� ������ " + this.i);
		for(int index=0; index < this.i ; index++) {
			this.obj = super.get(index);
			System.out.println(this.obj); //
		}
		
		System.out.println("-------------------------");
		this.obj = super.get(3);
		if(this.obj instanceof Test) {
			Test t = (Test)obj;
			System.out.println("obj = " + obj);
			System.out.println("t = " + t);
			
			System.out.println("t.a = " + t.a);
		}
		
		Integer i = (Integer)super.get(0);
		System.out.println("i=" + i);
		
		System.out.println("------------������ for������ �����غ���----------");
		for(Object o : this) {//super X, this O
		out.println(o); //super.get(index) ��� ����
		}
		
	}	
		

	public static void main(String args[]){
		ArrayListExam list = new ArrayListExam();
		String s = new String("newString");		 
		list.addInt(5);
		list.addFloat(5.5F);
		list.addString(s);
		list.printList();
	}
}

/*������

list�� ����ִ� ��ü�� �� ������=3
5
5.5
newString

Normal Termination
��� �Ϸ� (0�� ���).
*/