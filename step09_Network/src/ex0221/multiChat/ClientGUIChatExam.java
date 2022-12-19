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
		super("ä��â");
		
		Container con = getContentPane();
		con.add(jsp,BorderLayout.CENTER );
		con.add(textField,BorderLayout.SOUTH);
		
		
		//�ɼ� 
		textArea.setFocusable(false);// Ŀ�� ���� �ȵ�
		textArea.setBackground(Color.pink);
		
		textField.requestFocus(); //Ŀ�� ����
		
		
		//âũ��
		setSize(400, 300); //super ����	
		
		//â ��ġ
		setLocationRelativeTo(null);//����� ���� //super ����	
		
		//������
		setVisible(true);  //super ����	
		
		//XŬ���ϸ� ������ â�ݱ�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //super ����	
		
		//������ ��������
		this.connection();
		
		//�޴� ������ (������ �������� �����͸� �о JTextAreaâ�� �߰��ϱ�)
		Thread th = new Thread(()->{
			try {
				String data = null;
				while((data=br.readLine()) != null) {
					textArea.append(data + "\n");
					
					//��ũ���� �Է��� ���ڸ�ŭ ��������
					textArea.setCaretPosition(textArea.getText().length());
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		});
		th.setDaemon(true); //���ν����尡 ����Ǹ� ���罺���嵵 �Բ� ����ȴ�.
		th.start();
		
		
		//JTextField���� ���� �Է��ϰ� enter�� �ϸ� �̺�Ʈ ó��
		textField.addActionListener((e)->{ //e�� �׼��̺�Ʈ ��
			//text ���� �о
			String message = textField.getText();
			
			//������ �����ϰ�
			pw.println(message);
			
			//text�� �����
			textField.setText("");
			
		});
		
	}//������ ��
	
	/**
	 * ������ �����ϴ� �޼ҵ�
	 * */
	public void connection(){
		try {
			sk = new Socket("127.0.0.1", 8888);
			pw = new PrintWriter(sk.getOutputStream(),true);
			br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
			
			//��ȭ���� ������.
			String name = JOptionPane.showInputDialog(this, "��ȭ���� �Է����ּ���");
			pw.println(name);//��ȭ�� ����
			
			super.setTitle("["+ name+ "]");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new ClientGUIChatExam();
	}

}
