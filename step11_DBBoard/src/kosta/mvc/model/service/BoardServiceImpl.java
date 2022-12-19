package kosta.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dao.BoardDAO;
import kosta.mvc.model.dao.BoardDAOImpl;
import kosta.mvc.model.dto.BoardDTO;
import kosta.mvc.model.dto.ReplyDTO;

public class BoardServiceImpl implements BoardService {

	private BoardDAO boardDAO = new BoardDAOImpl();
	
	@Override
	public List<BoardDTO> boardSelectAll() throws SQLException {
		List<BoardDTO> list = boardDAO.boardSelectAll();
		//dao에 나온 결과를 가지고 제어
		if(list.size()==0 || list.isEmpty()) {
			throw new SQLException("게시물의 정보가 없어 검색할 수가 없습니다.");
		}
		
		return list;
	}

	@Override
	public List<BoardDTO> boardSelectBySubject(String keyWord) throws SQLException {
		List<BoardDTO> list = boardDAO.boardSelectBySubject(keyWord);
		
		if(list.isEmpty()) {
			throw new SQLException(keyWord + "에 해당하는 게시물의 정보가 없어 검색할 수가 없습니다.");
		}
		return list;
	}

	@Override
	public BoardDTO boardSelectByNo(int boardNo) throws SQLException {
		BoardDTO board = boardDAO.boardSelectByNo(boardNo);

		if(board == null) {
			throw new SQLException ("게시판에 " + boardNo + "번 게시물이 없습니다");
		}
		return board;
		
		
	}

	@Override
	public void boardInsert(BoardDTO boardDTO) throws SQLException {
		int result = boardDAO.boardInsert(boardDTO);
		if(result==0) throw new SQLException("등록되지 않았습니다.");

	}

	@Override
	public void boardUpdate(BoardDTO boardDTO) throws SQLException {
		int result = boardDAO.boardUpdate(boardDTO);
		if(result==0) throw new SQLException("수정되지 않았습니다.");
	}

	@Override
	public void boardDelete(int boardNo) throws SQLException {
		int result = boardDAO.boardDelete(boardNo);

		if(result == 0) {
			throw new SQLException ("삭제되지 않았습니다");
		}
		

	}

	@Override
	public void replyInsert(ReplyDTO replyDTO) throws SQLException {
		int result = boardDAO.replyInsert(replyDTO);

		if(result == 0) {
			throw new SQLException ("댓글이 등록되지 않았습니다");
		}
		
	}

	@Override
	public BoardDTO replySelectByParentNo(int boardNo) throws SQLException {
		BoardDTO boardDTO = boardDAO.replySelectByParentNo(boardNo);

		if(boardDTO == null) throw new SQLException ( boardNo + "번에 해당하는 부모글 정보가 없습니다");
		
		if(boardDTO.getRepliesList().size()==0)throw new SQLException(boardNo + "에 해당하는 댓글 정보가 없습니다.");
		
		return boardDTO;
		
	}

}
