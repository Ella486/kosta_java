package ex0210;

import java.io.IOException;

class Test2{
	public void ageCheck(int age)throws IOException {
		if(age <= 0) {
			//�߸��ƴ�!!
			IOException ioe = new IOException("���̴� ������ �ȵſ�!!!"); //üũ��������
			//try {	
				throw ioe;
			
			//}catch(IOException e) {
			//	
			//}
		}else {
			System.out.println(age + "�� �� ȯ���մϴ�.");
		}
	}
	
}
////////////////////////////////////////////////////////////////////////
public class ThrowExam2 {

	public static void main(String[] args) throws IOException {
		System.out.println("**********���� �����մϴ�**********");
		
		Test2 t = new Test2();
		//try{
			t.ageCheck(-5);
		//}catch(IOException e) {
		
		//}
		System.out.println("**********���� �����մϴ�**********");
	}

}
