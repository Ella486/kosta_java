package ex0208.inheritanceExam03;
/**
�����̸�: �̸���
��¥: 22.02.08
���� : 7�� ��� Ȯ�ι��� 7��
 */
public class SnowTireExample {

	public static void main(String[] args) {
		SnowTire snowTire = new SnowTire();
		Tire tire = snowTire;//�ڵ�Ÿ�Ժ�ȯ
		
		snowTire.run();
		tire.run();
	}
}
	
