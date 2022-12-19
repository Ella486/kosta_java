package ex0215.event;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class JFrameExam extends JFrame implements ActionListener{ //BorderLayout 이다. - 5개의 영역으로 컴포넌트가 올려짐
	
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
        
        //정가운데 창 놓기
        super.setLocationRelativeTo(null); //창 위치 설정은 창크기 설정 이후에 가능함!!
        
        //JFrame 보여줘
        super.setVisible(true);
        
        //X를 클릭했을 때 JFrame종료하기
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //이벤트 등록
        //이벤트주체.addXxxxListener(이벤트 처리해놓은 객체);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        this.addMouseMotionListener(new MouseExam(text));
        this.addMouseListener(new MouseExam02(this));//현재객체를 전달
        
    }//생성자 끝

    public static void main(String[] args) {
        new JFrameExam();

    }

    /**
     * 버튼이 눌려졌을 때 호출되는 메소드
     * */
    int count;
	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println("버튼이 눌러졌네요......");
		//이벤트를 발생시키는 주체 얻기
		Object obj = e.getSource();
		if(obj == btn1) {
			System.out.println(e.getActionCommand() + " 버튼이 눌러졌네요......");
			//버튼이 눌러진 횟수를 text 박스에 보이기
			text.setText(count++ +"번");
		}else if(obj == btn2){
			System.out.println(e.getActionCommand() + " 버튼이 눌러져서 종료합니다.......");
			System.exit(0);
		}
		
	}  
    
}//JFrameExam END
////////////////////////////////////////////////////////////////

/**
 * 마우스를 드래그 했을 때 이벤트 핸들러 만들기
 * */
class MouseExam extends MouseMotionAdapter{
	JTextField text;
	public MouseExam(JTextField text) {//위에 text를 생성해야되서 이너클래스 생성
		this.text = text;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		//마우스 좌표를 구해서 text박스에 올린다.
		int x = e.getX();
		int y = e.getY();
		
		//System.out.println("x= "+ x +" , "+ "y= " + y);
		text.setText("x= "+ x +" , "+ "y= " + y);
		
	}
			
}
//////////////////////////////////////////////////
class MouseExam02 extends MouseAdapter{

	JFrameExam jfe;
	public MouseExam02(JFrameExam jfe) {//생성자 생성  ,이너클래스
		this.jfe = jfe;
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//마우스 좌표를 구해서 text박스에 올린다.
		int x = e.getX();
		int y = e.getY();
		
		//System.out.println("x= "+ x +" , "+ "y= " + y);
		//JFrame의 title을 좌표로 변경하기
		jfe.setTitle("x= "+ x +" , "+ "y= " + y);
		
		//JButton 글씨 변경
		jfe.btn1.setText("x= "+ x +" , "+ "y= " + y);
	
	}
	
}











