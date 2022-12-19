package ex0217.lamda;

public class ThreadLamdaExam {

	public static void main(String[] args) {
		System.out.println("****메인 시작 합니다****");
		
		Runnable rb = ()->{
			Thread th = Thread.currentThread();
			for(char ch='A'; ch<='z' ; ch++) {
				System.out.println(th.getName() + "====>" + ch);
				
				/*try {
					Thread.sleep(100); // 1000일 때 1초 쉼, 100일 때 0.1초 쉼
				}catch(InterruptedException e) {
					e.printStackTrace();
				}*/
				
				Thread.yield();
				
			}
			System.out.println(th.getName() + "End************");
		};
		
		Thread th = new Thread(rb, "알파벳 Thread");
		th.start();
		
		new Thread(()->{
			//기능
			Thread th2 = Thread.currentThread();
			for(int i =0; i<=100; i++) {
				System.out.println(th2.getName() + "====> " + i);	
				
			}
			System.out.println(th2.getName() + "End************");
			
		} , "숫자 Thread").start();
		
		System.out.println("****메인 종료 합니다*****");
	}

}


