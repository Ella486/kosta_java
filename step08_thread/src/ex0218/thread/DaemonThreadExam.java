package ex0218.thread;

/**
 * 데몬스레드 
 *  : 메인스레드의 보조역할을 하는 스레드로
 *    메인 스레드가 종료되면 자동으로 데몬스레드도 종료됨
 * */
public class DaemonThreadExam {

	public static void main(String[] args) {
		System.out.println("*********메인 시작*********");
		
		Runnable r = ()->{
			while(true) {
				System.out.println("DaemonThread 입니다.....");
				try {
					Thread.sleep(300);//0.3초
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}
			
		};
		
		Thread th = new Thread(r);
		th.setDaemon(true); //주 스레드가 종료될 시 데몬스레드도 강제종료됨
		th.start();
		try {
			Thread.sleep(4000); //4초
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("*********메인 끝*********");
	}

}
