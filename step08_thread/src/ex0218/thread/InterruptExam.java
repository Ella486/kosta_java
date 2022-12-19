package ex0218.thread;

public class InterruptExam {

	public static void main(String[] args) {
		System.out.println("���� ����**********************");
		
		Thread th = new Thread(()->{
				try {
						while(true) {
							System.out.println("Thread ������.......");
							
								Thread.sleep(1);//0.001�� ���
							}
				}catch(InterruptedException e){
					e.printStackTrace();
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
