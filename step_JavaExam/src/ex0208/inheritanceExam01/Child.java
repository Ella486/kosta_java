package ex0208.inheritanceExam01;
/**
본인이름: 이명진
날짜: 22.02.08
주제 : 7장 상속 확인문제 5번
 */
public class Child extends Parent{
	private int studentNo;

	public Child(String name, int studentNo) {
		super(name);
		//this.name = name; //컴파일 에러
		/**Parent 클래스는 기본생성자가 없고 name을 매개값으로 받아 객체를 생성시키는 생성자만 있으므로
	     Child 생성자 첫줄에 super(name); 으로 Parent 클래스의 생성자를 호출해야함.*/
		this.studentNo = studentNo;
	}

}
