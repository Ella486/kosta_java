package ex0209.exam;

/**
 * 모든 게시판 유형이 공통으로 사용하게될 메소드 제공(규격서 역할)
 * */

public interface BoardInterface {
	/**
	 * 등록하기
	 * */
	boolean insert(Board board);
	
	/**
	 * 수정하기
	 * */
	boolean update(Board board);
	
	/**
	 * 글번호 검색하기
	 * */
	Board selectByNo(int no);
	//////////////////////////////////////////////////////
	/**
	 * java 1.8 version 추가 문법
	 *  1) static 메소드
	 *  	: interface 안에 body 있는 메소드를 선언!
	 *  	: 구현객체 없이 바로 interface이름.메소드 이름() 호출가능!!
	 *  2) default 메소드
	 *  	: interface안에 body 있는 메소드를 선언!
	 *  	: 반드시 구현객체가 있어야 호출 가능!!
	 *  - 추가된 이유
	 *  	: 유지보수할 때 중간에 interface에 메소드가 추가 되면
	 *  	  이미 구현된 모든 클래스에서 재정의해야하는 번거로움이 있다.
	 *  	  그러나, static, default 메소드 형태로 추가하면 필요한 곳에서만 재정의하면 된다.
	 *  
	 *  	  개발시에 모든 구현클래스들이 공통으로 사용하게 되는 기능이 있다면
	 *  	  interface 안에 미리 static, default 선언해 놓으면 재정의 없이 그냥 사용 가능
	 * */

	/**
	 * 삭제 기능 추가 !!--- Free 만 필요
	 * */
	default int delete(int no) {
		System.out.println("공통의 삭제 기능입니다.");
		return 1;
	}
	
	static Board[] selctAll() {
		System.out.println("공통의 전체검색 기능입니다.");
		return null;
	}
	
}












