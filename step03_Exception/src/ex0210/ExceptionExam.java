package ex0210;

public class ExceptionExam {

	public static void main(String[] args) {
		System.out.println("*************���ν���**************");
		try {
		String data = args[0]; //ArrayIndexOutOfBoundsException
		System.out.println("data =" + data);
		
		int no = Integer.parseInt(data);
		System.out.println("���ڷ� ��ȭ:" + no);
		
		int result = 100/no;
		System.out.println("�������:" + result);
		
		}catch(ArrayIndexOutOfBoundsException e) {// e�� ���� : ���ܿ� ���õ� ������ ���� �ִ� ���۷�������
			//���ܰ� �߻����� �� �ؾ� �� ���ۼ�!
			System.out.println("������ �� ���� �������ּ���~~");
			System.out.println("e =" + e);//e.toString()ȣ�� - ����Ŭ�����̸�: ���ܸ޼���
			
		}catch(NumberFormatException  | NullPointerException e) { //����ó���� �ΰ� ���ÿ� �ϰ� ������ ����� but, ������ �ϳ��� ���
			System.out.println("���ڸ� �Է����ּ���....");
			System.out.println("���ܸ޼��� : " + e.getMessage());
		}catch(Exception e) { //������ �̿�!
			System.out.println("���ܰ� �߻��߾��~~");
			
			//������ ������ ���� detail�ϰ� ������ ���������� ������ �� ����Ѵ�.(������ �� ���� ��������� ������ ���� �����ʼ�,�����ʼ�)
			e.printStackTrace(); // �߻��� ������ ������ stack������ �׾Ƴ��Ҵٰ� �ѹ��� ����Ѵ�.
			
		}finally {
			System.out.println("���ܹ߻� ���ο� ������� �� ������ ���ؿ�~~");
			System.out.println("*************���γ�**************");
		}
		
		
		
	}

}
