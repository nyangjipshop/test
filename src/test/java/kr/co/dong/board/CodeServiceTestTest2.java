package kr.co.dong.board;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})

public class CodeServiceTestTest2 {
	
	@Inject
	private BoardService boardService;

	@Test
	public void testCodeList() throws Exception {
		
		CodeDTO codeDTO = new CodeDTO();
		codeDTO.setCodeNm("agreeYn");
		List<CodeDTO> list = boardService.CodeList(codeDTO);
		
		assertNotNull(list);
	}

}
