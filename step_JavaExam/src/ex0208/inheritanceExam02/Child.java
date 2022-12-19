package ex0208.inheritanceExam02;
/**
본인이름: 이명진
날짜: 22.02.08
주제 : 7장 상속 확인문제 6번
 */
public class Child extends Parent{
	private String name;

	public Child() {
		this("홍길동");
		System.out.println("Child() call");
	}

	public Child(String name) {
		super();
		this.name = name;
		System.out.println("Child(String name) call");
	}
	
}
