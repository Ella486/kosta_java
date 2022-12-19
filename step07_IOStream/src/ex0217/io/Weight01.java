package ex0217.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Weight01 {
	Scanner sc = new Scanner(System.in);
	
	public Weight01(){ //������
	
		while(true) {
			try{
				System.out.println("1. ���������� \t 2. ������ �ҷ����� \t 3. ����");
				switch(sc.nextInt()) {
				case 1:
					this.saveWeight01();
					break;
				case 2:
					this.loadWeight01();
					break;
				case 3:
					System.exit(0);
				default:
					System.out.println("1 �Ǵ� 2�� ���ڸ� �Է����ּ���");
				}
								
			}catch(Exception e) {
				System.out.println(e.getMessage() + "\n");
			}
		}//while
		
	}//Weight01
	
	public void saveWeight01() throws IOException{
		System.out.println("�̸�> ");
		String name = sc.next();
		System.out.println("������> ");
		int weight = sc.nextInt();
		System.out.println("��й�ȣ> ");
		String pw = sc.next();
		
		BufferedWriter bw = null;
		try {
			File file = new File("src/ex0217/io/"+ name + ".txt");
			if(file.exists()) {
				throw new IOException("�̹� �����ϹǷ� �ٽ� �Է����ּ���");
			}
			
			bw = new BufferedWriter(new FileWriter(file));
			bw.write(weight + ":" + pw);
			System.out.println("������ ����Ϸ�");
		}finally {
			if(bw != null)bw.close();
		}
		
	}
	
	public void loadWeight01() throws IOException{
		System.out.println("�̸�> ");
		String name = sc.next();
		BufferedReader br = new BufferedReader(new FileReader("src/ex0217/io/"+ name + ".txt"));
		String data = br.readLine();
		String [] dataArr = data.split(":");
		
		System.out.println(name + "�� �����Դ�" + dataArr[0] +" kg �̰� ����� "+ dataArr[1] + "�Դϴ�");
		
	}
	
	
	
	public static void main(String[] args) {
	
			new Weight01();
		

	}

}
