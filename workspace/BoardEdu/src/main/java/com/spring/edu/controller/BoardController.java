package com.spring.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.edu.service.BoardService;
import com.spring.edu.vo.BoardVO;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView getBoardList(BoardVO boardVO) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", boardService.getBoardList(boardVO));
		mav.setViewName("boardList");
		
		return mav;
	}
	
	@RequestMapping(value="/writeForm", method=RequestMethod.GET)
	public String writeForm() {
		return "writeForm";
	}
	
	@RequestMapping(value="/insertBoard", method=RequestMethod.POST)
	public String insertBoard(BoardVO boardVO) {
		boardService.insertBoard(boardVO);
		return "redirect:/";
		
	}
	
	@RequestMapping(value="/getBoard", method=RequestMethod.GET)
	public ModelAndView getBoard(int seq) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", boardService.getBoard(seq));
		mav.setViewName("detailBoard");
		return mav;
	}
	
	@RequestMapping(value="/updateForm", method=RequestMethod.GET)
	public ModelAndView updateForm(int seq) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("board", boardService.updateForm(seq));
		mav.setViewName("updateForm");
		
		return mav;
	}
	
	@RequestMapping(value="/updateBoard", method=RequestMethod.POST)
	public String updateBoard(BoardVO boardVO) {
		boardService.updateBoard(boardVO);
		return "redirect:/getBoard?seq="+boardVO.getSeq();
	}
	
	@RequestMapping(value="/deleteBoard", method=RequestMethod.GET)
	public String deleteBoard(int seq) {
		boardService.deleteBoard(seq);
		return "redirect:/";
	}
	
}
