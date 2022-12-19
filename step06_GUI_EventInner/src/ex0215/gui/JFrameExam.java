package ex0215.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class JFrameExam extends JFrame { //BorderLayout �̴�. - 5���� �������� ������Ʈ�� �÷���
	
	JButton btn1 = new JButton("Ŭ��1");
	JButton btn2 = new JButton("Ŭ��2");
	JTextField text = new JTextField(10);
    
	public JFrameExam() {
        super("JFrameExam �����Դϴ�.");
        
        Container con = super.getContentPane();//super. ���� ������
        
        con.setBackground(Color.CYAN);
        btn1.setBackground(Color.pink);
        
        //JFrame�� ���̾ƿ��� �����غ���
        //super.setLayout(new FlowLayout(FlowLayout.RIGHT,0,50));
        super.setLayout(new FlowLayout());
        
        //��ư 2�� �� �߰�����
        //super.add(btn1, BorderLayout.NORTH);
       // super.add(btn2,BorderLayout.WEST);
        
        con.add(btn1);
        con.add(btn2);
        con.add(text);
        
        //â�� ũ�� ����
        super.setSize(500,600);
        
        //JFrame ������
        super.setVisible(true);
        
        //X�� Ŭ������ �� JFrame�����ϱ�
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    public static void main(String[] args) {
        new JFrameExam();

    }
}

