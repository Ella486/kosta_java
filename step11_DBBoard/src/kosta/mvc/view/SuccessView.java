package kosta.mvc.view;

import java.util.List;

import kosta.mvc.model.dto.BoardDTO;
import kosta.mvc.model.dto.ReplyDTO;

public class SuccessView {
	
	
	/**
	 * 전체 출력
	 */
	public static void selectPrint(List<BoardDTO> list) {
		System.out.println("---Board List(" + list.size() + ") 개--------");
		  for(BoardDTO board : list) {
	           System.out.println(board); //board.toString() 호출
	        }

			
	}
	
	/**
	 * 게시판에서 글번호에 해당하는 게시물 출력하기
	 */
	public static void selectByNoPrint(BoardDTO boardDTO) {
		System.out.println(boardDTO);
	}
	
	
	/**
	 * 등록, 수정, 삭제인경우에 성공메시지 출력
	 */
	public static void messagePrint(String message) {
		System.out.println(message);
	}

	public static void selectReplyPrint(BoardDTO boardDTO) {
		System.out.println(boardDTO);
		System.out.println("댓글 개수: " + boardDTO.getRepliesList().size()+ "개 --------");
		for(ReplyDTO reply: boardDTO.getRepliesList()) {
			System.out.println("             --->" + reply);
		}
		
	}

	
	
}//클래스 끝
