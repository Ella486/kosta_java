package ex0209.abstractex;

public class Puppy extends Animal {
	public Puppy() {}
	public Puppy(String name, String bodyColar) {
		super(name, bodyColar);
	}

	@Override
	public void sound() {
		System.out.println("�۸�");

	}

	@Override
	public void eat() {
		System.out.println("��Ḧ �Դ´�");

	}

}

