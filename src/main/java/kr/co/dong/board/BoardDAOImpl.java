package kr.co.dong.board;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository //세션호출하기 위함
public class BoardDAOImpl implements BoardDAO {
	@Autowired
	private SqlSession sqlsession;
	
	private static final String namespace = "kr.co.dong.boardMapper";
	
	@Override
	public Map login(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(namespace + ".login", map);
	}


	@Override
	public int updateReadCnt(int b_p_bno) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.update(namespace+".updateReadCnt", b_p_bno);
	}

	@Override
	public List<BoardReply> getDetail(int b_p_bno) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectList(namespace + ".detail1", b_p_bno);
	}

	@Override
	public int reply(BoardReply boardReply) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.insert(namespace+".reply", boardReply);
	}

	@Override
	public BoardReply detailReply(int reno) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(namespace + ".detailReply", reno);
	}

	@Override
	public int replyUpdate(BoardReply boardReply) throws Exception {  
		// TODO Auto-generated method stub
		return sqlsession.update(namespace+".replyUpdate", boardReply);
	}

	@Override
	public int replyDelete(BoardReply boardReply) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.delete(namespace+".replyDelete", boardReply);
	}


	@Override
	public List<CodeDTO> CodeList(CodeDTO CodeDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectList(namespace+".CodeList", CodeDTO);
	}


	@Override
	public List<BoardDTO> List(paging paging) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectList(namespace+".List", paging);
	}

	@Override
	public BoardDTO board(int b_p_bno) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(namespace+".board", b_p_bno);
	}


	@Override
	public int register(BoardDTO BoardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.insert(namespace+".register", BoardDTO);
	}


	@Override
	public int update(BoardDTO BoardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.update(namespace+".update", BoardDTO);
	}


	@Override
	public int delete(int b_p_bno) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.delete(namespace+".Delete", b_p_bno);
	}


	@Override
	public int Join(jointempDTO jointempDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.insert(namespace+".Join", jointempDTO);
	}


	@Override
	public int paging() throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(namespace + ".paging");
	}

}
