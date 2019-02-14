package com.spring.edu.service;

import java.util.List;

import com.spring.edu.vo.BoardVO;

public interface BoardService {
	public List<BoardVO> getBoardList(BoardVO boardVO);
	public void insertBoard(BoardVO boardVO);
	public BoardVO getBoard(int seq);
	public BoardVO updateForm(int seq);
	public void updateBoard(BoardVO boardVO);
	public void deleteBoard(int seq);
}
