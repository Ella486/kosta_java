package ex0211;
import java.util.ArrayList;
import static java.lang.System.out; // 이 import를 해주면 out.print();만 써줘도 오류안뜸

class Test{
	int a=5;
	public void aa() {}
	
	/**@Override
	public String toString() {
		
		return "배고프다";
	}*/
}
///////////////////////////////////////////////////////////
class ArrayListExam extends ArrayList<Object>{//10개공간

	//전역 Variable
	//Object 타입1개, int 타입 1개;
	Object obj;
	int i;

	//Constractor
	public ArrayListExam(){
		super(5);	//초기 용량 5개 생성
		
			
	}

	//method
	//method이름			리턴타입		인수						
	
	/*addInt				없음			정수(int)1개				
	하는일 : 인수로 받은 정수를 객체로 만들어 list에 추가.*/
	public void addInt(int i) {
		//Integer it = new Integer(i);
		//super.add(it);
		
		super.add(i); //i를 객체로 변환해서 저장한다.(오토박싱)
		
		//int a = new Integer(5);
		
		//Integer it = new Integer(55);
		//int b = it;
		
		
	}
		
	
	
	/*addFloat				없음			실수(float)1개			
		하는일 : 인수로 받은 실수를 객체로 만들어 list에 추가.*/
	public void addFloat(float f) {
		this.add(new Float(f));
		
	}
	
	
	/*addString			없음			String 문자열1개		
		하는일 : 인수로 받은 String 을 list에 추가.*/
	public void addString(String s) {
		add(s); //super. , this. 생략
		
		Test t = new Test();
		add(t);
	}	
	
	
	
	/*printList		없음			없음			
		정수형 전역변수에 현재 list에 들어있는 객체의 개수 입력한 후 전역변수 출력.
		List에 저장된 각 객체를 맴버변수에 저장한후 출력*/
	public void printList() {
		this.i = super.size();
		System.out.println("list에 들어있는 객체의 총 개수는 " + this.i);
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
		
		System.out.println("------------개선된 for문으로 변경해보자----------");
		for(Object o : this) {//super X, this O
		out.println(o); //super.get(index) 대신 해줌
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

/*실행결과

list에 들어있는 객체의 총 개수는=3
5
5.5
newString

Normal Termination
출력 완료 (0초 경과).
*/