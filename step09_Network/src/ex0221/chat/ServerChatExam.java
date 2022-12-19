package ex0221.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerChatExam {
	Socket sk;
	
	public ServerChatExam(){
		try(ServerSocket server = new ServerSocket(8888)){
			System.out.println("Ŭ���̾�Ʈ ������ ��ٸ��ϴ�......");
			sk = server.accept();	
			
			System.out.println(sk.getInetAddress() + "�԰� ä���� �����մϴ�");
			
			//������ ������
			new SendThread(sk, "SERVER").start();
			
			//�޴� ������
			new ServerReceiveThread().start();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		new ServerChatExam();
		
	}
///////////////////////////////////////////////////////////////////
/**
 * Ŭ���̾�Ʈ�κ��� ���۵� ������ �о ����Ϳ� ����ϴ� ������
 * */	
	class ServerReceiveThread extends Thread{
		@Override
		public void run() {
			try(BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream()))){
				while(true) {
					String input = br.readLine();
					if(input.equals("exit"))break;
					
					System.out.println(input);//
				}
				
				System.out.println("���� �޴� ������ �����մϴ�.");
				
			}catch(Exception e) {
				System.out.println("ServerReceiveThread catch �߻�.......");
				//e.printStackTrace();
			}finally {
				System.exit(0);// ���α׷� ����!
			}
		
		}
	}//ServerReceiveThread ��
	
	
	
}//SeverChatExam ��












