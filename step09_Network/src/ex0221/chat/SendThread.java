package ex0221.chat;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Ű���� �Է��� �޾Ƽ� �Է°��� ��������� �����Ѵ�.
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
		 //Ű���� �Է� �޴´�.
		 Scanner sc = new Scanner(System.in);
		 
		 // �Է°��� ������� �����Ѵ�.
		 try(PrintWriter pw= new PrintWriter(sk.getOutputStream(),true)) {
			 while(true) {
				 String data = sc.nextLine();//Ű���� �Է� �б�
				 if(data.equals("exit")) {
					 pw.println(data);
					 break;
				 }else {
					 pw.println(name + "�� ���� ����: " + data);
				 }
			 } 
			 
			 System.out.println(name + "�� ������ �����尡 �����մϴ�.");
			 
		 }catch(Exception e) {
			 System.out.println(name + "�� SendThread ���ܰ� �߻��߽��ϴ�.");
			 //e.printStackTrace();
		 }
		 
		 String data = sc.nextLine(); //Ű���� �Է� �б�
		 
		 
	}
	
}
