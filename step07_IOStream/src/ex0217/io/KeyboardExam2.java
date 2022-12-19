package ex0217.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class KeyboardExam2 {
	
	public KeyboardExam2(){ //생성자
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new FileWriter("src/ex0217/io/mj2.txt"))){
			
			while(true) {
				System.out.println("입력> ");
				String data = br.readLine();
				
				if(data.equals("exit"))break;
				
				System.out.println("data: " + data);
				
				bw.write(data);
				bw.newLine();
				bw.flush();
				
			}
			System.out.println("프로그램 종료.....");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public static void main(String[] args) {
	
			new KeyboardExam2();
		

	}

}
