package ex0207.sample02;
/**
�����̸�: �̸���
��¥: 22.02.07
���� :Employee MVC ���� �����
*/

/**
* FullTime�� PartTime ��ü�� �������� ���� �Ӽ��� �޼ҵ带 ���� 
*/
public class Employee {
	private int empNo;
	private String empName;
	private String job;
	private int mgr;
	private String hiredate;
	private String deptName;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int empNo, String empName, String job, int mgr, String hiredate, String deptName) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.deptName = deptName;
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
	public void setEmpName(String empName) {
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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(empNo + "|");
		sb.append(empName + "|");
		sb.append(job + "|");
		sb.append(mgr + "|");
		sb.append(hiredate + "|");
		sb.append(deptName );
		
		return sb.toString();
	}
	
	
	public void message() {
		
	}
	
}
