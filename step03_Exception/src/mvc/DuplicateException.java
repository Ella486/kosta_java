package mvc;
/**
�����̸�: �̸���
��¥: 22.2.10
���� : Exception MVC����
*/
/**
* �𵨹�ȣ�� �ߺ��� �� ���� Ŭ����
* */
public class DuplicateException extends Exception {
	
	public DuplicateException() { }
	
	public DuplicateException(String message) { 
		super(message);
	}
}
