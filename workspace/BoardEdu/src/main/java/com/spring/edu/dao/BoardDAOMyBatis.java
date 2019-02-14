package com.spring.edu.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.edu.vo.BoardVO;

@Repository
public class BoardDAOMyBatis {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	private String namespace="board.";
	
	public List<BoardVO> getBoardList(BoardVO boardVO){
		return sqlSessionTemplate.selectList(namespace+"getBoardList", boardVO);
	}
	
	public void insertBoard(BoardVO boardVO) {
		sqlSessionTemplate.insert(namespace+"insertBoard", boardVO);
	}
	
	public BoardVO getBoard(int seq) {
		return sqlSessionTemplate.selectOne(namespace+"getBoard", seq);		
	}

	public void updateBoardCnt(int seq) {
		sqlSessionTemplate.update(namespace+"updateBoardCnt", seq);		
	}
	
	public void updateBoard(BoardVO boardVO) {
		sqlSessionTemplate.update(namespace+"updateBoard", boardVO);
	}
	
	public void deleteBoard(int seq) {
		sqlSessionTemplate.delete(namespace+"deleteBoard", seq);
	}
	
}
