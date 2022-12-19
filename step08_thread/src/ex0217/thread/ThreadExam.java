package ex0217.thread;

public class ThreadExam {

	public static void main(String[] args) {
		System.out.println("*************메인 시작합니다.*******************");
		NumberThread th1 = new NumberThread("첫번째 thread");
		NumberThread th2 = new NumberThread("두번째 thread");
		
		AlphaThread at = new AlphaThread();
		Thread th3 = new Thread(at, "세번째 thread");
		
		/*th1.run();
		th2.run();
		th3.run();*/
		
		th1.start();
		th2.start();
		th3.start();
		
		/*try {
			th1.join();//th1 스레드가 종료될 때까지 대기(현재메인스레드가 기다린다.)
			
		}catch(InterruptedException e) {
			e.printStackTrace();
		} */
		
		
		System.out.println("총합: " + th1.sum);
		
		System.out.println("*************메인 종료합니다.*******************");
	}

}
////////////////////////////////////////////////////
/**
 * 1~100 까지 출력하는 Thread
 * */
 class NumberThread extends Thread{
	 int sum;
	 public NumberThread(String name) {
		super(name);
	}
	 
	@Override
	public void run() {
		for(int i =0; i<=100; i++) {
			System.out.println(super.getName() + "====> " + i);
			sum+=i;
			
			/*try {
				Thread.sleep(10); // 0.01초 대기 - 일정시간이 끝나면 다시 준비상태로 간다.
			}catch(InterruptedException e) {
				e.printStackTrace();
			}*/
			
			Thread.yield(); //양보(바로준비상태)
		}
		System.out.println(super.getName() + "End************");
	} 
	 
 }
 ////////////////////////////////////////////
 /**
  * A~Z 까지 출력하는 Thread
  * */
 class AlphaThread implements Runnable{

	@Override
	public void run() {
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
	} 
		 
 }
/////////////////////////////////////////// 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 