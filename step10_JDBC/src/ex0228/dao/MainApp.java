package ex0228.dao;

public class MainApp {

	public static void main(String[] args) {
		System.out.println("1. 사원이름 검색 -------");
		EmpDAO dao = new EmpDAO();
		//dao.selectNames();
		System.out.println("2. 사원 등록 검색 ------ ");
		//dao.insert(new Emp(8002,"Jung","progamer", 3500));
		//dao.preparedInsert(new Emp(8004,"Jung","progamer", 3500));
		System.out.println("3. 전체 검색----");
		dao.preparedSelectAll();
	}

}
