package com.spring.edu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.edu.dao.BoardDAO;
import com.spring.edu.dao.BoardDAOMyBatis;
import com.spring.edu.mapper.BoardMapper;
import com.spring.edu.service.BoardService;
import com.spring.edu.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	BoardDAO boardDAO;
	
	@Autowired
	BoardDAOMyBatis boardDAOMyBatis;
	
	@Autowired
	BoardMapper boardMapper;

	@Override
	public List<BoardVO> getBoardList(BoardVO boardVO) {	
		return boardMapper.getBoardList(boardVO);
	}
	
	@Override
	public void insertBoard(BoardVO boardVO) {
		boardMapper.insertBoard(boardVO);
	}

	@Override
	public BoardVO getBoard(int seq) {
		boardMapper.updateBoardCnt(seq);
		return boardMapper.getBoard(seq);
	}

	@Override
	public BoardVO updateForm(int seq) {
		return boardMapper.getBoard(seq);
	}

	@Override
	public void updateBoard(BoardVO boardVO) {
		boardMapper.updateBoard(boardVO);		
	}

	@Override
	public void deleteBoard(int seq) {
		boardMapper.deleteBoard(seq);		
	}
	
	
}
