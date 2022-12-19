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
		//readFname�� �ִ� ������ �о writerFname�� ���� - ���� ����
			
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
					
					System.out.println("���Ϻ��縦 �Ϸ��߽��ϴ�.");
													
				}catch(IOException e) {
					e.printStackTrace();
				}finally {
					//�ݱ�
					try {
						//�ݱ⸦ �� ���� ������Ʈ�� ���� �ݴ´�.
						if(bis != null)bis.close();
						if(bos != null)bos.close();
						
						if(fis != null)fis.close();
						if(fos != null)fos.close();
						
						
						
					}catch(Exception e){
						e.printStackTrace();
					}
				}
		
	}//FileCopyExam ��
	
	
	public static void main(String[] args) {
		String readFname = JOptionPane.showInputDialog("�������ϸ�?"); // src/step07/io/test.txt
		
		String writeFname = JOptionPane.showInputDialog("���������ϸ�?"); //src/step07/io/test01.txt
		
		long start = System.nanoTime();
		new FileCopyBufferedExam(readFname,writeFname);
		long end = System.nanoTime();
		
		System.out.println("�Ѱɸ� ns: " + (end-start));
	}//���γ�

}//Ŭ���� ��
