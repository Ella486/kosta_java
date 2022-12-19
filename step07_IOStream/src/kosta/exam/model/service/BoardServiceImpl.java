package kosta.exam.model.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.TreeMap;

import kosta.exam.model.dto.ArchiveBoard;
import kosta.exam.model.dto.Board;
import kosta.exam.model.dto.PhotoBoard;
import kosta.exam.model.util.DuplicateException;
import kosta.exam.model.util.InexistentException;



public class BoardServiceImpl implements BoardService {
	
	private static BoardServiceImpl instance = new BoardServiceImpl();
	
	Map<String, Map<String, Board>> allBoardList=new TreeMap<String, Map<String,Board>>();
	/**
	 * 게시판들의 초기데이터를 로딩
	 * */
	private BoardServiceImpl() {
		
		Map<String, Board> archiveMap = new TreeMap<String, Board>();
		Map<String, Board> photoMap = new TreeMap<String, Board>();
		
		//1. ~.properties 파일을 로딩한다.
		ResourceBundle rb = ResourceBundle.getBundle("kosta/exam/model/service/archiveInfo");
		
		//2. 읽어온 value의  값을 (10,Java교안자료,이찬범,자바수업을 우한 자료,2017-03-27,java.ppt,200)을
		//콤마를 기준으로 분리해서(value.split(",") ) Board객체를 생성한다.
		for(String key :rb.keySet()) {
			String value = rb.getString(key);
			String v[] = value.split(",");
			Board board = new ArchiveBoard(Integer.parseInt(v[0]),v[1],v[2],v[3],v[4],v[5],Integer.parseInt(v[6]));
		
			//3. 생성된 Board를 kind종류에 해당하는 Map에 저장한다. - ~.put(key, value)
			archiveMap.put(key, board);
			
					
		}
		




		
		//photo 게시판
		 rb = ResourceBundle.getBundle("kosta/exam/model/service/photoInfo");
		 for(String key :rb.keySet()) {
				String value = rb.getString(key);
				String v[] = value.split(",");
				Board board = new PhotoBoard(Integer.parseInt(v[0]),v[1],v[2],v[3],v[4],v[5]);
				photoMap.put(key, board);
			}
		
		//allBoardList에 3번의 Map을 저장 - allBoardList.put(kind, Map)
		 allBoardList.put("archive", archiveMap);
		 allBoardList.put("photo", photoMap);
		 
		 System.out.println(allBoardList);
		
	}//생성자 끝
	/**public static void main(String[] args) {
		BoardServiceImpl.getinsatance();
	}*/
	
	
	public static BoardServiceImpl getinsatance() {
		return instance;
	}
	
	

	@Override
	public Map<String, Map<String, Board>> getBoardList() throws InexistentException{
		if(allBoardList == null || allBoardList.isEmpty()) {
			throw new InexistentException ("저장된 게시물의 정보가 존재하지 않습니다.");
		}
		
		return allBoardList;
	}

	@Override
	public Map<String, Board> getBoardByKind(String kind) throws InexistentException {
		Map<String, Board> smalMap = allBoardList.get(kind);
		
		if(smalMap==null) {
			throw new InexistentException (kind + "유형의 게시판은 존재하지 않습니다..");
		}else if(smalMap.isEmpty()){
			throw new InexistentException (kind + "유형의 게시물이 없습니다..");
		}
		/*if(kind.equals("archive")) {
			return allBoardList.get(kind);
		}else if(kind.equals("photo")) {
			return allBoardList.get(kind);
		}else {
			throw new InexistentException ("해당 게시판 없음.");
		}*/
		return smalMap;
	}

	@Override
	public Board getBoardByNo(String kind, int no) throws InexistentException {
		
		Map<String, Board> smalMap = this.getBoardByKind(kind);
		
		Board board = smalMap.get(String.valueOf(no)); //Integer.toString(no) , no+"" // int를 String으로 바꿀때
		
		if(board == null) {
			throw new InexistentException (kind + "유형의 게시판에 " + no + "번호 게시물이 없습니다..");
		}
		return board;
		
		/*if(kind.equals("archive")) {
			return allBoardList.get(kind).get(no+"");
		}else if(kind.equals("photo")) {
			return allBoardList.get(kind).get(no+"");
		}else {
			throw new InexistentException ("게시물이 없음.");
		}*/
	}

	@Override
	public void insertBoard(String kind, Board board) throws DuplicateException, InexistentException {
		//등록전에 kind가 있는지 체크!
		Map<String, Board> smalMap = this.getBoardByKind(kind);
		
		if(this.duplicateByNo(kind, board.getNo())) {
			throw new DuplicateException(kind + "유형의 게시판의 " + board.getNo() + "번호는 중복이르모 등록할 수 없습니다..");
		}
		smalMap.put(Integer.toString(board.getNo()), board);
		/*if(kind.equals("archive")|kind.equals("photo")) {
			if(duplicateByNo(kind, board.getNo())) {//중복
				throw new DuplicateException("너 글 중복!!");
			}else {//저장
				allBoardList.get(kind).put(board.getNo()+"", board);
			}
		}else {
			throw new InexistentException("존재하지 않는 게시판");
		}*/
	}

	
	public void propertiesFileStore() {
		Properties prop = new Properties();
		
		for (String key : allBoardList.keySet()) {
			//System.out.println(key+"Boad의 모든 게시물 LIST**********************");
			Map<String, Board> kindMap = allBoardList.get(key);
			
			TreeMap treeMap= (TreeMap<String,Board>)kindMap; //캐스팅하고 있음
			Iterator<String> it = treeMap.descendingKeySet().iterator(); //내림차순으로 하고 싶을 때
			while(it.hasNext()) {
				String k = it.next();//key
				//System.out.println("key = " + k +"[ " + kindMap.get(k)  +" ] ");	
				prop.setProperty(key+k, k +"[ " + kindMap.get(k)  +" ] ");
			}
				//prop.setProperty("test111", "132");
			System.out.println();	
		}
		
	     try{
	          OutputStream stream = new FileOutputStream("src/kosta/exam/model/service/test.properties");
	          prop.store(stream,"====ALL===");
	          stream.close();
	          System.out.println("---------------------------------====");
	     } catch(IOException ex){
	           ex.printStackTrace();

	     }
	}
	
	
	@Override
	public boolean duplicateByNo(String kind, int no) {
		
		if(allBoardList.get(kind).get(String.valueOf(no)) == null) {
			return false;//중복 아님.
		}else {
			return true;//중복
		}
	}

	@Override
	public void deleteBoard(String kind, int no) throws InexistentException {
		
		this.getBoardByNo(kind,no); //kind,no에 해당하는 정보를 찾는다.
		
		allBoardList.get(kind).remove(String.valueOf(no));
			/*if(kind.equals("archive")|kind.equals("photo")) {
				if(duplicateByNo(kind, no)) {
					allBoardList.get(kind).remove(no+"");
				}else {
					throw new InexistentException ("존재 하지 않는 게시물!!");
				}
			}else {
				throw new InexistentException ("삭제 실패!!");
			}*/
	}

	@Override
	public void updateBoard(Board board, String kind) throws InexistentException {
		Board b = this.getBoardByNo(kind,board.getNo());
		
		//kind에 Board를 찾았다..-> 수정하자 공통: 제목, 작성자, 내용 photo : imgNamearchive: fileName, fileSize
		if(board instanceof ArchiveBoard && b instanceof ArchiveBoard ) {
			ArchiveBoard castingB = (ArchiveBoard)b; //저장되어 있는 게시물
			ArchiveBoard castingBoard = (ArchiveBoard)board; //수정하려는 게시물의 정
			
			castingB.setSubject(castingBoard.getSubject());
			castingB.setWriter(castingBoard.getWriter());
			castingB.setContent(castingBoard.getContent());
			
			castingB.setFileName(castingBoard.getFileName());
			castingB.setFileSize(castingBoard.getFileSize());
				
		}else if(board instanceof PhotoBoard && b instanceof PhotoBoard ){
			PhotoBoard castingB = (PhotoBoard)b; //저장되어 있는 게시물
			PhotoBoard castingBoard = (PhotoBoard)board; //수정하려는 게시물의 정
			
			castingB.setSubject(castingBoard.getSubject());
			castingB.setWriter(castingBoard.getWriter());
			castingB.setContent(castingBoard.getContent());
			castingB.setImgName(castingBoard.getImgName());
			
			
		}else {
			throw new InexistentException ("수정되지 않았습니다. ==> 타입오류");
		}
		
		
		/*if(kind.equals("archive")|kind.equals("photo")) {
			if(duplicateByNo(kind, board.getNo())) {
				if(kind.equals("archive") && board instanceof ArchiveBoard) {
					allBoardList.get(kind).replace(board.getNo()+"", board);
				}else if(kind.equals("photo") && board instanceof PhotoBoard) {
					allBoardList.get(kind).replace(board.getNo()+"", board);
				}else {
					//System.out.println(bd.getClass());
					throw new InexistentException ("게시판 타입 오류");
				}
			}else {
				throw new InexistentException ("없는 게시물");
			}
		}else {
			throw new InexistentException ("존재하지 않는 게시판");
		}*/
		
	}

	

}
