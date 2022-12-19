package ex0218.thread;

public class InterruptedExam {

	public static void main(String[] args) {
		System.out.println("���� ����**********************");
		
		Thread th = new Thread(()->{
			
						while(true) {
							System.out.println("Thread ������.......");
							if(Thread.interrupted()) {
								break;
							}
						}
			
				});
		
		th.start();
		
		//3�ʰ� ������ ���� thread�� �����ϰ� �ʹ�!!
		try {
			Thread.sleep(3000); //3��
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		//������ �����ϰ� �ʹ�.
		th.interrupt(); //�������� InterruptedException �߻����Ѽ� �����ϰ� �����ϴ� ���
		
		System.out.println("���� ��**********************");

	}

}
