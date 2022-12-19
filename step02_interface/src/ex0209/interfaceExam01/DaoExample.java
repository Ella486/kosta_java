package ex0209.interfaceExam01;

public class DaoExample {
	public static void dbWork(DataAccessObject dao) {//OracleDao, MySqlDao
		dao.select();
		dao.insert();
		dao.update();
		dao.delete();
	}
	
	
	public static void main(String[] args) {
		dbWork(new OracleDao());
		dbWork(new MySqlDao());
	}

}
