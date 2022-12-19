package ex0215.map;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

public class PropertiesExam {
	Properties pro = new Properties();
	public PropertiesExam(){
		//�߰�
		pro.setProperty("id", "jang");
		pro.setProperty("age", "20");
		pro.setProperty("addr", "����");
		
		//��ȸ
		for(String key : pro.stringPropertyNames()) {
			String value = pro.getProperty( key);
			System.out.println(key + " = " + value);
		}
		
	}
	///////////////////////////////////////////////
	
	/**
	 * �ܺ��� ~.properties ������ �о key�� value�� �и��ϴ� ���
	 * 1) IO�� �̿��� ���
	 * 
	 * 2) ResourcesBundle ��ü�� �̿��ϴ� ���
	 * */
	//1) IO�� �̿��� ��� - �ڷᰪ�� ���������� ������ �� �� �̿��ϸ� ����
	public void test01() {
		
		try {
			pro.clear();//������ �����͸� ����
			pro.load(new FileInputStream("src/ex0215/map/test.properties") ) ; // FileInputStream �� IO��
			
			//��ȸ
			for(String key : pro.stringPropertyNames()) {
				String value = pro.getProperty( key);
				System.out.println(key + " = " + value);
			}
		}catch(IOException e) {
			e.printStackTrace();
			
		}
	}
	
	
	//2) ResourcesBundle ��ü�� �̿��ϴ� ��� -�ַ� ��ȸ������ �� �� ���
	/*
	 * ResourcesBundle�� ~.properties ������ �ε��ϴ� ����Ŭ�����μ� ��θ� ������ ��
	 * classes ������ �����̸� Ȯ���ڴ� �����Ѵ�.!!
	 * */
	
	public void test02() {
		ResourceBundle rb = ResourceBundle.getBundle("ex0215/map/test");
		for(String key : rb.keySet()) {
			System.out.println(key + " : " + rb.getString(key));
		}
	}

	
	public static void main(String[] args) {
		PropertiesExam pe = new PropertiesExam();
		System.out.println("--------1) IO�� �̿��� ��� ------------ ");
		//pe.test01();
		
		System.out.println("--------2) ResourcesBundle ��ü�� �̿��ϴ� ��� ------------ ");
		pe.test02();
	}

}
