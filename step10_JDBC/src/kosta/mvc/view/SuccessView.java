package kosta.mvc.view;

import java.util.List;

import kosta.mvc.model.dto.BoardDTO;

public class SuccessView {
	
	public SuccessView() {
		
	}
	
	/**
	 * ��ü ���
	 */
	public static void selectPrint(List<BoardDTO> list) {
		
		  for(BoardDTO boardDTO : list) {
	           System.out.println(boardDTO);
	        }

			
	}
	
	/**
	 * �Խ��ǿ��� �۹�ȣ�� �ش��ϴ� �Խù� ����ϱ�
	 */
	public static void selectByNoPrint(BoardDTO boardDTO) {
		System.out.println(boardDTO);
	}
	
	
	/**
	 * ���, ����, �����ΰ�쿡 �����޽��� ���
	 */
	public static void messagePrint(String message) {
		System.out.println(message);
	}
	
	
}//Ŭ���� ��
