package kosta.exam.model.service;

import java.util.Map;

import kosta.eaxm.model.dto.Board;

public class BoardServiceImpl implements BoardService {
	private Map<String,Map<String, Board>> allBoardList;
	
	public static BoardServiceImpl getinsatance() {
		return null;
	}
	
	private BoardServiceImpl() {
		
	}
	

	@Override
	public Map<String, Map<String, Board>> getBoardList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Board> getBoardByKind(String aa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Board getBoardByNo(String aa, int no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertBoard(String aa, Board bd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean duplicateByNo(String aa, int no) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteBoard(String aa, int no) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateBoard(Board bd, String aa) {
		// TODO Auto-generated method stub
		return false;
	}

}
