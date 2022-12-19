package kosta.exam.model.service;

import java.util.Map;

import kosta.eaxm.model.dto.Board;

public interface BoardService {
	
	public Map<String, Map<String,Board>> getBoardList();
		
	public Map<String,Board> getBoardByKind(String aa);
	
	public Board getBoardByNo(String aa, int no);
	
	public boolean insertBoard(String aa, Board bd);
	
	public boolean duplicateByNo(String aa , int no);
	
	public boolean deleteBoard(String aa, int no);
	
	public boolean updateBoard(Board bd, String aa) ;
	
	
}
