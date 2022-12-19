package ex0209.exam;

public class UploadBoardImpl implements BoardInterface {

	@Override
	public boolean insert(Board board) {
		System.out.println("UploadBoardImpl¿« insert call.....................");
		return false;
	}

	@Override
	public boolean update(Board board) {
		System.out.println("UploadBoardImpl¿« update call.....................");
		return false;
	}

	@Override
	public Board selectByNo(int no) {
		System.out.println("UploadBoardImpl¿« selectByNo call.....................");
		return null;
	}

}
