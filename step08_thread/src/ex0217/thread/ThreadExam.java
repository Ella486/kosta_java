package ex0217.thread;

public class ThreadExam {

	public static void main(String[] args) {
		System.out.println("*************���� �����մϴ�.*******************");
		NumberThread th1 = new NumberThread("ù��° thread");
		NumberThread th2 = new NumberThread("�ι�° thread");
		
		AlphaThread at = new AlphaThread();
		Thread th3 = new Thread(at, "����° thread");
		
		/*th1.run();
		th2.run();
		th3.run();*/
		
		th1.start();
		th2.start();
		th3.start();
		
		/*try {
			th1.join();//th1 �����尡 ����� ������ ���(������ν����尡 ��ٸ���.)
			
		}catch(InterruptedException e) {
			e.printStackTrace();
		} */
		
		
		System.out.println("����: " + th1.sum);
		
		System.out.println("*************���� �����մϴ�.*******************");
	}

}
////////////////////////////////////////////////////
/**
 * 1~100 ���� ����ϴ� Thread
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
				Thread.sleep(10); // 0.01�� ��� - �����ð��� ������ �ٽ� �غ���·� ����.
			}catch(InterruptedException e) {
				e.printStackTrace();
			}*/
			
			Thread.yield(); //�纸(�ٷ��غ����)
		}
		System.out.println(super.getName() + "End************");
	} 
	 
 }
 ////////////////////////////////////////////
 /**
  * A~Z ���� ����ϴ� Thread
  * */
 class AlphaThread implements Runnable{

	@Override
	public void run() {
		Thread th = Thread.currentThread();
		for(char ch='A'; ch<='z' ; ch++) {
			System.out.println(th.getName() + "====>" + ch);
			
			/*try {
				Thread.sleep(100); // 1000�� �� 1�� ��, 100�� �� 0.1�� ��
			}catch(InterruptedException e) {
				e.printStackTrace();
			}*/
			
			Thread.yield();
			
		}
		System.out.println(th.getName() + "End************");
	} 
		 
 }
/////////////////////////////////////////// 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 