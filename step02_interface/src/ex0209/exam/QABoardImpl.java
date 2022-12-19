package ex0209.exam;

public class QABoardImpl implements BoardInterface {

	@Override
	public boolean insert(Board board) {
		System.out.println("QABoardImpl¿« insert call.....................");
		return false;
	}

	@Override
	public boolean update(Board board) {
		System.out.println("QABoardImpl¿« update call.....................");
		return false;
	}

	@Override
	public Board selectByNo(int no) {
		System.out.println("QABoardImpl¿« selectByNo call.....................");
		return null;
	}

}
