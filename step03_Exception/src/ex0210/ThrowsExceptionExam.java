package ex0210;

public class ThrowsExceptionExam {
	public void aa(int i) throws ArithmeticException {
		System.out.println("aa 메소드 호출됨....");
		//try {
			this.bb(i);
		
		//}catch(ArithmeticException e) {
		//	System.out.println("예외가 발생했어요!");
		//}

		System.out.println("aa 메소드 호출 완료됨....");
		
	}
	 
	public void bb(int i) throws ArithmeticException , NumberFormatException{
		System.out.println("bb 메소드 호출됨....");
		try {
			//try {
				
			int result = 100/i; //ArithmeticException
			System.out.println("나눈결과 : " + result);
			//}catch(ArithmeticException e) {
				//System.out.println("0으로 나누면 안돼요!!");
			//}
		}finally {
		System.out.println("bb 메소드 호출 완료됨....");
		}
	}
	

	public static void main(String[] args) throws ArithmeticException {
		System.out.println("***메인 시작합니다*******");
		ThrowsExceptionExam te = new ThrowsExceptionExam();
		//te.aa(2);
		//try {
			te.aa(0);
		//}catch(ArithmeticException e) {
		//	e.printStackTrace();
		//}
		
		System.out.println("***메인 끝*******");

	}

}
