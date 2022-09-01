package kr.co.dong.board;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository //실질적으로 sql session을 불러오기위함.
public class BoardDaoimpl implements BoardDao {

	@Autowired
	private SqlSession sqlSession;
	
	private static final String nameSpace = "kr.co.dong.boardMapper";
	
	@Override
	public Map login(Map<String, Object> map) {
		
		return sqlSession.selectOne("kr.co.dong.boardMapper.login", map);
	}

	@Override
	public List<BoardDTO> list() throws Exception {
		return sqlSession.selectList(nameSpace + ".list", sqlSession);
	}

	@Override
	public BoardDTO getDetail(int bno) throws Exception {
		return sqlSession.selectOne(nameSpace + ".detail", bno);
	}

	@Override
	public int updateReadCnt(int bno) throws Exception {
		return sqlSession.update(nameSpace + ".upadateReadCnt", bno);
	}

	@Override
	public int register(BoardDTO boardDTO) throws Exception {
		return sqlSession.insert(nameSpace + ".register", boardDTO);
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		return sqlSession.update(nameSpace + ".update", boardDTO);
	}

	@Override
	public int delete(int bno) throws Exception {
		return sqlSession.delete(nameSpace + ".delete", bno);
	}

	// 댓글 전체 목록
	@Override
	public List<BoardReply> getDetail1(int bno) throws Exception {
		return sqlSession.selectList(nameSpace + ".detail1", bno);
	}

	@Override
	public int reply(BoardReply boardReply) throws Exception {
		return sqlSession.insert(nameSpace + ".reply", boardReply);
	}

	@Override
	public BoardReply detailreply(int reno) throws Exception {
		return sqlSession.selectOne(nameSpace + ".detailReply", reno);
	}

	@Override
	public int replyupdate(BoardReply boardReply) throws Exception {
		return sqlSession.update(nameSpace + ".replyupdate", boardReply);
	}

	@Override
	public int replyDelete(int reno) throws Exception {
		return sqlSession.delete(nameSpace + ".replyDelete", reno);
	}


}
