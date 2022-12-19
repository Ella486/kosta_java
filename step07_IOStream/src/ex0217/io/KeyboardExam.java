package ex0217.io;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KeyboardExam {
	
	public KeyboardExam()throws Exception{ //생성자
		
		//키보드 입력
		//byte 단위로 읽기
		/*InputStream is = System.in;
		int i = is.read();
		System.out.println(i + " = " + (char)i);*/
		
		
		//byte 단위 ---> 문자단위 읽기로 변환
		/*InputStreamReader isr = new InputStreamReader(System.in);
		int i = isr.read();//문자단위 읽기
		System.out.println(i + " = " + (char)i);*/
		
		
		//Buffered로 변환해서 한줄 읽기 하자
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
