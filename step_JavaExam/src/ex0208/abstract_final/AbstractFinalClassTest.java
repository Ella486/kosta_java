package ex0208.abstract_final;
/**
본인이름: 이명진
날짜: 22.02.08
주제 : Abstract,Final 실습예제
*/

//Error 를 수정하고 이유를 주석으로 처리하세요.

final class FinalClassExam{//상속불가, 생성가능
 final int i = -999999; //값변불가! - 값을 반드시 초기화 필수, 명시적 초기화 또는 생성자를 이용해서 초기화
}


abstract class AbstractClassExam{//상속가능, 생성불가
    abstract String abstractMethodExam(int i,String s); //기능 없는 상태, 재정의를 해서 사용
    
	final int finalMethodExam(int i, int j){ //재정의 불가
        return i+j;
    }
}
///////////////////////////////////////////////////////////////////////////

class Sample01 extends AbstractClassExam{
	String abstractMethodExam(int i,String s){
		System.out.println("return "+s+i);
		return s+i;
	}
	                                       //final 메소드는 재정의 불가
	/** int finalMethodExam(int i, int j){ // finalMethodExam 메소드 앞에 final이 있으므로 재정의(오버라이딩) 될 수 없다.
		return i*j;
	}*/
	
}
////////////////////////////////////////////////////////
class Sample02 /*extends FinalClassExam*/{  } //FinalClassExam 클래스 앞에 final이 있으므로 상속 할 수 없다.

///////////////////////////////////////////////////////////////
/**AbstractClassExam 클래스 앞에 abstract가 붙었으므로 상속 받는 Sample03 클래스는 abstract메소드를 재정의해야하지만
재정의 되지 않았으므로 앞에 abstract를 붙여준다.*/
 class Sample03 extends AbstractClassExam{
	@Override
	 String abstractMethodExam(int i,String s){
		 return s+i;
	 }
	 //abstract String abstractMethodExam(int i,String s); //Sample03 클래스 안에 이미 재정의된 메소드가 존재함.

	void sampleMethod03(){
		System.out.println("void sampleMethod03() 호출 됨");
	}
}

class AbstractFinalClassTest{
    public static void main(String args[]){
		//AbstractClassExam ace = new AbstractClassExam(); //abstract 클래스는 new 연산자로 직접 생성자 호출 불가
		FinalClassExam fce = new FinalClassExam();
		//fce.i=100000; //i는 FinalClassExam의 final 필드로 고정되었기 때문에 값 변경이 불가
		Sample01 s01 = new Sample01();
		AbstractClassExam aceS01 = new Sample01();
		aceS01.abstractMethodExam(700,"_999");
	}
}
