package mvc;
/**
본인이름: 이명진
날짜: 22.2.10
주제 : Exception MVC구조
*/
/**
 * 등록, 수정, 삭제에 오류가 발생했을 때 처리 할 예외 클래스
 * */
public class DMLException extends Exception{
	
	public DMLException() { }
	
	public DMLException(String message) {
		super(message);
	}
}
