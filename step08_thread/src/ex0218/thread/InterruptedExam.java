package ex0218.thread;

public class InterruptedExam {

	public static void main(String[] args) {
		System.out.println("메인 시작**********************");
		
		Thread th = new Thread(()->{
			
						while(true) {
							System.out.println("Thread 동작중.......");
							if(Thread.interrupted()) {
								break;
							}
						}
			
				});
		
		th.start();
		
		//3초가 지나면 위의 thread를 종료하고 싶다!!
		try {
			Thread.sleep(3000); //3초
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		//스레드 종료하고 싶다.
		th.interrupt(); //스레드의 InterruptedException 발생시켜서 안전하게 종료하는 방법
		
		System.out.println("메인 끝**********************");

	}

}
