package ex0228.dao;

/**
 * DB설정 정보를 상수필드로 관리
 * */
public interface DBProperties {
	/*public static final*/ String DRIVER_NAME = ("oracle.jdbc.driver.OracleDriver"); //상수는 앞에 생략해도 됨
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user_id= "c##scott";
	String user_pwd= "tiger";
}

