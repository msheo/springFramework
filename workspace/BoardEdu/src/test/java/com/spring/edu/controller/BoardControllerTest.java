package com.spring.edu.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.spring.edu.service.BoardService;
import com.spring.edu.vo.BoardVO;

@RunWith(MockitoJUnitRunner.class)
public class BoardControllerTest {
	
	@InjectMocks
	private BoardController controller;
	
	@Mock
	private BoardService boardService;
	private MockMvc mockMvc;
	
	private BoardVO boardVO;
	
	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);
		
		mockMvc = MockMvcBuilders
					.standaloneSetup(controller)
					.setViewResolvers(new InternalResourceViewResolver("/WEB-INF/jsp", ".jsp"))
					.alwaysDo(print())
					.build();
		
		boardVO = new BoardVO();
		boardVO.setSeq(0);
		boardVO.setTitle("TEST TITLE");
		boardVO.setContent("TEST CONENT");
		boardVO.setWriter("TEST WRITER");
		boardVO.setCnt(0);
		boardVO.setRegDate(new Date().toString());
	}
	
	@Test
	public void test_getBoardList() throws Exception {
		mockMvc.perform(get("/")
			.contentType(MediaType.TEXT_HTML))
			.andExpect(status().isOk())
			.andExpect(view().name("boardList"));
	}
	
	@Test
	public void test_getBoard() throws Exception {
		mockMvc.perform(get("/getBoard?seq=0")
			.contentType(MediaType.TEXT_HTML))
			.andExpect(status().isOk())
			.andExpect(view().name("detailBoard"));
	}
	
	@Test
	public void test_writeForm() throws Exception {
		mockMvc.perform(get("/writeForm")
			.contentType(MediaType.TEXT_HTML))
			.andExpect(status().isOk())
			.andExpect(view().name("writeForm"));
	}
	
	@Test
	public void test_insertBoard() throws Exception {

		mockMvc.perform(post("/insertBoard")
			.contentType(MediaType.APPLICATION_JSON_UTF8)
			.flashAttr("boardVo", boardVO))
			.andExpect(status().is3xxRedirection());
	}
	
	@Test
	public void test_updateForm() throws Exception {
		mockMvc.perform(get("/updateForm?seq=0")
			.contentType(MediaType.TEXT_HTML))
			.andExpect(status().isOk())
			.andExpect(view().name("updateForm"));
	}
	
	@Test
	public void test_updateBoard() throws Exception {

		boardVO.setTitle("Edit Title");
		
		mockMvc.perform(post("/updateBoard")
			.contentType(MediaType.APPLICATION_JSON_UTF8)
			.flashAttr("boardVo", boardVO))
			.andExpect(status().is3xxRedirection());
	}
	
	@Test
	public void test_deleteBoard() throws Exception {
		
		mockMvc.perform(get("/deleteBoard?seq=0")
			.contentType(MediaType.APPLICATION_JSON_UTF8))
			.andExpect(status().is3xxRedirection());
	}
	
	
}
