package ex0208.inheritanceExam02;
/**
본인이름: 이명진
날짜: 22.02.08
주제 : 7장 상속 확인문제 6번
 */
public class Parent {
	public String nation;

	public Parent() {
		this("대한민국");
		System.out.println("Parent() call");
	}

	public Parent(String nation) {
		this.nation = nation;
		System.out.println("Parent(String nation) call");
	}
	
}
