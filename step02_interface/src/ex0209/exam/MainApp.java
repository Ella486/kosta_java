package ex0209.exam;

public class MainApp {
	BoardInterface bif;//�ʵ带 �̿��� ������
	
	public static void main(String[] args) {
		new MainApp();

	}
	
	public MainApp() {
		bif = new FreeBoardImpl();
		test(bif);
		
		bif = new QABoardImpl();
		test(bif);
		
		bif = new UploadBoardImpl();
		test(bif);
		
		System.out.println("--------------�͸�����ü---------------------");
		
		bif = new BoardInterface() {
			
			@Override
			public boolean update(Board board) {
				System.out.println("���� �����ϱ� �Դϴ�.....");
				return false;
			}
			
			@Override
			public Board selectByNo(int no) {
				System.out.println("���� �˻��ϱ� �Դϴ�.....");
				return null;
			}
			
			@Override
			public boolean insert(Board board) {
				System.out.println("���� ����ϱ� �Դϴ�.....");
				return false;
			}
		};
		
		test(bif);
		
	}

	public void test(BoardInterface boardInterface) {//�Ű������� �̿��� ������(Free, QA, Upload)
		//���
		boardInterface.insert(new Board (10, "����", "interface", "interface ����ִ�"));
		
		//����
		boardInterface.update(new Board (10, "����", "�������", "�������"));
		
		//�˻�
		boardInterface.selectByNo(5);
		
		boardInterface.delete(10); //default �޼ҵ�
		
		BoardInterface.selctAll(); // static �޼ҵ� ȣ�� (������ü �ʿ����)
		
		System.out.println("------------------------------------------------");
	}
	
}









