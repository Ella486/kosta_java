package ex0228.dao;

/**
 * DB���� ������ ����ʵ�� ����
 * */
public interface DBProperties {
	/*public static final*/ String DRIVER_NAME = ("oracle.jdbc.driver.OracleDriver"); //����� �տ� �����ص� ��
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user_id= "c##scott";
	String user_pwd= "tiger";
}

