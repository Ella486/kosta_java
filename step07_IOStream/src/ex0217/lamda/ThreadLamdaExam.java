package ex0217.lamda;

public class ThreadLamdaExam {

	public static void main(String[] args) {
		System.out.println("****���� ���� �մϴ�****");
		
		Runnable rb = ()->{
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
		};
		
		Thread th = new Thread(rb, "���ĺ� Thread");
		th.start();
		
		new Thread(()->{
			//���
			Thread th2 = Thread.currentThread();
			for(int i =0; i<=100; i++) {
				System.out.println(th2.getName() + "====> " + i);	
				
			}
			System.out.println(th2.getName() + "End************");
			
		} , "���� Thread").start();
		
		System.out.println("****���� ���� �մϴ�*****");
	}

}


