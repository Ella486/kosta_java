package mvc;
/**
본인이름: 이명진
날짜: 22.2.10
주제 : Exception MVC구조
*/
/**
* Electroncis배열의 저장공간을 벗어 났을때 처리 할 예외 클래스
* */
public class ElectroncisArrayBoundsException extends Exception {
	
	public ElectroncisArrayBoundsException() {}
	
	public ElectroncisArrayBoundsException(String message) {
		super(message);
	}
	
}
