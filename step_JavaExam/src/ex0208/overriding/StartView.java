package ex0208.overriding;
class StartView {

	public static void main(String[] args) {
		System.out.print("*****프로그램 시작합니다*******");
		System.out.println();
		MenuView mv = new MenuView(); //전역변수 초기화, 생성자 호출
		mv.printMenu();
		
	}
}
