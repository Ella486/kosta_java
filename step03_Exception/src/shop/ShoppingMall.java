package shop;

public class ShoppingMall {
	
	public void enter(int age) throws AgeCheckException {
		if(age>18) {
			System.out.println("���� �ϽŰ� ȯ���մϴ�");
		}else {
			AgeCheckException ae = new AgeCheckException("�ֵ��� ����");
			throw ae;
		}
	}

}
