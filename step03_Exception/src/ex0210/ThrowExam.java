package ex0210;

import java.io.IOException;

class Test{
	public void ageCheck(int age) {
		if(age <= 0) {
			//�߸��ƴ�!!
			//IOException ioe = new IOException("���̴� ������ �ȵſ�!!!"); //üũ��������
			
			RuntimeException ioe = new RuntimeException("���̴� ������ �ȵſ�!!");//��üũ��������
					
			throw ioe;
			
		}else {
			System.out.println(age + "�� �� ȯ���մϴ�.");
		}
	}
	
}
////////////////////////////////////////////////////////////////////////
public class ThrowExam {

	public static void main(String[] args) {
		System.out.println("**********���� �����մϴ�**********");
		
		Test t = new Test();
		try {
			t.ageCheck(-5);
		}catch(RuntimeException e) {
			System.out.println(e.getMessage() + "\n");
		}
		
		System.out.println("**********���� �����մϴ�**********");
	}

}
