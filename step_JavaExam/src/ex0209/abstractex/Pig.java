package ex0209.abstractex;

public class Pig extends Animal {
	public Pig() {}
	public Pig(String name, String bodyColar) {
		super(name, bodyColar);
	}

	@Override
	public void sound() {
		System.out.println("�ܲ�");

	}

	@Override
	public void eat() {
		System.out.println("����� �� �߸Դ´�");

	}
	@Override
	public void run() {
		System.out.println("�� �޸��� ���Ѵ�");

	}
}
