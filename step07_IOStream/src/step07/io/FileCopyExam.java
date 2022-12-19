package step07.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileCopyExam {

	public FileCopyExam(String readFname, String writeFname) { //����� ��
		//readFname�� �ִ� ������ �о writerFname�� ���� - ���� ����
			
			FileInputStream fis=null;
				
			FileOutputStream fos =null;
			
			try {
				//����
				fis = new FileInputStream(readFname);

				//���� ����
				fos = new FileOutputStream(writeFname);	
					
					int i=0;
					while((i= fis.read()) != -1) {
						fos.write(i);
					}
					
					System.out.println("���Ϻ��縦 �Ϸ��߽��ϴ�.");
													
				}catch(IOException e) {
					e.printStackTrace();
				}finally {
					//�ݱ�
					try {
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
		new FileCopyExam(readFname,writeFname);
		long end = System.nanoTime();
		
		System.out.println("�Ѱɸ� ns: " + (end-start));
	}//���γ�

}//Ŭ���� ��
