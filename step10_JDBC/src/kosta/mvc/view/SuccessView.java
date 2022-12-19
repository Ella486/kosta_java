package kosta.mvc.view;

import java.util.List;

import kosta.mvc.model.dto.BoardDTO;

public class SuccessView {
	
	public SuccessView() {
		
	}
	
	/**
	 * 전체 출력
	 */
	public static void selectPrint(List<BoardDTO> list) {
		
		  for(BoardDTO boardDTO : list) {
	           System.out.println(boardDTO);
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
	
	
}//클래스 끝
