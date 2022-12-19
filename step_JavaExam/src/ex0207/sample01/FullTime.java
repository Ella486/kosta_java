package ex0207.sample01;
/**
본인이름: 이명진
날짜: 22.02.07
주제 :Employee MVC 구조 만들기
*/

public class FullTime {
	private int empNo;
	private String empName; 
	private String job;
	private int mgr;
	private String hiredate;
	private String deptName;
	private int salary;
	private int bonus;
	
	public FullTime() {}
	
	public FullTime(int empNo, String empName, String job, int mgr, String hiredate, String deptName, int salary,
			int bonus) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.deptName = deptName;
		this.salary = salary;
		this.bonus = bonus;
	}

	
	public int getEmpNo() {
		return empNo;
	}



	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}



	public String getEmpName() {
		return empName;
	}



	public void seteName(String empName) {
		this.empName = empName;
	}



	public String getJob() {
		return job;
	}



	public void setJob(String job) {
		this.job = job;
	}



	public int getMgr() {
		return mgr;
	}



	public void setMgr(int mgr) {
		this.mgr = mgr;
	}



	public String getHiredate() {
		return hiredate;
	}



	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}



	public String getDeptName() {
		return deptName;
	}



	public void setDeptName(String deptName) {
		this.deptName = deptName;
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

	public void message() {
		System.out.println(empName + "사원은 정규직입니다.");
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(empNo + "|");
		builder.append(empName + "|");
		builder.append(job + "|");
		builder.append(mgr + "|");
		builder.append(hiredate + "|");
		builder.append(deptName + "|");
	    builder.append(salary + "|");
		builder.append(bonus + "|");
		
		return builder.toString();
	}
	
}
