package com.spring.edu.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.edu.vo.BoardVO;

@Repository
public interface BoardMapper {
	public List<BoardVO> getBoardList(BoardVO boardVO);
	
	public void insertBoard(BoardVO boardVO);
	
	public BoardVO getBoard(int seq);

	public void updateBoardCnt(int seq);
	
	public void updateBoard(BoardVO boardVO);
	
	public void deleteBoard(int seq);
}
