package ex0207.sample02;
/**
본인이름: 이명진
날짜: 22.02.07
주제 :Employee MVC 구조 만들기
*/

public class PartTime extends Employee{
	private int timePay;
	
	public PartTime() {}
		
	
	public PartTime(int empNo, String empName, String job, int mgr, String hiredate, String deptName, int timePay) {
		super(empNo, empName, job, mgr, hiredate, deptName);
		
		this.timePay = timePay;
	}

	public int getTimePay() {
		return timePay;
	}

	public void setTimePay(int timePay) {
		this.timePay = timePay;
	}
	
	@Override
	public void message() {
		System.out.println(getEmpName() + "사원은 비정규직 입니다.");
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(super.toString());
		sb.append("|" + timePay);
		
		return sb.toString();
	}
	
}
