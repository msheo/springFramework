package com.spring.edu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.edu.vo.BoardVO;

@Repository
public class BoardDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private String SELECT_BOARD="SELECT * FROM BOARD";
	private String INSERT_BOARD="INSERT INTO BOARD (TITLE, CONTENT, WRITER, CNT, REG_DATE) VALUES (?,?,?,0,SYSDATE)";
	private String GET_BOARD="SELECT * FROM BOARD WHERE SEQ=?";
	private String UPDATE_CNT="UPDATE BOARD SET CNT = (SELECT NVL(CNT,0)+1 FROM BOARD WHERE SEQ=?) WHERE SEQ=?;";
	private String UPDATE_BOARD="UPDATE BOARD SET TITLE=?, CONTENT=?, WRITER=? WHERE SEQ=?";
	private String DELETE_BOARD="DELETE FROM BOARD WHERE SEQ=?";
	private String SELECT_BOARD_T = "SELECT * FROM BOARD WHERE TITLE LIKE '%' || ? || '%' ";
	private String SELECT_BOARD_C = "SELECT * FROM BOARD WHERE CONTENT LIKE '%' || ? || '%'";
	
	public List<BoardVO> getBoardList(BoardVO boardVO){
		
		if(boardVO.getSearchCondition() != null && boardVO.getSearchCondition().equals("TITLE")) {
			return jdbcTemplate.query(SELECT_BOARD_T, new BoardMapper(), boardVO.getSearchKeyword());
		}else if(boardVO.getSearchCondition()!=null && boardVO.getSearchCondition().equals("CONTENT")) {
			return jdbcTemplate.query(SELECT_BOARD_C, new BoardMapper(), boardVO.getSearchKeyword());
			
		}
		
		List<BoardVO> list = jdbcTemplate.query(SELECT_BOARD, new BoardMapper());
		return list;
	}
	
	public void insertBoard(BoardVO boardVO) {
		jdbcTemplate.update(INSERT_BOARD, boardVO.getTitle(), boardVO.getContent(), boardVO.getWriter());
		
	}
	
	public BoardVO getBoard(int seq) {
		BoardVO boardVO = jdbcTemplate.queryForObject(GET_BOARD, new BoardMapper(), seq);
		return boardVO;
	}
	
	public void updateBoardCnt(int seq) {
		jdbcTemplate.update(UPDATE_CNT, seq, seq);
	}
	
	public void updateBoard(BoardVO boardVO) {
		jdbcTemplate.update(UPDATE_BOARD, boardVO.getTitle(), boardVO.getContent(), boardVO.getWriter(), boardVO.getSeq());
	}
	
	public void deleteBoard(int seq) {
		jdbcTemplate.update(DELETE_BOARD, seq);
	}
}

class BoardMapper implements RowMapper<BoardVO>{

	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO boardVO = new BoardVO();
		
		boardVO.setSeq(rs.getInt("SEQ"));
		boardVO.setTitle(rs.getString("TITLE"));
		boardVO.setContent(rs.getString("CONTENT"));
		boardVO.setWriter(rs.getString("WRITER"));
		boardVO.setCnt(rs.getInt("CNT"));
		boardVO.setRegDate(rs.getString("REG_DATE"));
		
		return boardVO;
	}
	
	
}