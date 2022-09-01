/* DAO
 * 1. @Repository -> 클래스위에 작성
 * 2. mybatis 객체생성 (SqlSession 클래스)
 * 3. mapper의 nameSpace를 지정
 */

package kr.co.dong.emp;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDAOImpl implements EmpDAO{
	
	@Inject  // @Autowired
	private SqlSession sqlSession;	
	private static final String namespace = "kr.co.dong.empMapper";
	
	
	@Override
	public int empCount() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".cnt");
	}


	@Override
	public List<EmpVO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".listAll");
	}


	@Override
	public EmpVO detail(int empno) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int insert(EmpVO empVO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace + ".insert", empVO);
	}


	@Override
	public int update(EmpVO empVO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(namespace);
	}
	
	
}








