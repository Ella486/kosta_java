package ex0207.sample02;
/**
�����̸�: �̸���
��¥: 22.02.07
���� :Employee MVC ���� �����
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
		System.out.println(getEmpName() + "����� �������� �Դϴ�.");
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(super.toString());
		sb.append("|" + timePay);
		
		return sb.toString();
	}
	
}
