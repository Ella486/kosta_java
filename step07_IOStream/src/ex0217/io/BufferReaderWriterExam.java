package ex0217.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class BufferReaderWriterExam {
	public BufferReaderWriterExam(){
		//문자단위로 파일 읽기 - Buffered 사용
		
		
		//문자 단위 파일 쓰기- Buffered 사용
		//교재 438page 참고!
		try(BufferedReader br = new BufferedReader(new FileReader("src/step07/io/test.txt")); 
			BufferedWriter bw = new BufferedWriter(new FileWriter("src/ex0217/io/mj.txt"))) {
			
			/*int i=0;
			while((i = br.read()) !=-1) {
				System.out.println(i + " = "+ (char)i);
			}*/
			
			//한줄씩 읽기 Buffered에만 있음.
			String str = null;
			while((str = br.readLine()) != null) {
				System.out.println(str);
			}
			/////////////////////////////////////////////////////////
			//쓰기 = 저장
			
			bw.write("오늘 뭐먹지?");
			bw.write(13);
			bw.write(10); //줄바꿈
			bw.write("글쎄??? 고민중");
			bw.newLine(); //줄바꿈
			
			bw.write("배고파요\n");
			bw.write("I`M");
			
			//bw.flush(); //버퍼에 있는 데어터를 비운다.(저장한다.)
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	
	public static void main(String[] args) {
		new BufferReaderWriterExam();

	}

}
