package ex0221.chat;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * 키보드 입력을 받아서 입력값을 상대측에서 전송한다.
 * */
public class SendThread extends Thread {
	Socket sk;
	String name;
	
	public SendThread(Socket sk, String name){
		super(name);
		this.sk = sk;
		this.name = name;
	}
	 @Override
	public void run() {
		 //키보드 입력 받는다.
		 Scanner sc = new Scanner(System.in);
		 
		 // 입력값을 상대측에 전송한다.
		 try(PrintWriter pw= new PrintWriter(sk.getOutputStream(),true)) {
			 while(true) {
				 String data = sc.nextLine();//키보드 입력 읽기
				 if(data.equals("exit")) {
					 pw.println(data);
					 break;
				 }else {
					 pw.println(name + "가 보낸 내용: " + data);
				 }
			 } 
			 
			 System.out.println(name + "의 보내는 스레드가 종료합니다.");
			 
		 }catch(Exception e) {
			 System.out.println(name + "의 SendThread 예외가 발생했습니다.");
			 //e.printStackTrace();
		 }
		 
		 String data = sc.nextLine(); //키보드 입력 읽기
		 
		 
	}
	
}
