package ex0208.inheritanceExam03;
/**
본인이름: 이명진
날짜: 22.02.08
주제 : 7장 상속 확인문제 7번
 */
public class SnowTireExample {

	public static void main(String[] args) {
		SnowTire snowTire = new SnowTire();
		Tire tire = snowTire;//자동타입변환
		
		snowTire.run();
		tire.run();
	}
}
	
