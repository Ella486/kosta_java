package ex0221.multiChat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerGUIChatExam {
	ServerSocket server;
	Socket sk;
	String userIp;
	
	List<ClientSocketThread> list = new ArrayList<ServerGUIChatExam.ClientSocketThread>();
	
	public ServerGUIChatExam(){
		try {
			server = new ServerSocket(8888);
			while(true) {
				System.out.println("Client 접속 대기중");
				sk = server.accept();
				userIp = sk.getInetAddress().toString();
				System.out.println(userIp + "님 접속하셨습니다.");
				
				//접속된 클라이언트가 보내오는 데이터를 읽어서 모든 클라이언트에게 데어터를 전송할 스레드가 필요!
				ClientSocketThread th = new ClientSocketThread();
				th.start();
				
				list.add(th);
				
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}//생성자 끝
	
	/**
	 * List에 있는 모든 접속자에게 상대측에서 보낸 메세지를 전송한다.
	 * */
	public void sendMessage(String message) {
		for(ClientSocketThread th : list) {
			th.pw.println(message);
		}
	}
	
	///////////////////////////////////////////////////////////////
	//접속된 클라이언트가 보내오는 데이터를 읽어서 모든 클라이언트에게 데어터를 전송할 스레드가 필요!
	class ClientSocketThread extends Thread{
		BufferedReader br; // 클라이언트에게 전송된 데이터 읽기
		PrintWriter pw; //클라이언트에게 데이터 전송하기
		String name;//대화명
		
		@Override
		public void run() {
			try {
				br = new BufferedReader (new InputStreamReader(sk.getInputStream()));
				pw = new PrintWriter(sk.getOutputStream(),true);
				
				//대화명 읽기
				name = br.readLine();
				
				//접속된 모든 유저에서 알린다.(전송)
				sendMessage("["+ name + "] 님이 입장하셨습니다");
				
				String inputData = null;
				while((inputData = br.readLine()) != null) {
					sendMessage("["+ name + "]" + inputData);
				}
			
			}catch(Exception e) {
				//e.printStackTrace();
				
				//접속된 유저의 Socket 예외가 발생했다.
				
				//현재 스레드를 list에서 제거한다.
				list.remove(this); //this 가 ClientSocketThread임 예외 발생한곳 없애줌
				
				//남은 유저에게 알린다.
				sendMessage("["+ name + "] 님이 퇴장하셨습니다");
				
				//서버창에 출력
				System.out.println("["+ name + "] 님이 퇴장하셨습니다");
			}
		}
	}
	
	
	/////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		new ServerGUIChatExam();
	}

}//클래스 끝








