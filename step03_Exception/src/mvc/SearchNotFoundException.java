package mvc;
/**
본인이름: 이명진
날짜: 22.2.10
주제 : Exception MVC구조
*/
/**
* 검색결과가 찾을 수 없을때 처리 할 예외 클래스
* */
public class SearchNotFoundException extends Exception {
	
	public SearchNotFoundException() { }
	
	public SearchNotFoundException(String message) {
		super(message);
	}
	
}
