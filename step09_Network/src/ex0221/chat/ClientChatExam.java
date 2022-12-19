package ex0221.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientChatExam {
	Socket sk;
	
	public ClientChatExam(){
		try {
			sk = new Socket("127.0.0.1", 8888);
			System.out.println("������ ä�� �����մϴ�.....");
			
			//������ ������
			new SendThread(sk, "CLIENT").start();
			
			//�޴� ������
			Thread th = new Thread(()->{
				try(BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream()))){
					while(true) {
						String input = br.readLine();
						if(input.equals("exit"))break;
						
						System.out.println(input);
						
					}//while����
					System.out.println("Client�� �޴� ������ �����մϴ�...");
					
				}catch(Exception e) {
					System.out.println("ClientChatExam�� �޴� ������ catch���Դϴ�.");
					//e.printStackTrace();
				}finally{
					System.out.println("Client�� �޴� ������ finally�� �Դϴ�.");
					System.exit(0); // 
				}
			});
			th.start();
		
		}catch(Exception e) {
			System.out.println("Client ������ ���� �߻��߽��ϴ�.");
			//e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		new ClientChatExam();
		
	}

}
