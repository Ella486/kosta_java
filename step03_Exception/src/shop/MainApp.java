package shop;

import java.util.Random;

public class MainApp {

	public static void main(String[] args) {
		System.out.println("******Shop OPEN***************");
		ShoppingMall mall = new ShoppingMall();
		
		Random ran = new Random();
		for(int i=1; i<=10 ; i++) {
			//int age = (int)(Math.random() * 55) + 1;
			int age = ran.nextInt(55)+1;
			
			System.out.println("age:" + age);
			try {
				mall.enter(age);
			}catch(AgeCheckException e) {
				System.out.println(e.getMessage());
			}
		}
		
		System.out.println("******Shop OPEN***************");
		System.out.println("ÃÑ ¿¹¿Ü ¼Õ´Ô :" +AgeCheckException.count  + "¸í");
		
	}
	
		
}
