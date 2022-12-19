package step07.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutStreamExam {
	public FileInputOutStreamExam() {
		//byte단위로 파일 읽기!
		FileInputStream fis=null;
		
		//byte단위로 파일 저장!
		FileOutputStream fos =null;
		try {
			//생성
			fis = new FileInputStream("src/step07/io/test.txt");
			
			
			//읽기
			/*int i = fis.read();//1byte 읽기
			System.out.println(i);*/
			
			/*while(true) {
				int i = fis.read();
				if(i==-1)break; //read는 -1이 될때까지 읽기 때문에
				System.out.println(i + " =" + (char)i);
			}*/
			/*int i=0;
			while((i=fis.read()) != -1) {
				System.out.println(i + " =" + (char)i);
			}*/
			////////////////////////////////////////////////////
			int byteSize = fis.available();
			System.out.println("byteSize: " + byteSize);
			
			byte b [] = new byte[byteSize];
			fis.read(b);
			
			//byte배열을 ---> 문자열로 변경!
			String data = new String(b);
			System.out.println(data);
			///////////////////////////////////////////////
			//저장 가능
			fos = new FileOutputStream("src/step07/io/test.txt", true); //이어쓰기
			fos.write(65); //A
			fos.write(32); //공백
			
			//문자열 ---> byte배열로 변환
			String message = "안녕하세요";
			byte [] re = message.getBytes();
			fos.write(re);
			System.out.println("저장완료");
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			//닫기
			try {
				if(fis != null)fis.close();
				if(fos != null)fos.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	
	public static void main(String[] args) {
		new FileInputOutStreamExam();

	}

}
