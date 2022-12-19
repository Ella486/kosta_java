package ex0211;

public class VariableArgsExam {
	public void aa(int ... i) { //배열처럼 사용된다.
		System.out.println("i.length =" + i.length);
		
		
		for(int a :i) {
			System.out.print( a + "\t");
			
		}
		
			
		System.out.println("\n-------------------------------");
		
	}
	
	public void bb(Object ... obj) {//모든 타입과 0개이상을 허용하고 싶다.
		for(Object a: obj) {
			System.out.print( a + "\t");
		}
		
		System.out.println("\n-------------------------------");
	}
	
	//The variable argument type String of the method cc must be the last parameter
	public void cc(String name, int...i) {
		
	}
	
	
	public static void main(String[] args) {
		VariableArgsExam va = new VariableArgsExam();
		
		va.aa();
		va.aa(4);
		va.aa(4,5,6,7);
		va.aa(4,5,6,7,8,9,1);
		
		System.out.println("******************************");
		va.bb(2);
		va.bb("안녕","반가워", true, 2.2);
		va.bb(false,4,5,5f);
		
		System.out.println("******************************");
		va.cc("dd", 3);
		va.cc("22", 4,5,6,7,7);
		
		int kor = 80, eng = 90;
		
		System.out.printf("이름: 장희정");
		System.out.printf("국어: %d %d", kor, eng);
		
		

	}

}
