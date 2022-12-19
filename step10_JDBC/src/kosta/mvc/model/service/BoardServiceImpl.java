package kosta.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.BoardDTO;

public class BoardServiceImpl implements BoardService {

	public BoardServiceImpl() {
		
	}
	
	@Override
	public List<BoardDTO> boardSelectAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardDTO> boardSelectBySubject(String keyWord) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardDTO boardSelectByNo(int boardNo) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void boardInsert(BoardDTO boardDTO) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void boardUpdate(BoardDTO boardDTO) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void boardDelete(int boardNo) throws SQLException {
		// TODO Auto-generated method stub

	}

}
