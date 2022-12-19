package ex0209.abstractex;

public class Pig extends Animal {
	public Pig() {}
	public Pig(String name, String bodyColar) {
		super(name, bodyColar);
	}

	@Override
	public void sound() {
		System.out.println("꿀꿀");

	}

	@Override
	public void eat() {
		System.out.println("모든지 다 잘먹는다");

	}
	@Override
	public void run() {
		System.out.println("잘 달리지 못한다");

	}
}
