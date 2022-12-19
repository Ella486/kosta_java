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
	 * ��ü�˻�
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
	 * ���� �ش��ϴ� �˻�
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
	 * �۹�ȣ�� �ش��ϴ� �˻�
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
	 * �Խù� ����ϱ�
	 * */
	public static void boardInsert(BoardDTO board) {
		try {
			boardService.boardInsert(board);
			SuccessView.messagePrint("��ϵǾ����ϴ�.");
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * �Խù� �����ϱ�
	 * */
	public static void boardUpdate(BoardDTO board) {
		try {
			boardService.boardUpdate(board);
			SuccessView.messagePrint("�����Ǿ����ϴ�.");
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * �Խù� �����ϱ�
	 * */
	public static void boardDelete(int boardNo) {
		try {
			boardService.boardDelete(boardNo);
			SuccessView.messagePrint("�����Ǿ����ϴ�.");
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	
	/**
	 * ��� ���
	 * */
	public static void replyInsert(ReplyDTO replyDTO) {
		try {
			boardService.replyInsert(replyDTO);
			SuccessView.messagePrint(replyDTO.getBoardNo()+"����� ��ϵǾ����ϴ�.");
		} catch (SQLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	
	
	/**
	 * �θ���� ��������˻�
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
	
	
	

}//Ŭ���� ��
