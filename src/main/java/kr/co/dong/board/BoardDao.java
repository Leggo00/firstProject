package kr.co.dong.board;

import java.util.List;
import java.util.Map;

import kr.co.dong.emp.EmpVO;

public interface BoardDao {
	// 로그인 처리를 위한 메소드
	public Map login(Map<String, Object> map);
	
	//	삽입, 삭제, 수정(갱신) 메소드의 리턴타입은 int
	
	// 전체목록 처리를 위한 메소드
	public List<BoardDTO> list() throws Exception;
	// 선택목록(글읽기)를 위한 메소드  getDetail()
	public BoardDTO getDetail(int bno) throws Exception;
	// 조회수 증가를 위한 메소드  updateReadCnt()
	public int updateReadCnt(int bno) throws Exception;
	// 글 쓰기를 위한 메소드 register()
	public int register(BoardDTO boardDTO) throws Exception;
	// 글 수정을 위한 메소드 update()
	public int update(BoardDTO boardDTO) throws Exception;
	// 글 삭제를 위한 메소드 delete()
	public int delete(int bno) throws Exception;
	
	
	// 댓글 전체 목록
	public List<BoardReply> getDetail1(int bno) throws Exception;
	
	// 댓글 쓰기
	public int reply(BoardReply boardReply) throws Exception;
	
	//해당 댓글 읽기(조회)
	public BoardReply detailreply(int reno) throws Exception;
	
	//댓글 수정
	public int replyupdate(BoardReply boardReply) throws Exception;
	
	//댓글 삭제
	public int replyDelete(int reno) throws Exception;
	
	

}
