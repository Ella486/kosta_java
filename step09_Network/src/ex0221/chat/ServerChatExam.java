package ex0221.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerChatExam {
	Socket sk;
	
	public ServerChatExam(){
		try(ServerSocket server = new ServerSocket(8888)){
			System.out.println("클라이언트 접속을 기다립니다......");
			sk = server.accept();	
			
			System.out.println(sk.getInetAddress() + "님과 채팅을 시작합니다");
			
			//보내는 스레드
			new SendThread(sk, "SERVER").start();
			
			//받는 스레드
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
 * 클라이언트로부터 전송된 데이터 읽어서 모니터에 출력하는 스레드
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
				
				System.out.println("서버 받는 스레드 종료합니다.");
				
			}catch(Exception e) {
				System.out.println("ServerReceiveThread catch 발생.......");
				//e.printStackTrace();
			}finally {
				System.exit(0);// 프로그램 종료!
			}
		
		}
	}//ServerReceiveThread 끝
	
	
	
}//SeverChatExam 끝












