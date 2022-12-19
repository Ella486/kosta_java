package step07.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileCopyExam {

	public FileCopyExam(String readFname, String writeFname) { //강사님 답
		//readFname에 있는 내용을 읽어서 writerFname에 저장 - 파일 복사
			
			FileInputStream fis=null;
				
			FileOutputStream fos =null;
			
			try {
				//생성
				fis = new FileInputStream(readFname);

				//저장 가능
				fos = new FileOutputStream(writeFname);	
					
					int i=0;
					while((i= fis.read()) != -1) {
						fos.write(i);
					}
					
					System.out.println("파일복사를 완료했습니다.");
													
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
		
	}//FileCopyExam 끝
	
	
	public static void main(String[] args) {
		String readFname = JOptionPane.showInputDialog("읽을파일명?"); // src/step07/io/test.txt
		
		String writeFname = JOptionPane.showInputDialog("저장할파일명?"); //src/step07/io/test01.txt
		
		long start = System.nanoTime();
		new FileCopyExam(readFname,writeFname);
		long end = System.nanoTime();
		
		System.out.println("총걸린 ns: " + (end-start));
	}//메인끝

}//클래스 끝
