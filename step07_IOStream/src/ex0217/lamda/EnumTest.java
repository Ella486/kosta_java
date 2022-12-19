package ex0217.lamda;

public class EnumTest {

	public static void main(String[] args) {
		
		WeekDay day = WeekDay.MON;
		
		if(day == WeekDay.FRI) {
			
		}else {
			
		}
		
		System.out.println("---------------------------------");
		for(WeekDay w : WeekDay.values()) {
			System.out.println(w);
		}
		
	}

}
