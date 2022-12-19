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
	
	public Weight01(){ //생성자
	
		while(true) {
			try{
				System.out.println("1. 프로필저장 \t 2. 프로필 불러오기 \t 3. 종료");
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
					System.out.println("1 또는 2의 숫자를 입력해주세요");
				}
								
			}catch(Exception e) {
				System.out.println(e.getMessage() + "\n");
			}
		}//while
		
	}//Weight01
	
	public void saveWeight01() throws IOException{
		System.out.println("이름> ");
		String name = sc.next();
		System.out.println("몸무게> ");
		int weight = sc.nextInt();
		System.out.println("비밀번호> ");
		String pw = sc.next();
		
		BufferedWriter bw = null;
		try {
			File file = new File("src/ex0217/io/"+ name + ".txt");
			if(file.exists()) {
				throw new IOException("이미 존재하므로 다시 입력해주세요");
			}
			
			bw = new BufferedWriter(new FileWriter(file));
			bw.write(weight + ":" + pw);
			System.out.println("프로필 저장완료");
		}finally {
			if(bw != null)bw.close();
		}
		
	}
	
	public void loadWeight01() throws IOException{
		System.out.println("이름> ");
		String name = sc.next();
		BufferedReader br = new BufferedReader(new FileReader("src/ex0217/io/"+ name + ".txt"));
		String data = br.readLine();
		String [] dataArr = data.split(":");
		
		System.out.println(name + "님 몸무게는" + dataArr[0] +" kg 이고 비번은 "+ dataArr[1] + "입니다");
		
	}
	
	
	
	public static void main(String[] args) {
	
			new Weight01();
		

	}

}
