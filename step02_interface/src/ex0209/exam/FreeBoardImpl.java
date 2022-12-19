package ex0209.exam;
/**
 * 자유게시판...........
 * */
public class FreeBoardImpl implements BoardInterface {

	@Override
	public boolean insert(Board board) {
		// 기능
		System.out.println("FreeBoardImpl의 insert call.....................");
		return false;
	}

	@Override
	public boolean update(Board board) {
		System.out.println("FreeBoardImpl의 update call.....................");
		return false;
	}

	@Override
	public Board selectByNo(int no) {
		System.out.println("FreeBoardImpl의 selectByNo call.....................");
		return null;
	}

	@Override
	public int delete(int no) {
		System.out.println("FreeBoardImpl의 delete 입니다.....................");
		return 2;
	}

	
}
