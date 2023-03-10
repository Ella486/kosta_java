package kosta.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import kosta.mvc.model.dto.BoardDTO;
import kosta.mvc.model.dto.ReplyDTO;
import kosta.mvc.model.util.DbUtil;

public class BoardDAOImpl implements BoardDAO {
	
	private Properties proFile = DbUtil.getProFile();

	@Override
	public List<BoardDTO> boardSelectAll() throws SQLException {
		Connection con =null;
		PreparedStatement ps =null;
		ResultSet rs = null; //select 문일 때만 사용
		List<BoardDTO> list = new ArrayList<BoardDTO>(); //리턴값
		String sql = proFile.getProperty("board.selectAll"); //select * from board order by board_no desc
		try {
			con =DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				//열의 정보를 가져와서 BoardDTO에 담는다.
				BoardDTO dto = new BoardDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				
				//BoardDTO를 list에 추가한다.
				list.add(dto);
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		return list;
	}

	@Override
	public List<BoardDTO> boardSelectBySubject(String keyWord) throws SQLException {
		Connection con =null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		List<BoardDTO> list = new ArrayList<BoardDTO>(); //리턴값
		String sql = proFile.getProperty("board.selectBySubject"); //select * from board where subject like ?
		try {
			con =DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%"+keyWord+"%");//?값
			rs = ps.executeQuery();
			while(rs.next()) {//결과가 여러개가 나올 수 있어서 while문으로 쓰기
				//열의 정보를 가져와서 BoardDTO에 담는다.
				BoardDTO dto = new BoardDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				
				//BoardDTO를 list에 추가한다.
				list.add(dto);
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		
		return list;
	}

	@Override
	public BoardDTO boardSelectByNo(int boardNo) throws SQLException {
		Connection con =null;
		PreparedStatement ps =null;
		ResultSet rs = null; 
		BoardDTO dto = null;
		String sql = proFile.getProperty("board.selectByNo"); //select * from board where board_no = ? 
		try {
			con =DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, boardNo); //?값
			rs = ps.executeQuery();
			if(rs.next()) {//한번만 나가니까 while이 아니라 if 써야함
				//열의 정보를 가져와서 BoardDTO에 담는다.
				dto = new BoardDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				System.out.println(dto.getContent());
				//BoardDTO를 list에 추가한다.
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return dto;
	}

	@Override
	public int boardInsert(BoardDTO boardDTO) throws SQLException {
		Connection con=null;
		PreparedStatement ps =null;
		int result =0;
		String sql = proFile.getProperty("board.insert"); //insert into board ~
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			//?의 개수만큼 순서대로 setXxxx설정 필요
			ps.setString(1, boardDTO.getSubject());
			ps.setString(2, boardDTO.getWriter());
			ps.setString(3, boardDTO.getContent());
			
			result = ps.executeUpdate();
			
			
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int boardUpdate(BoardDTO boardDTO) throws SQLException {//JDBC대신 - ORM(Mybatis, JPA)
		Connection con=null;
		PreparedStatement ps =null;
		int result =0;
		String sql = proFile.getProperty("board.updateByNo"); //update board set content = ? where board_no = ?
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			//?의 개수만큼 순서대로 setXxxx설정 필요
			ps.setString(1, boardDTO.getContent());
			ps.setInt(2, boardDTO.getBoardNo());
			
			
			result = ps.executeUpdate();
			
			
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int boardDelete(int boardNo) throws SQLException {
		Connection con=null;
		PreparedStatement ps =null;
		int result =0;
		String sql = proFile.getProperty("board.deleteByNo"); //delete from board where board_no = ?
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			//?의 개수만큼 순서대로 setXxxx설정 필요
			ps.setInt(1,boardNo);
			
			
			result = ps.executeUpdate();
			
			
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int replyInsert(ReplyDTO replyDTO) throws SQLException {//댓글내용, 부모글번호
		Connection con=null;
		PreparedStatement ps =null;
		int result =0;
		String sql = proFile.getProperty("reply.insert"); //insert into reply values(reply_no_seq.nextval, ?, ?, sysdate);
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			//?의 개수만큼 순서대로 setXxxx설정 필요
			ps.setString(1, replyDTO.getReplyContent());
			ps.setInt(2, replyDTO.getBoardNo());
			
			
			result = ps.executeUpdate();
			
			
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public BoardDTO replySelectByParentNo(int boardNo) throws SQLException {
		Connection con =null;
		PreparedStatement ps =null;
		ResultSet rs = null; 
		BoardDTO dto = null;
		String sql = proFile.getProperty("board.selectByNo");//select * from board where board_no = ? 
		try {
			con = DbUtil.getConnection();
			ps = con.prepareStatement(sql);
			//?의 개수만큼 순서대로 setXxxx설정 필요
			ps.setInt(1, boardNo);
			rs = ps.executeQuery();
			if(rs.next()) {
				dto = new BoardDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				
				//댓글 저장
				List<ReplyDTO> replyList = this.replySelect(con, boardNo);
				dto.setRepliesList(replyList);
				
			}
		} finally {
			DbUtil.dbClose(con, ps,rs);
		}
		return dto;
	}//메소드 끝
	
	/**
	 * 부모글에 해당하는 댓글정보 가져오기
	 * select * from reply where board_no=?
	 * */
	private List<ReplyDTO> replySelect(Connection con, int boardNo)throws SQLException {
		
		PreparedStatement ps =null;
		ResultSet rs = null; 
		List<ReplyDTO> list =new ArrayList<ReplyDTO>();
		String sql = proFile.getProperty("reply.selectByboardNo");
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, boardNo);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				ReplyDTO reply = new ReplyDTO(rs.getInt(1), rs.getString(2),rs.getInt(3),rs.getString(4));
				list.add(reply);
			}
		} finally {
			DbUtil.dbClose(null, ps,rs);
		}
		return list;
	}
	
	
	

}
