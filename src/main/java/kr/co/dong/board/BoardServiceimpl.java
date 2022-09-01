package kr.co.dong.board;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceimpl implements BoardService{
	@Autowired
	BoardDao boardDao;
	
	@Override
	public Map login(Map<String, Object> map) {
		return boardDao.login(map);
	}

	@Override
	public List<BoardDTO> list() throws Exception {
		return boardDao.list();
	}

	@Override
	public BoardDTO getDetail(int bno) throws Exception {
		boardDao.updateReadCnt(bno);
		return boardDao.getDetail(bno);
	}

	@Override
	public int register(BoardDTO boardDTO) throws Exception {
		return boardDao.register(boardDTO);
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		return boardDao.update(boardDTO);
	}

	@Override
	public int delete(int bno) throws Exception {
		return boardDao.delete(bno);
	}

	@Override
	public List<BoardReply> getDetail1(int bno) throws Exception {
		return boardDao.getDetail1(bno);
	}

	@Override
	public int reply(BoardReply boardReply) throws Exception {
		return boardDao.reply(boardReply);
	}

	@Override
	public BoardReply detailreply(int reno) throws Exception {
		return boardDao.detailreply(reno);
	}

	@Override
	public int replyupdate(BoardReply boardReply) throws Exception {
		return boardDao.replyupdate(boardReply);
	}

	@Override
	public int replyDelete(int reno) throws Exception {
		return boardDao.replyDelete(reno);
	}



}
