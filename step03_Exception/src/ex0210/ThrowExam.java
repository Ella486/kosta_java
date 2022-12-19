package ex0210;

import java.io.IOException;

class Test{
	public void ageCheck(int age) {
		if(age <= 0) {
			//잘못됐다!!
			//IOException ioe = new IOException("나이는 음수가 안돼요!!!"); //체크예외종류
			
			RuntimeException ioe = new RuntimeException("나이는 음수가 안돼요!!");//비체크예외종류
					
			throw ioe;
			
		}else {
			System.out.println(age + "살 님 환영합니다.");
		}
	}
	
}
////////////////////////////////////////////////////////////////////////
public class ThrowExam {

	public static void main(String[] args) {
		System.out.println("**********메인 시작합니다**********");
		
		Test t = new Test();
		try {
			t.ageCheck(-5);
		}catch(RuntimeException e) {
			System.out.println(e.getMessage() + "\n");
		}
		
		System.out.println("**********메인 종료합니다**********");
	}

}
