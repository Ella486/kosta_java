package ex0210;

import java.io.IOException;

class Test2{
	public void ageCheck(int age)throws IOException {
		if(age <= 0) {
			//잘못됐다!!
			IOException ioe = new IOException("나이는 음수가 안돼요!!!"); //체크예외종류
			//try {	
				throw ioe;
			
			//}catch(IOException e) {
			//	
			//}
		}else {
			System.out.println(age + "살 님 환영합니다.");
		}
	}
	
}
////////////////////////////////////////////////////////////////////////
public class ThrowExam2 {

	public static void main(String[] args) throws IOException {
		System.out.println("**********메인 시작합니다**********");
		
		Test2 t = new Test2();
		//try{
			t.ageCheck(-5);
		//}catch(IOException e) {
		
		//}
		System.out.println("**********메인 종료합니다**********");
	}

}
