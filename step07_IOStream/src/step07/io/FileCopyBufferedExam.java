package step07.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileCopyBufferedExam {

	public FileCopyBufferedExam(String readFname, String writeFname) {
		//readFname에 있는 내용을 읽어서 writerFname에 저장 - 파일 복사
			
			FileInputStream fis=null;
			FileOutputStream fos =null;
			
			BufferedInputStream bis = null;
			BufferedOutputStream bos = null;
				
			
			try {
				
				fis = new FileInputStream(readFname);
				fos = new FileOutputStream(writeFname);	
				
				bis = new BufferedInputStream(fis);
				bos = new BufferedOutputStream(fos);
					
					int i=0;
					while((i= bis.read()) != -1) {
						bos.write(i);
					}
					
					System.out.println("파일복사를 완료했습니다.");
													
				}catch(IOException e) {
					e.printStackTrace();
				}finally {
					//닫기
					try {
						//닫기를 할 때는 보조스트림 먼저 닫는다.
						if(bis != null)bis.close();
						if(bos != null)bos.close();
						
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
		new FileCopyBufferedExam(readFname,writeFname);
		long end = System.nanoTime();
		
		System.out.println("총걸린 ns: " + (end-start));
	}//메인끝

}//클래스 끝
