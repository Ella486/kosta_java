package ex0221.multiChat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class ClientGUIChatExam extends JFrame{
	JTextArea textArea = new JTextArea();
	JScrollPane jsp = new JScrollPane(textArea);
	
	JTextField textField = new JTextField();
	
	Socket sk;
	PrintWriter pw;
	BufferedReader br;
	
	public ClientGUIChatExam(){
		super("채팅창");
		
		Container con = getContentPane();
		con.add(jsp,BorderLayout.CENTER );
		con.add(textField,BorderLayout.SOUTH);
		
		
		//옵션 
		textArea.setFocusable(false);// 커서 놓기 안됨
		textArea.setBackground(Color.pink);
		
		textField.requestFocus(); //커서 놓기
		
		
		//창크기
		setSize(400, 300); //super 생략	
		
		//창 위치
		setLocationRelativeTo(null);//정가운데 놓기 //super 생략	
		
		//보여줘
		setVisible(true);  //super 생략	
		
		//X클릭하면 완전히 창닫기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //super 생략	
		
		//서버에 접속하자
		this.connection();
		
		//받는 스레드 (서버가 보내오는 데이터를 읽어서 JTextArea창에 추가하기)
		Thread th = new Thread(()->{
			try {
				String data = null;
				while((data=br.readLine()) != null) {
					textArea.append(data + "\n");
					
					//스크롤이 입력한 글자만큼 내려오기
					textArea.setCaretPosition(textArea.getText().length());
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		});
		th.setDaemon(true); //메인스레드가 종료되면 현재스레드도 함께 종료된다.
		th.start();
		
		
		//JTextField에서 값을 입력하고 enter를 하면 이벤트 처리
		textField.addActionListener((e)->{ //e는 액션이벤트 임
			//text 값을 읽어서
			String message = textField.getText();
			
			//서버에 전송하고
			pw.println(message);
			
			//text값 지우기
			textField.setText("");
			
		});
		
	}//생성자 끝
	
	/**
	 * 서버에 접속하는 메소드
	 * */
	public void connection(){
		try {
			sk = new Socket("127.0.0.1", 8888);
			pw = new PrintWriter(sk.getOutputStream(),true);
			br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
			
			//대화명을 보낸다.
			String name = JOptionPane.showInputDialog(this, "대화명을 입력해주세요");
			pw.println(name);//대화명 전송
			
			super.setTitle("["+ name+ "]");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new ClientGUIChatExam();
	}

}
