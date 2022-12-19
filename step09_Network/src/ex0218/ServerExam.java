package ex0218;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExam {
	public ServerExam(){
		try(ServerSocket server = new ServerSocket(8000) ){//�������� ������ ���ֱ⸦ ��ٸ���...
			
			while(true) {
				System.out.println("Ŭ���̾�Ʈ ������ ��� ���Դϴ�.....");
				Socket sk = server.accept(); // �������� Ŭ���̾�Ʈ��
				
				System.out.println(sk.getInetAddress() + "�� �����ϼ̽��ϴ�.");
				
				InputStream is = sk.getInputStream(); //������ Ŭ���̾�Ʈ�� ������ �����͸� �б�
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				
				String message = br.readLine();
				System.out.println( "[Ŭ���̾�Ʈ�� ������ ����] = "+ message);
				
				//������ Ŭ���̾�Ʈ���� ������ ����!
				
				
				PrintWriter pw = new PrintWriter(sk.getOutputStream(), true);
				pw.println("�ڹټ��� ���Ű� ȯ���մϴ�!!");
				
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
