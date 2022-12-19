package ex0217.io;

import java.io.Serializable;

/**
 * ���� ��ü�� ���Ͽ� ���� �ϱ����ؼ��� ����ȭ �ʼ�!!
 * 
 * : static, transient�� ����ȭ ��󿡼� ����!
 * */
public class Student implements Serializable {
	private String name;
	private int age;
	private  String addr;
	
	public Student(){}

	public Student(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [name=");
		builder.append(name);
		builder.append(", age=");
		builder.append(age);
		builder.append(", addr=");
		builder.append(addr);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
