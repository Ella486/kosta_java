package ex0209.exam;
/**
 * �����Խ���...........
 * */
public class FreeBoardImpl implements BoardInterface {

	@Override
	public boolean insert(Board board) {
		// ���
		System.out.println("FreeBoardImpl�� insert call.....................");
		return false;
	}

	@Override
	public boolean update(Board board) {
		System.out.println("FreeBoardImpl�� update call.....................");
		return false;
	}

	@Override
	public Board selectByNo(int no) {
		System.out.println("FreeBoardImpl�� selectByNo call.....................");
		return null;
	}

	@Override
	public int delete(int no) {
		System.out.println("FreeBoardImpl�� delete �Դϴ�.....................");
		return 2;
	}

	
}
