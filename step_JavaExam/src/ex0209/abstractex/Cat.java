package ex0209.abstractex;

public class Cat extends Animal {
	//고양이만이 가질 수 있는 속성이나 메소드 추가한다!!
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
		System.out.println("야옹");
		
	}

	@Override
	public void eat() {
		System.out.println("쥐를 먹는다");
		
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("|" + super.toString() );
		sb.append("|" + legs);
		
		return sb.toString();
	}

}

