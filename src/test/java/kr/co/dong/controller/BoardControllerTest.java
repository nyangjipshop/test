package kr.co.dong.controller;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.dong.board.BoardDTO;
import kr.co.dong.board.BoardService;

@RunWith(SpringJUnit4ClassRunner.class)
//속성 경로에 xml 파일을 이용해 스프링이 로딩 된다.
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})

public class BoardControllerTest {
	@Inject
	private BoardService boardService;

	@Test
	public void testSelectAll() throws Exception {
		List<BoardDTO> list = boardService.List();
	}
	
}
