package ex0210;

public class ThrowsExceptionExam {
	public void aa(int i) throws ArithmeticException {
		System.out.println("aa �޼ҵ� ȣ���....");
		//try {
			this.bb(i);
		
		//}catch(ArithmeticException e) {
		//	System.out.println("���ܰ� �߻��߾��!");
		//}

		System.out.println("aa �޼ҵ� ȣ�� �Ϸ��....");
		
	}
	 
	public void bb(int i) throws ArithmeticException , NumberFormatException{
		System.out.println("bb �޼ҵ� ȣ���....");
		try {
			//try {
				
			int result = 100/i; //ArithmeticException
			System.out.println("������� : " + result);
			//}catch(ArithmeticException e) {
				//System.out.println("0���� ������ �ȵſ�!!");
			//}
		}finally {
		System.out.println("bb �޼ҵ� ȣ�� �Ϸ��....");
		}
	}
	

	public static void main(String[] args) throws ArithmeticException {
		System.out.println("***���� �����մϴ�*******");
		ThrowsExceptionExam te = new ThrowsExceptionExam();
		//te.aa(2);
		//try {
			te.aa(0);
		//}catch(ArithmeticException e) {
		//	e.printStackTrace();
		//}
		
		System.out.println("***���� ��*******");

	}

}
