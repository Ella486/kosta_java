package ex0209.abstractex;

public class Cat extends Animal {
	//����̸��� ���� �� �ִ� �Ӽ��̳� �޼ҵ� �߰��Ѵ�!!
	private int legs;
	
	public Cat() {}
	public Cat(String name, String bodyColar, int legs) {
		super(name, bodyColar);
		this.legs = legs;
		
	}
	
	public int getLegs() {
		return legs;
	}
	
	public void setLegs(int legs) {
		this.legs = legs;
	}
	
	@Override
	public void sound() {
		System.out.println("�߿�");
		
	}

	@Override
	public void eat() {
		System.out.println("�㸦 �Դ´�");
		
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("|" + super.toString() );
		sb.append("|" + legs);
		
		return sb.toString();
	}

}

