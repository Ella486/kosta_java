package mvc;
/**
본인이름: 이명진
날짜: 22.2.10
주제 : Exception MVC구조
*/
/**
* 모델번호가 중복일 때 예외 클래스
* */
public class DuplicateException extends Exception {
	
	public DuplicateException() { }
	
	public DuplicateException(String message) { 
		super(message);
	}
}
