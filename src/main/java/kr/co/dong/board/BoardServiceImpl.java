package kr.co.dong.board;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	BoardDAO dao;
	
	@Override
	public Map login(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return dao.login(map);
	}

	@Override
	public List<BoardReply> getDetail(int b_p_bno) throws Exception {
		// TODO Auto-generated method stub
		return dao.getDetail(b_p_bno);
	}

	@Override
	public int reply(BoardReply boardReply) throws Exception {
		// TODO Auto-generated method stub
		return dao.reply(boardReply);
	}

	@Override
	public BoardReply detailReply(int reno) throws Exception {
		// TODO Auto-generated method stub
		return dao.detailReply(reno);
	}

	@Override
	public int replyUpdate(BoardReply boardReply) throws Exception {
		// TODO Auto-generated method stub
		return dao.replyUpdate(boardReply);
	}

	@Override
	public int replyDelete(BoardReply boardReply) throws Exception {
		// TODO Auto-generated method stub
		return dao.replyDelete(boardReply);
	}

	@Override
	public List<CodeDTO> CodeList(CodeDTO CodeDTO) throws Exception {
		// TODO Auto-generated method stub
		return dao.CodeList(CodeDTO);
	}

	@Override
	public List<BoardDTO> List(paging paging) throws Exception {
		// TODO Auto-generated method stub
		return dao.List(paging);
	}

	@Override
	public BoardDTO board(int b_p_bno) throws Exception {
		// TODO Auto-generated method stub
		return dao.board(b_p_bno);
	}

	@Override
	public int register(BoardDTO BoardDTO) throws Exception {
		// TODO Auto-generated method stub
		return dao.register(BoardDTO);
	}

	@Override
	public int update(BoardDTO BoardDTO) throws Exception {
		// TODO Auto-generated method stub
		return dao.update(BoardDTO);
	}

	@Override
	public int delete(int b_p_bno) throws Exception {
		// TODO Auto-generated method stub
		return dao.delete(b_p_bno);
	}

	@Override
	public int Join(jointempDTO jointempDTO) throws Exception {
		// TODO Auto-generated method stub
		return dao.Join(jointempDTO);
	}

	@Override
	public int paging() throws Exception {
		// TODO Auto-generated method stub
		return dao.paging();
	}

	

}
