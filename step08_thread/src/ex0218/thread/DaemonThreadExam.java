package ex0218.thread;

/**
 * ���󽺷��� 
 *  : ���ν������� ���������� �ϴ� �������
 *    ���� �����尡 ����Ǹ� �ڵ����� ���󽺷��嵵 �����
 * */
public class DaemonThreadExam {

	public static void main(String[] args) {
		System.out.println("*********���� ����*********");
		
		Runnable r = ()->{
			while(true) {
				System.out.println("DaemonThread �Դϴ�.....");
				try {
					Thread.sleep(300);//0.3��
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}
			
		};
		
		Thread th = new Thread(r);
		th.setDaemon(true); //�� �����尡 ����� �� ���󽺷��嵵 ���������
		th.start();
		try {
			Thread.sleep(4000); //4��
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("*********���� ��*********");
	}

}
