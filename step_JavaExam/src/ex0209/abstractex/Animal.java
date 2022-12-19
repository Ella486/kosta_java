package ex0209.abstractex;
/**
 * 동물들이 갖는 공통의 속성과 메소드 정의
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
	 * 소리를 낸다 
	 * */
	public abstract void sound();

	/**
	 * 먹는다 
	 * */
	public abstract void eat();
	
	/**
	 * 달린다 
	 * */
	public void run() {
		System.out.println("잘 뜁니다!!!");
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
