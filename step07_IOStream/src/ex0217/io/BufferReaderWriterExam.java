package ex0217.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class BufferReaderWriterExam {
	public BufferReaderWriterExam(){
		//���ڴ����� ���� �б� - Buffered ���
		
		
		//���� ���� ���� ����- Buffered ���
		//���� 438page ����!
		try(BufferedReader br = new BufferedReader(new FileReader("src/step07/io/test.txt")); 
			BufferedWriter bw = new BufferedWriter(new FileWriter("src/ex0217/io/mj.txt"))) {
			
			/*int i=0;
			while((i = br.read()) !=-1) {
				System.out.println(i + " = "+ (char)i);
			}*/
			
			//���پ� �б� Buffered���� ����.
			String str = null;
			while((str = br.readLine()) != null) {
				System.out.println(str);
			}
			/////////////////////////////////////////////////////////
			//���� = ����
			
			bw.write("���� ������?");
			bw.write(13);
			bw.write(10); //�ٹٲ�
			bw.write("�۽�??? �����");
			bw.newLine(); //�ٹٲ�
			
			bw.write("����Ŀ�\n");
			bw.write("I`M");
			
			//bw.flush(); //���ۿ� �ִ� �����͸� ����.(�����Ѵ�.)
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	
	public static void main(String[] args) {
		new BufferReaderWriterExam();

	}

}
