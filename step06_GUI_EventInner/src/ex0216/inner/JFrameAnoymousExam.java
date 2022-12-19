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

public class JFrameAnoymousExam extends JFrame { //BorderLayout �̴�. - 5���� �������� ������Ʈ�� �÷���
	
	JButton btn1 = new JButton("Ŭ��1");
	JButton btn2 = new JButton("Ŭ��2");
	JTextField text = new JTextField(10);
    
	int count;
	
	public JFrameAnoymousExam() {
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
        //�̺�Ʈ��ü.addXxxxListener(�̺�Ʈ ó���س��� ��ü: Annoymous���·�); //��ȸ�� �̺�Ʈ
        btn1.addActionListener(new ActionListener() {
			//������
			@Override
			public void actionPerformed(ActionEvent e) {
				//���
				text.setText(++count + "��");
			}
		});
        
        
        btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//���
				System.out.println(e.getActionCommand() + "Ŭ���Ǿ� �����մϴ�.");
				System.exit(0);
			}
		});
        
        
        this.addMouseMotionListener(new MouseMotionAdapter() {
        	@Override
        	public void mouseDragged(MouseEvent e) {
        		int x = e.getX();
        		int y = e.getY();
        		
        		text.setText("x= " + x + " , y= " + y);
        	}
		}); // Inner Ŭ������ ������ �������.
        
        this.addMouseListener(new MouseAdapter() {
        	
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		int x = e.getX();
        		int y = e.getY();
        		
        		JFrameAnoymousExam.this.setTitle("x= " + x + " , y= " + y);
        	}
        		
		});//���簴ü�� ����
        
    }//������ ��

    public static void main(String[] args) {
        new JFrameAnoymousExam();

    }

    
	
}//JFrameExam END
////////////////////////////////////////////////////////////////


//////////////////////////////////////////////////












