package ex0209.abstractex;

public class MainApp {

	private static Animal animal;

	public static void main(String[] args) {
		Animal animal = null; //필드를 이용한 다형성

		animal = new Cat("고양이" , "흰색", 4);
		test(animal);
		
		System.out.println("-----------------------------------");
		
		animal = new Pig("돼지" , "핑크");
		test(animal);
		
		System.out.println("-----------------------------------");
		
		animal = new Puppy("강아지", "흰색");
		test(animal);
		
		
	}

	public static void test(Animal animal) {//매개변수를 이용한 다형성
		animal.sound();
		animal.eat();
		animal.run();
		
		System.out.println();
		
		System.out.println(animal); //animal.toSting()호출
		
		//Cat 에 있는 leg을 찍고 싶다.
		if(animal instanceof Cat) {
			Cat cat = (Cat)animal;
			System.out.println("다리수: " + cat.getLegs() + "개");
		}
	}
	
}
