package ex0215.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class JFrameExam extends JFrame { //BorderLayout 이다. - 5개의 영역으로 컴포넌트가 올려짐
	
	JButton btn1 = new JButton("클릭1");
	JButton btn2 = new JButton("클릭2");
	JTextField text = new JTextField(10);
    
	public JFrameExam() {
        super("JFrameExam 예제입니다.");
        
        Container con = super.getContentPane();//super. 생략 가능함
        
        con.setBackground(Color.CYAN);
        btn1.setBackground(Color.pink);
        
        //JFrame의 레이아웃을 변경해보자
        //super.setLayout(new FlowLayout(FlowLayout.RIGHT,0,50));
        super.setLayout(new FlowLayout());
        
        //버튼 2개 을 추가하자
        //super.add(btn1, BorderLayout.NORTH);
       // super.add(btn2,BorderLayout.WEST);
        
        con.add(btn1);
        con.add(btn2);
        con.add(text);
        
        //창의 크기 설정
        super.setSize(500,600);
        
        //JFrame 보여줘
        super.setVisible(true);
        
        //X를 클릭했을 때 JFrame종료하기
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    public static void main(String[] args) {
        new JFrameExam();

    }
}

