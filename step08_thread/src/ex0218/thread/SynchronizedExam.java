package ex0218.thread;

public class SynchronizedExam {

	public static void main(String[] args) {
		System.out.println("*********���� ����*************");
		
		Bank bank = new Bank();
		
		CustomerThread th1 = new CustomerThread(bank, "�Һ���", false);
		CustomerThread th2 = new CustomerThread(bank, "������", true);
		
		th1.start();
		th2.start();
		
		System.out.println("***********���� ��************");
		
	}

}
///////////////////////////////////////////////////////
/**
 * ���� Thread�� ������ ��ü
 * */
 class Bank{
	 int balance; //�ܾ�
	 /**
	  * @param : state�� true�� ��� �Ա�(������), false ���(�Һ���)
	  * 
	  * wait(); ���� ����ȭ���� �ִ� �����带 ��������
	  * notify(), notifyAll() : wait()�� ���� �������¿� �ִ� �����带 �����.
	  * 
	  *  * wait(), notify(), notifyAll()�� �ݵ�� ����ȭ��(synchronized)�ȿ����� ����Ѵ�.
	  * */
	 
	 public synchronized void balanceChange(String name, boolean state) {//������ �̸�, ��ݰ� �Ա� ���¸� �˷��ִ� ���� ����
		 if(state) {//�Ա�
			 if(balance == 0) {
			 //synchronized(this) {//this�� ������ü
				 System.out.print(name +"=====> ���� �ܾ� : " + balance +" , ");
				 balance++;
				 System.out.println(name +"=====> ���� �� �ݾ� : " + balance );
			 //}
			 }else {
				 try {
					 System.out.println(name + "�� ���� �����Դϴ�.");
					 wait(); //�������·� ����.
				 }catch(InterruptedException e){
					 e.printStackTrace();
				 } 
				 
			 }
			  
			 
		 }else {//���
			 if(balance>0) {
			 //synchronized(this) {
				 System.out.print(name +"=====> ���� �ܾ� : " + balance +" , ");
				 balance--;
				 System.out.println(name +"=====> ���� �� �ݾ� : " + balance );
			 //}
			 }else {
				 try {
					 System.out.println(name + "�� ���� �����Դϴ�.");
					 wait(); //�������·� ����.
				 }catch(InterruptedException e){
					 e.printStackTrace();
				 }
			 }//else ��
		 }//else ��
		 
		 notifyAll();//wait�� ���� �������¿� �ִ� ��� �����带 �����.
		 
	 }//�޼ҵ� ��
	 
 }// Ŭ���� ��
 ////////////////////////////////////////////////////////////////////////
 /**
  * Bank��� ��ü�� ����ϰԵ� �� (������,�Һ���) thread
  * */
 class CustomerThread extends Thread{
	 Bank bank;
	 boolean state;
	 CustomerThread(Bank bank, String name, boolean state){
		 super(name); //������ �̸�
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
 new CustomerThread(bank, "�Һ���", false); -�Һ���
 new CustomerThread(bank, "������", true); -������ */
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 