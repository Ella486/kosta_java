package ex0209.exam;

/**
 * ��� �Խ��� ������ �������� ����ϰԵ� �޼ҵ� ����(�԰ݼ� ����)
 * */

public interface BoardInterface {
	/**
	 * ����ϱ�
	 * */
	boolean insert(Board board);
	
	/**
	 * �����ϱ�
	 * */
	boolean update(Board board);
	
	/**
	 * �۹�ȣ �˻��ϱ�
	 * */
	Board selectByNo(int no);
	//////////////////////////////////////////////////////
	/**
	 * java 1.8 version �߰� ����
	 *  1) static �޼ҵ�
	 *  	: interface �ȿ� body �ִ� �޼ҵ带 ����!
	 *  	: ������ü ���� �ٷ� interface�̸�.�޼ҵ� �̸�() ȣ�Ⱑ��!!
	 *  2) default �޼ҵ�
	 *  	: interface�ȿ� body �ִ� �޼ҵ带 ����!
	 *  	: �ݵ�� ������ü�� �־�� ȣ�� ����!!
	 *  - �߰��� ����
	 *  	: ���������� �� �߰��� interface�� �޼ҵ尡 �߰� �Ǹ�
	 *  	  �̹� ������ ��� Ŭ�������� �������ؾ��ϴ� ���ŷο��� �ִ�.
	 *  	  �׷���, static, default �޼ҵ� ���·� �߰��ϸ� �ʿ��� �������� �������ϸ� �ȴ�.
	 *  
	 *  	  ���߽ÿ� ��� ����Ŭ�������� �������� ����ϰ� �Ǵ� ����� �ִٸ�
	 *  	  interface �ȿ� �̸� static, default ������ ������ ������ ���� �׳� ��� ����
	 * */

	/**
	 * ���� ��� �߰� !!--- Free �� �ʿ�
	 * */
	default int delete(int no) {
		System.out.println("������ ���� ����Դϴ�.");
		return 1;
	}
	
	static Board[] selctAll() {
		System.out.println("������ ��ü�˻� ����Դϴ�.");
		return null;
	}
	
}












