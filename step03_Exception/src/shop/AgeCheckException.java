package shop;

public class AgeCheckException extends Exception {
	
	public static int count;
	
	public AgeCheckException() {}
	public AgeCheckException(String message) {
		super(message);
		count++;
	}
	
}

