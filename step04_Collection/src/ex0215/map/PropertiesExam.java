package ex0215.map;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

public class PropertiesExam {
	Properties pro = new Properties();
	public PropertiesExam(){
		//추가
		pro.setProperty("id", "jang");
		pro.setProperty("age", "20");
		pro.setProperty("addr", "서울");
		
		//조회
		for(String key : pro.stringPropertyNames()) {
			String value = pro.getProperty( key);
			System.out.println(key + " = " + value);
		}
		
	}
	///////////////////////////////////////////////
	
	/**
	 * 외부의 ~.properties 파일을 읽어서 key와 value로 분리하는 방법
	 * 1) IO를 이용한 방법
	 * 
	 * 2) ResourcesBundle 객체를 이용하는 방법
	 * */
	//1) IO를 이용한 방법 - 자료값을 연속적으로 보려고 할 때 이용하면 좋음
	public void test01() {
		
		try {
			pro.clear();//기존의 데이터를 비우기
			pro.load(new FileInputStream("src/ex0215/map/test.properties") ) ; // FileInputStream 가 IO임
			
			//조회
			for(String key : pro.stringPropertyNames()) {
				String value = pro.getProperty( key);
				System.out.println(key + " = " + value);
			}
		}catch(IOException e) {
			e.printStackTrace();
			
		}
	}
	
	
	//2) ResourcesBundle 객체를 이용하는 방법 -주로 일회성으로 쓸 때 사용
	/*
	 * ResourcesBundle은 ~.properties 파일을 로딩하는 전용클래스로서 경로를 설정할 때
	 * classes 폴더가 기준이며 확장자는 생략한다.!!
	 * */
	
	public void test02() {
		ResourceBundle rb = ResourceBundle.getBundle("ex0215/map/test");
		for(String key : rb.keySet()) {
			System.out.println(key + " : " + rb.getString(key));
		}
	}

	
	public static void main(String[] args) {
		PropertiesExam pe = new PropertiesExam();
		System.out.println("--------1) IO를 이용한 방법 ------------ ");
		//pe.test01();
		
		System.out.println("--------2) ResourcesBundle 객체를 이용하는 방법 ------------ ");
		pe.test02();
	}

}
