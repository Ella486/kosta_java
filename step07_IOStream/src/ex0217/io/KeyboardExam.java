package ex0217.io;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KeyboardExam {
	
	public KeyboardExam()throws Exception{ //������
		
		//Ű���� �Է�
		//byte ������ �б�
		/*InputStream is = System.in;
		int i = is.read();
		System.out.println(i + " = " + (char)i);*/
		
		
		//byte ���� ---> ���ڴ��� �б�� ��ȯ
		/*InputStreamReader isr = new InputStreamReader(System.in);
		int i = isr.read();//���ڴ��� �б�
		System.out.println(i + " = " + (char)i);*/
		
		
		//Buffered�� ��ȯ�ؼ� ���� �б� ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String data = br.readLine();
		System.out.println("data: " + data);
		
		
		
	}
	
	
	public static void main(String[] args) {
		try {
		new KeyboardExam();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
