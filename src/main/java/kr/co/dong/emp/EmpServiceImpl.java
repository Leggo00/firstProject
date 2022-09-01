/* Service는 DAO호출
 * 1. @Service
 */
package kr.co.dong.emp;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceImpl implements EmpService{
	
	@Autowired
	private EmpDAO dao;

	@Override
	public int empCount() throws Exception {
		// TODO Auto-generated method stub
		return dao.empCount();
	}

	@Override
	public List<EmpVO>  listAll() throws Exception {
		// TODO Auto-generated method stub
		return dao.listAll();
	}

	@Override
	public EmpVO detail(int empno) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(EmpVO empVO) throws Exception {
		// TODO Auto-generated method stub
		return dao.insert(empVO);
	}

	@Override
	public int update(EmpVO empVO) throws Exception {
		// TODO Auto-generated method stub
		return dao.update(empVO);
	}
		


}
