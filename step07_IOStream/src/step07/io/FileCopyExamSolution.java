package step07.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileCopyExamSolution {// 내가한거

	public FileCopyExamSolution(String readFname, String writeFname) {
		//readFname에 있는 내용을 읽어서 writerFname에 저장 - 파일 복사
			File readfile = new File(readFname);
			File writefile = new File(writeFname);
			//byte단위로 파일 읽기!
			FileInputStream fis=null;
				
			//byte단위로 파일 저장!
			FileOutputStream fos =null;
			try {
				//생성
				fis = new FileInputStream(readfile);
					
					int byteSize = fis.available();
										
					byte b [] = new byte[byteSize];
					fis.read(b);
					
					//byte배열을 ---> 문자열로 변경!
					String data = new String(b);
					System.out.println(data);
		///////////////////////////////////////////////src/step07/io/test.txt
					//저장 가능
					fos = new FileOutputStream(writefile);
					//writefile.createNewFile();
					fos.write(b);
					
					System.out.println(readfile+" 의 내용을");
					System.out.println(writefile + " 에 저장했습니다");
					
					
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
		System.out.println("readFname: " + readFname);
		String writeFname = JOptionPane.showInputDialog("저장할파일명?"); //src/step07/io/test01.txt
		System.out.println("writeFname: " + writeFname);
		
		new FileCopyExamSolution(readFname,writeFname);
	}//메인끝

}//클래스 끝
