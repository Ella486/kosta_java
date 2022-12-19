package ex0221.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientChatExam {
	Socket sk;
	
	public ClientChatExam(){
		try {
			sk = new Socket("127.0.0.1", 8888);
			System.out.println("서버와 채팅 시작합니다.....");
			
			//보내는 스레드
			new SendThread(sk, "CLIENT").start();
			
			//받는 스레드
			Thread th = new Thread(()->{
				try(BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream()))){
					while(true) {
						String input = br.readLine();
						if(input.equals("exit"))break;
						
						System.out.println(input);
						
					}//while문끝
					System.out.println("Client쪽 받는 스레드 종료합니다...");
					
				}catch(Exception e) {
					System.out.println("ClientChatExam의 받는 스레드 catch블럭입니다.");
					//e.printStackTrace();
				}finally{
					System.out.println("Client쪽 받는 스레드 finally블럭 입니다.");
					System.exit(0); // 
				}
			});
			th.start();
		
		}catch(Exception e) {
			System.out.println("Client 생성자 예외 발생했습니다.");
			//e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		new ClientChatExam();
		
	}

}
