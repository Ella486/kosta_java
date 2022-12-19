package ex0218.thread;

public class SynchronizedExam {

	public static void main(String[] args) {
		System.out.println("*********메인 시작*************");
		
		Bank bank = new Bank();
		
		CustomerThread th1 = new CustomerThread(bank, "소비자", false);
		CustomerThread th2 = new CustomerThread(bank, "생산자", true);
		
		th1.start();
		th2.start();
		
		System.out.println("***********메인 끝************");
		
	}

}
///////////////////////////////////////////////////////
/**
 * 여러 Thread가 공유할 객체
 * */
 class Bank{
	 int balance; //잔액
	 /**
	  * @param : state는 true인 경우 입금(생산자), false 출금(소비자)
	  * 
	  * wait(); 현재 동기화블럭에 있는 스레드를 중지상태
	  * notify(), notifyAll() : wait()에 의해 중지상태에 있는 스레드를 깨운다.
	  * 
	  *  * wait(), notify(), notifyAll()은 반드시 동기화블럭(synchronized)안에서만 사용한다.
	  * */
	 
	 public synchronized void balanceChange(String name, boolean state) {//스레드 이름, 출금과 입금 상태를 알려주는 상태 변수
		 if(state) {//입금
			 if(balance == 0) {
			 //synchronized(this) {//this는 공유객체
				 System.out.print(name +"=====> 현재 잔액 : " + balance +" , ");
				 balance++;
				 System.out.println(name +"=====> 증가 후 금액 : " + balance );
			 //}
			 }else {
				 try {
					 System.out.println(name + "님 중지 상태입니다.");
					 wait(); //중지상태로 간다.
				 }catch(InterruptedException e){
					 e.printStackTrace();
				 } 
				 
			 }
			  
			 
		 }else {//출금
			 if(balance>0) {
			 //synchronized(this) {
				 System.out.print(name +"=====> 현재 잔액 : " + balance +" , ");
				 balance--;
				 System.out.println(name +"=====> 감소 후 금액 : " + balance );
			 //}
			 }else {
				 try {
					 System.out.println(name + "님 중지 상태입니다.");
					 wait(); //중지상태로 간다.
				 }catch(InterruptedException e){
					 e.printStackTrace();
				 }
			 }//else 끝
		 }//else 끝
		 
		 notifyAll();//wait에 의해 중지상태에 있는 모든 스레드를 깨운다.
		 
	 }//메소드 끝
	 
 }// 클래스 끝
 ////////////////////////////////////////////////////////////////////////
 /**
  * Bank라는 객체를 사용하게될 고객 (생산자,소비자) thread
  * */
 class CustomerThread extends Thread{
	 Bank bank;
	 boolean state;
	 CustomerThread(Bank bank, String name, boolean state){
		 super(name); //스레드 이름
		 this.bank = bank;
		 this.state = state;
	 }
	 
	@Override
	public void run() {
		for(int i = 0; i<50; i++) {
		bank.balanceChange(super.getName(), state);
		}
		System.out.println(super.getName() + "END---------------------------");
	}
	 
 }
 
 /*Bank bank = new Bank();
 new CustomerThread(bank, "소비자", false); -소비자
 new CustomerThread(bank, "생산자", true); -생산자 */
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 