package ex0217.io;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

public class MenuExam extends JFrame {
	JMenuBar menuBar = new JMenuBar();
	JMenu file = new JMenu("파일(F)");
	JMenu edit = new JMenu("편집");
	JMenu help = new JMenu("Help");
	JMenu align = new JMenu("정렬");
	JMenuItem nFile = new JMenuItem("새파일");
	JMenuItem open = new JMenuItem("열기");
	JMenuItem save = new JMenuItem("저장");
	JMenuItem exit = new JMenuItem("종료");
	
	
	JCheckBoxMenuItem name = new JCheckBoxMenuItem("이름");
	JCheckBoxMenuItem date = new JCheckBoxMenuItem("날짜");
	
	JMenuItem info = new JMenuItem("정보");
	
	JTextArea text = new JTextArea();
	JScrollPane jsp = new JScrollPane(text,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	JDialog dialog = new JDialog(this, "help");
	JLabel dName= new JLabel("kang seok min"  );
	JButton enter = new JButton("확 인");

	
	BufferedInputStream bi = null;
	
	public MenuExam(){
		super("제목없음");
		Container con = getContentPane();
	
		//메뉴 단축키
		file.setMnemonic('F'); //Alt + F
		
		
		
		//메뉴아이템에 단축키
		nFile.setAccelerator(KeyStroke.getKeyStroke('N', InputEvent.CTRL_DOWN_MASK));
		save.setAccelerator(KeyStroke.getKeyStroke('S', InputEvent.CTRL_MASK));
		open.setAccelerator(KeyStroke.getKeyStroke('O', InputEvent.CTRL_MASK));
		exit.setAccelerator(KeyStroke.getKeyStroke('E', InputEvent.CTRL_MASK ^ InputEvent.ALT_MASK));
	
		menuBar.add(file);
		menuBar.add(edit);
		menuBar.add(help);
		
		file.add(nFile);
		file.add(save);
		file.add(open);
		file.addSeparator();
		file.add(exit);
		
		edit.add(align);
		align.add(name);
		align.add(date);
		
		help.add(info);
		
		setJMenuBar(menuBar);
		con.add(jsp);
		
		Toolkit toolkit = getToolkit();
		Dimension dim = toolkit.getScreenSize();
		int screenWidth = dim.width;
		int screenHeight = dim.height;
		
		dName.setHorizontalAlignment(JLabel.CENTER);
		dialog.add(dName, "Center");
		dialog.add(enter, "South");
		dialog.setBounds(((screenWidth-200)/2), ((screenHeight-200)/2), 200, 200);
		
		setBounds(((screenWidth-500)/2), ((screenHeight-500)/2), 500, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		nFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				text.setText(""); // text.append("");//끝에 추가!!!!
				MenuExam.this.setTitle("제목없음");
			}
		});
		
	
		

		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		info.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);
				
			}
		});
		enter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.dispose();//다이얼로그창만 닫기
				
			}
		});
		
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FileDialog fileSave = new FileDialog(MenuExam.this, "Save", FileDialog.SAVE);//저장(SAVE), 열기(LOAD)
				fileSave.setVisible(true);
				
				String dir = fileSave.getDirectory();
				String fileName = fileSave.getFile();
				System.out.println(dir + "/" + fileName);
				
				//저장하기
				String data = text.getText(); //textArea영역에 있는 모든 문자열을 하나의 String으로 가져옴
				System.out.println("data: " + data);
				
				try(BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dir + fileName))){
					
					data = data.replace("\n", System.getProperty("line.separator"));
					
					bos.write(data.getBytes());// String 데이터를 byte 타입 배열로 바꿔서 저장.
					
					MenuExam.this.setTitle(fileName);
					
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				
				//textArea에 있는 데이터를 읽어서(text.getText()) 파일에 저장한다.(내가 아랫부분한거)
				//저장하기
				/*String data = fileSave.getDirectory() +fileSave.getFile();
				
				 FileWriter fw;
			     BufferedWriter bw;
			     
			     	try{
			            fw = new FileWriter(data);
			            bw = new BufferedWriter(fw);
			            bw.write(text.getText());
			            bw.close();
			        }catch(IOException ioe){
			        	ioe.printStackTrace();
			        }*/

			     	
			     	
								
				
			}
		});
		
		open.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileOpen = new JFileChooser();
				int mode = fileOpen.showOpenDialog(MenuExam.this);
				System.out.println("mode : " + mode);
				
				if(mode== JFileChooser.APPROVE_OPTION){
					//선택한 폴더와 이름을 가져오기
					File file = fileOpen.getSelectedFile();
					
					try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))){
						byte b[] = new byte [bis.available()];
						bis.read(b); //byte 배열 b에 파일을 읽어들임
						String data = new String(b);
						text.setText(data); //JTextArea에 읽어들인 데이터 출력
						
						setTitle(file.getName()); //JFrame위에 제목추가
						
					}catch(Exception ex) {
						ex.printStackTrace();
					}
					
					
					
					//열기를 한 파일을 읽어서 textArea에 넣는다
					//열기 (아랫부분 내가한거)
					/*FileReader fr;
					BufferedReader br=null;
			        StringWriter sw;
			        
			        try{
			            fr = new FileReader(file);
			            br = new BufferedReader(fr);
			            sw = new StringWriter();
			            String line;
			            while ((line = br.readLine()) != null) {
			                sw.write(line+"\n");
			            }
			            br.close();
			            text.setText(sw.toString());
			            
			        }catch(IOException ioe){
			        	ioe.printStackTrace();
			        }*/


			
					
				}
			}
		});
		
	}
	
	public static void main(String[] args) {
		new MenuExam();
	}

}







