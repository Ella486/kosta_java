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
				System.out.println("Client ���� �����");
				sk = server.accept();
				userIp = sk.getInetAddress().toString();
				System.out.println(userIp + "�� �����ϼ̽��ϴ�.");
				
				//���ӵ� Ŭ���̾�Ʈ�� �������� �����͸� �о ��� Ŭ���̾�Ʈ���� �����͸� ������ �����尡 �ʿ�!
				ClientSocketThread th = new ClientSocketThread();
				th.start();
				
				list.add(th);
				
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}//������ ��
	
	/**
	 * List�� �ִ� ��� �����ڿ��� ��������� ���� �޼����� �����Ѵ�.
	 * */
	public void sendMessage(String message) {
		for(ClientSocketThread th : list) {
			th.pw.println(message);
		}
	}
	
	///////////////////////////////////////////////////////////////
	//���ӵ� Ŭ���̾�Ʈ�� �������� �����͸� �о ��� Ŭ���̾�Ʈ���� �����͸� ������ �����尡 �ʿ�!
	class ClientSocketThread extends Thread{
		BufferedReader br; // Ŭ���̾�Ʈ���� ���۵� ������ �б�
		PrintWriter pw; //Ŭ���̾�Ʈ���� ������ �����ϱ�
		String name;//��ȭ��
		
		@Override
		public void run() {
			try {
				br = new BufferedReader (new InputStreamReader(sk.getInputStream()));
				pw = new PrintWriter(sk.getOutputStream(),true);
				
				//��ȭ�� �б�
				name = br.readLine();
				
				//���ӵ� ��� �������� �˸���.(����)
				sendMessage("["+ name + "] ���� �����ϼ̽��ϴ�");
				
				String inputData = null;
				while((inputData = br.readLine()) != null) {
					sendMessage("["+ name + "]" + inputData);
				}
			
			}catch(Exception e) {
				//e.printStackTrace();
				
				//���ӵ� ������ Socket ���ܰ� �߻��ߴ�.
				
				//���� �����带 list���� �����Ѵ�.
				list.remove(this); //this �� ClientSocketThread�� ���� �߻��Ѱ� ������
				
				//���� �������� �˸���.
				sendMessage("["+ name + "] ���� �����ϼ̽��ϴ�");
				
				//����â�� ���
				System.out.println("["+ name + "] ���� �����ϼ̽��ϴ�");
			}
		}
	}
	
	
	/////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		new ServerGUIChatExam();
	}

}//Ŭ���� ��








