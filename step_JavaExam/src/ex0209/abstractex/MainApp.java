package ex0209.abstractex;

public class MainApp {

	private static Animal animal;

	public static void main(String[] args) {
		Animal animal = null; //�ʵ带 �̿��� ������

		animal = new Cat("�����" , "���", 4);
		test(animal);
		
		System.out.println("-----------------------------------");
		
		animal = new Pig("����" , "��ũ");
		test(animal);
		
		System.out.println("-----------------------------------");
		
		animal = new Puppy("������", "���");
		test(animal);
		
		
	}

	public static void test(Animal animal) {//�Ű������� �̿��� ������
		animal.sound();
		animal.eat();
		animal.run();
		
		System.out.println();
		
		System.out.println(animal); //animal.toSting()ȣ��
		
		//Cat �� �ִ� leg�� ��� �ʹ�.
		if(animal instanceof Cat) {
			Cat cat = (Cat)animal;
			System.out.println("�ٸ���: " + cat.getLegs() + "��");
		}
	}
	
}
