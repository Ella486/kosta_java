package step07.io;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileExam {
	
	public FileExam() throws IOException {
		String fileName = JOptionPane.showInputDialog("�����̸���?");
		System.out.println("fileName: " + fileName);
		
		File file = new File(fileName); //src/step07/io/test.txt
		if(file.exists()) {
			System.out.println(fileName + "�����մϴ�.");
			if(file.isFile()) {//�����̴�?
				System.out.println("****" + fileName + "������ ���� Ȯ��********");
				System.out.println("�б��� : " + file.canRead());
				System.out.println("������ : " + file.canWrite());
				System.out.println("�����̸� : " + file.getName());
				System.out.println("���� ��� : " + file.getAbsolutePath());
				System.out.println("����ũ�� : " + file.length());
				
			}else {//������ ���
				System.out.println("****������ ����*****");
				String fnames [] = file.list();
				for(String name : fnames) {
					System.out.println(fnames);
				}
				
			}
			
		}else {
			System.out.println(fileName + "�� ������ ���鲲��.");
			//���ϻ���
			//file.createNewFile();
			
			//��������
			file.mkdir();
		}
		
	}
	public static void main(String[] args) {
		try {
			new FileExam();
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
