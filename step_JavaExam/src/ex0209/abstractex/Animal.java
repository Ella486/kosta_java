package ex0209.abstractex;
/**
 * �������� ���� ������ �Ӽ��� �޼ҵ� ����
 * */
public abstract class Animal {
	private String name;
	private String bodyColar;

	public Animal() {}
	public Animal(String name, String bodyColar) {
		this.name = name;
		this.bodyColar = bodyColar;
	}
	
	/**
	 * �Ҹ��� ���� 
	 * */
	public abstract void sound();

	/**
	 * �Դ´� 
	 * */
	public abstract void eat();
	
	/**
	 * �޸��� 
	 * */
	public void run() {
		System.out.println("�� �ݴϴ�!!!");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBodyColar() {
		return bodyColar;
	}

	public void setBodyColar(String bodyColar) {
		this.bodyColar = bodyColar;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(name + "|");
		sb.append(bodyColar);
		return sb.toString();
	}
	
	
}
