package ex0216.inner;

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

public class JFrameInnerExam extends JFrame implements ActionListener{ //BorderLayout �̴�. - 5���� �������� ������Ʈ�� �÷���
	
	JButton btn1 = new JButton("Ŭ��1");
	JButton btn2 = new JButton("Ŭ��2");
	JTextField text = new JTextField(10);
    
	public JFrameInnerExam() {
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
        
        //����� â ����
        super.setLocationRelativeTo(null); //â ��ġ ������ âũ�� ���� ���Ŀ� ������!!
        
        //JFrame ������
        super.setVisible(true);
        
        //X�� Ŭ������ �� JFrame�����ϱ�
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //�̺�Ʈ ���
        //�̺�Ʈ��ü.addXxxxListener(�̺�Ʈ ó���س��� ��ü);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        this.addMouseMotionListener(new MouseExam()); // Inner Ŭ������ ������ �������.
        this.addMouseListener(new MouseExam02());//���簴ü�� ����
        
    }//������ ��

    public static void main(String[] args) {
        new JFrameInnerExam();

    }

    /**
     * ��ư�� �������� �� ȣ��Ǵ� �޼ҵ�
     * */
    int count;
	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println("��ư�� �������׿�......");
		//�̺�Ʈ�� �߻���Ű�� ��ü ���
		Object obj = e.getSource();
		if(obj == btn1) {
			System.out.println(e.getActionCommand() + " ��ư�� �������׿�......");
			//��ư�� ������ Ƚ���� text �ڽ��� ���̱�
			text.setText(count++ +"��");
		}else if(obj == btn2){
			System.out.println(e.getActionCommand() + " ��ư�� �������� �����մϴ�.......");
			System.exit(0);
		}
		
	}  
	
    /////Inner Ŭ���� �߰�///////////////////////////////////////////////////
	/**
	 * ���콺�� �巡�� ���� �� �̺�Ʈ �ڵ鷯 �����
	 * */
	class MouseExam extends MouseMotionAdapter{
		
		
		@Override
		public void mouseDragged(MouseEvent e) {
			//���콺 ��ǥ�� ���ؼ� text�ڽ��� �ø���.
			int x = e.getX();
			int y = e.getY();
			
			text.setText("x= "+ x +" , "+ "y= " + y);
			
		}
	}//MouseExam End
	
	class MouseExam02 extends MouseAdapter{

		@Override
		public void mouseClicked(MouseEvent e) {
			//���콺 ��ǥ�� ���ؼ� text�ڽ��� �ø���.
			int x = e.getX();
			int y = e.getY();
			
			//System.out.println("x= "+ x +" , "+ "y= " + y);
			//JFrame�� title�� ��ǥ�� �����ϱ�
			JFrameInnerExam.this.setTitle("x= "+ x +" , "+ "y= " + y); //Outer Ŭ�������� ��ü�� �����ϴ¹��: Outer Ŭ�����̸�.this
			
			//JButton �۾� ����
			JFrameInnerExam.this.btn1.setText("x= "+ x +" , "+ "y= " + y);
		
		}	
	}//MouseExam02 End
	
	
	
}//JFrameExam END
////////////////////////////////////////////////////////////////


//////////////////////////////////////////////////











