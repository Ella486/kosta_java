package ex0217.lamda;

public class LamdaTest {

	
	public static void main(String[] args) {
		//���� �ڵ� �����
		/*AInterface ai = new AInterfaceImpl();
		ai.aa();*/
		
		//���ٽ�ǥ�� ����
		AInterface ai = () ->{
			System.out.println("AInterfaceImpl�� aa() ȣ���");
		};
		
		ai.aa();
		////////////////////////////////////////////////////
		BInterface bi = (a)->{
			System.out.println("�μ��� ���� �� �� : " + a);
		};
		
		bi.bb(6);
		bi.bb(50);
		////////////////////////////////////
		System.out.println("--------------------------------");
		CInterface ci =(a,b)->{
			System.out.println(a + "��" + b + "�� ���ؼ� �����ҰԿ�");
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
		System.out.println("AInterfaceImpl�� aa() ȣ���");
	}
	
	
}*/