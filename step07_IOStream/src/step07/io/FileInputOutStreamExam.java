package step07.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutStreamExam {
	public FileInputOutStreamExam() {
		//byte������ ���� �б�!
		FileInputStream fis=null;
		
		//byte������ ���� ����!
		FileOutputStream fos =null;
		try {
			//����
			fis = new FileInputStream("src/step07/io/test.txt");
			
			
			//�б�
			/*int i = fis.read();//1byte �б�
			System.out.println(i);*/
			
			/*while(true) {
				int i = fis.read();
				if(i==-1)break; //read�� -1�� �ɶ����� �б� ������
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
			
			//byte�迭�� ---> ���ڿ��� ����!
			String data = new String(b);
			System.out.println(data);
			///////////////////////////////////////////////
			//���� ����
			fos = new FileOutputStream("src/step07/io/test.txt", true); //�̾��
			fos.write(65); //A
			fos.write(32); //����
			
			//���ڿ� ---> byte�迭�� ��ȯ
			String message = "�ȳ��ϼ���";
			byte [] re = message.getBytes();
			fos.write(re);
			System.out.println("����Ϸ�");
			
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
	}
	
	
	public static void main(String[] args) {
		new FileInputOutStreamExam();

	}

}
