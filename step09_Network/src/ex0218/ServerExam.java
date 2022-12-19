package ex0218;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExam {
	public ServerExam(){
		try(ServerSocket server = new ServerSocket(8000) ){//누군가가 나에게 와주기를 기다리는...
			
			while(true) {
				System.out.println("클라이언트 접속을 대기 중입니다.....");
				Socket sk = server.accept(); // 개개인의 클라이언트들
				
				System.out.println(sk.getInetAddress() + "님 접속하셨습니다.");
				
				InputStream is = sk.getInputStream(); //접속한 클라이언트가 보내온 데이터를 읽기
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				
				String message = br.readLine();
				System.out.println( "[클라이언트가 보내온 내용] = "+ message);
				
				//접속한 클라이언트에게 데이터 전송!
				
				
				PrintWriter pw = new PrintWriter(sk.getOutputStream(), true);
				pw.println("자바세상에 오신걸 환영합니다!!");
				
				sk.close();
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		new ServerExam();


	}

}
