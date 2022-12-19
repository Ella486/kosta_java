package kosta.mvc.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import kosta.mvc.model.dto.BoardDTO;
import kosta.mvc.model.util.DbUtil;

public class BoardDAOImpl implements BoardDAO {
	
	public BoardDAOImpl(){
		
	}

	@Override
	public List<BoardDTO> boardSelectAll() throws SQLException {
		
		return null;
	}

	@Override
	public List<BoardDTO> boardSelectBySubject(String keyWord) throws SQLException {
		
		return null;
	}

	@Override
	public BoardDTO boardSelectByNo(int boardNo) throws SQLException {
		
		return null;
	}

	@Override
	public int boardInsert(BoardDTO boardDTO) throws SQLException {
		
		return 0;
	}

	@Override
	public int boardUpdate(BoardDTO boardDTO) throws SQLException {
		
		return 0;
	}

	@Override
	public int boardDelete(int boardNo) throws SQLException {
		
		return 0;
	}

}
