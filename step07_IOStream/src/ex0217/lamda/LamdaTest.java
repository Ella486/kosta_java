package ex0217.lamda;

public class LamdaTest {

	
	public static void main(String[] args) {
		//원래 코딩 방식을
		/*AInterface ai = new AInterfaceImpl();
		ai.aa();*/
		
		//람다식표현 변경
		AInterface ai = () ->{
			System.out.println("AInterfaceImpl의 aa() 호출됨");
		};
		
		ai.aa();
		////////////////////////////////////////////////////
		BInterface bi = (a)->{
			System.out.println("인수로 전달 된 값 : " + a);
		};
		
		bi.bb(6);
		bi.bb(50);
		////////////////////////////////////
		System.out.println("--------------------------------");
		CInterface ci =(a,b)->{
			System.out.println(a + "와" + b + "를 곱해서 리턴할게요");
			return a*b;
		};
		
		int re = ci.cc(5, 4);
		System.out.println("re: " + re);
	}

}
/////////////////////////

/*class AInterfaceImpl implements AInterface{
	@Override
	public aa() {
		System.out.println("AInterfaceImpl의 aa() 호출됨");
	}
	
	
}*/