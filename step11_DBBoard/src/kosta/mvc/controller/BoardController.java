package kosta.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import kosta.mvc.model.dto.BoardDTO;
import kosta.mvc.model.dto.ReplyDTO;
import kosta.mvc.model.service.BoardService;
import kosta.mvc.model.service.BoardServiceImpl;
import kosta.mvc.view.FailView;
import kosta.mvc.view.SuccessView;


public class BoardController {
	
	private static BoardService boardService = new BoardServiceImpl();

	/**
	 * 전체검색
	 * */
	public static void boardSelectByAll() {
		try {
			List<BoardDTO> list	= boardService.boardSelectAll();
			SuccessView.selectPrint(list);
			
		} catch (SQLException e) {
			//e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
		
	}
	
	/**
	 * 제목에 해당하는 검색
	 * */
	public static void boardSelectBySubject(String keyWord) {
		try {
			List<BoardDTO> list = boardService.boardSelectBySubject(keyWord);
			SuccessView.selectPrint(list);
			
		}catch(SQLException e){
			FailView.errorMessage(e.getMessage());
		}
		
	}
	
	/**
	 * 글번호에 해당하는 검색
	 * */
	public static void boardSelectByNo(int boardNo) {
		try {
			BoardDTO board = boardService.boardSelectByNo(boardNo);
			SuccessView.selectByNoPrint(board);
			
		}catch(SQLException e){
			FailView.errorMessage(e.getMessage());
		}
       
		
	}
	/**
	 * 게시물 등록하기
	 * */
	public static void boardInsert(BoardDTO board) {
		try {
			boardService.boardInsert(board);
			SuccessView.messagePrint("등록되었습니다.");
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * 게시물 수정하기
	 * */
	public static void boardUpdate(BoardDTO board) {
		try {
			boardService.boardUpdate(board);
			SuccessView.messagePrint("수정되었습니다.");
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * 게시물 삭제하기
	 * */
	public static void boardDelete(int boardNo) {
		try {
			boardService.boardDelete(boardNo);
			SuccessView.messagePrint("삭제되었습니다.");
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	
	/**
	 * 댓글 등록
	 * */
	public static void replyInsert(ReplyDTO replyDTO) {
		try {
			boardService.replyInsert(replyDTO);
			SuccessView.messagePrint(replyDTO.getBoardNo()+"댓글이 등록되었습니다.");
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	
	
	/**
	 * 부모글의 댓글정보검색
	 * */
	public static void replySelectByParentNo(int boardNo) {
		try {
			BoardDTO boardDTO = boardService.replySelectByParentNo(boardNo);
			SuccessView.selectReplyPrint(boardDTO);
			//SuccessView.messagePrint();
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	
	

}//클래스 끝
