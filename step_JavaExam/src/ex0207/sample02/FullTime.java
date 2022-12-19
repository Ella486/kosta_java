package ex0207.sample02;
/**
�����̸�: �̸���
��¥: 22.02.07
���� :Employee MVC ���� �����
*/



public class FullTime extends Employee{
	
	private int salary;
	private int bonus;
	
	public FullTime() {}

	
	public FullTime(int empNo, String empName, String job, int mgr, String hiredate, String deptName, int salary,
			int bonus) {
		super(empNo, empName, job, mgr, hiredate,deptName);//�θ�Ŭ������ �����ڸ� ȣ��(�����ڱ����� ù�ٿ����� ����)
		
		this.salary = salary;
		this.bonus = bonus;
	}

	
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
	@Override
	public void message() {
		System.out.println(getEmpName() + "����� ������ �Դϴ�.");
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(super.toString());
		sb.append("|" + salary);
		sb.append("|" + bonus);
		
		return sb.toString();
	}

}
