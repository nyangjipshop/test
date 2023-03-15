package kr.co.dong.controller;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import kr.co.dong.board.BoardService;
import kr.co.dong.board.CodeDTO;

public class codeControllerTest {

	@Test
	public void testList() {

		CodeDTO codeDTO = new CodeDTO();
		codeDTO.setCodeNm("agreeYn");

		//List<CodeDTO> codeList = BoardService.codeList(codeDTO);
		
		//assertNotNull(codeList);
	}

}
