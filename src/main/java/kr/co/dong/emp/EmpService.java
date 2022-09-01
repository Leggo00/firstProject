/*
 * 서비스는 DAO메소드를 호출합니다.
 */
package kr.co.dong.emp;

import java.util.List;

public interface EmpService {
	public int empCount() throws Exception;	
	
	// 전체사원조회
	public List<EmpVO> listAll() throws Exception;
	
	//사원번호로 사원 조회
	public EmpVO detail(int empno) throws Exception;

	//사원추가
	public int insert(EmpVO empVO) throws Exception;
 	
	//사원 수정
	public int update(EmpVO empVO) throws Exception;
}
