package ex0209.exam;

public class MainApp {
	BoardInterface bif;//필드를 이용한 다형성
	
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
		
		System.out.println("--------------익명구현객체---------------------");
		
		bif = new BoardInterface() {
			
			@Override
			public boolean update(Board board) {
				System.out.println("사진 수정하기 입니다.....");
				return false;
			}
			
			@Override
			public Board selectByNo(int no) {
				System.out.println("사진 검색하기 입니다.....");
				return null;
			}
			
			@Override
			public boolean insert(Board board) {
				System.out.println("사진 등록하기 입니다.....");
				return false;
			}
		};
		
		test(bif);
		
	}

	public void test(BoardInterface boardInterface) {//매개변수를 이용한 다형성(Free, QA, Upload)
		//등록
		boardInterface.insert(new Board (10, "희정", "interface", "interface 재미있다"));
		
		//수정
		boardInterface.update(new Board (10, "나영", "제목수정", "내용수정"));
		
		//검색
		boardInterface.selectByNo(5);
		
		boardInterface.delete(10); //default 메소드
		
		BoardInterface.selctAll(); // static 메소드 호출 (구현객체 필요없다)
		
		System.out.println("------------------------------------------------");
	}
	
}









