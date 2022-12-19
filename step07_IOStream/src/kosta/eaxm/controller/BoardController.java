package kosta.eaxm.controller;

import java.util.Map;

import kosta.exam.model.dto.Board;
import kosta.exam.model.service.BoardService;
import kosta.exam.model.service.BoardServiceImpl;
import kosta.exam.model.util.DuplicateException;
import kosta.exam.model.util.InexistentException;
import kosta.exam.view.FailView;
import kosta.exam.view.SuccessView;

public class BoardController {
	
	private static BoardService boardService = BoardServiceImpl.getinsatance();

	/**
	 * 전체검색
	 * */
	
	public static void getAllBoard() {
		//서비스 호출!! 그결과를 받아서 결과뷰에서 출력
		try {
			Map<String, Map<String, Board>> allBoardList = boardService.getBoardList();
			SuccessView.printBoard(allBoardList);
		}catch(InexistentException e){
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public static void getBoardByKind(String kind) {
		try {
			Map<String, Board> smalMap = boardService.getBoardByKind(kind);
			SuccessView.printBoardByKind(kind, smalMap);
			
		}catch(InexistentException e){
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public static void getBoardByNo(String kind, int no) {
		try {
			Board board = boardService.getBoardByNo(kind,no);
			SuccessView.printBoardByNo(board);
			
		}catch(InexistentException e){
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public static void insertBoard(String kind, Board board) {
		try {
			boardService.insertBoard(kind, board);
			SuccessView.printMessage("등록이 완료되었습니다.");
			
		}catch(InexistentException | DuplicateException e){
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public static void deleteBoard(String kind, int no) {
		try {
			boardService.deleteBoard(kind,no);
		
			SuccessView.printMessage(kind + "게시판의" + no + "번호가 삭제되었습니다.");
		}catch(InexistentException e){
			FailView.errorMessage(e.getMessage());
		}
		
	}
	
	public static void updateBoard(Board board, String kind) {
		try {
			boardService.updateBoard(board,kind);
			SuccessView.printMessage("수정이 완료되었습니다.");
			
		}catch(InexistentException e){
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public static void saveProperties() {
		boardService.propertiesFileStore();
		SuccessView.printMessage("저장이 완료되었습니다.");
	}
	
	
	
}
