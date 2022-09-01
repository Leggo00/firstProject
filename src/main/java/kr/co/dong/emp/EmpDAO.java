/* DAO는 마이바티스를 호출함.
 * emp테이블에 관한 질의문 작성
 * - 전체사원수 조회 
 * - 전체조회, 선택조회, 사원추가, 사원수정, 사원삭제
 * 
 */
package kr.co.dong.emp;

import java.util.List;

public interface EmpDAO {
	//전체 사원수 조회하는 함수
 	abstract public int empCount() throws Exception; 
	
	//전체 사원 조회
	public List<EmpVO> listAll() throws Exception;
	
	//사원번호로 사원 조회
	public EmpVO detail(int empno) throws Exception;

	//사원추가
	public int insert(EmpVO empVO) throws Exception;
 	
	//사원 수정
	public int update(EmpVO empVO) throws Exception;
	//사원 삭제 (delete -> update) 근무중 -> 이직 


}
