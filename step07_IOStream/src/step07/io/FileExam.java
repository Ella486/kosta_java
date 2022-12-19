package step07.io;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileExam {
	
	public FileExam() throws IOException {
		String fileName = JOptionPane.showInputDialog("파일이름은?");
		System.out.println("fileName: " + fileName);
		
		File file = new File(fileName); //src/step07/io/test.txt
		if(file.exists()) {
			System.out.println(fileName + "존재합니다.");
			if(file.isFile()) {//파일이니?
				System.out.println("****" + fileName + "파일의 정보 확인********");
				System.out.println("읽기기능 : " + file.canRead());
				System.out.println("쓰기기능 : " + file.canWrite());
				System.out.println("파일이름 : " + file.getName());
				System.out.println("절대 경로 : " + file.getAbsolutePath());
				System.out.println("파일크기 : " + file.length());
				
			}else {//폴더인 경우
				System.out.println("****폴더의 정보*****");
				String fnames [] = file.list();
				for(String name : fnames) {
					System.out.println(fnames);
				}
				
			}
			
		}else {
			System.out.println(fileName + "은 없으니 만들께요.");
			//파일생성
			//file.createNewFile();
			
			//폴더생성
			file.mkdir();
		}
		
	}
	public static void main(String[] args) {
		try {
			new FileExam();
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
