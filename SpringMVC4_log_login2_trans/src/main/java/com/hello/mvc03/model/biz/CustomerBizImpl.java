package com.hello.mvc03.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hello.mvc03.dto.CustomerDto;
import com.hello.mvc03.model.dao.CustomerDao;

@Service
public class CustomerBizImpl implements CustomerBiz {

	@Autowired
	private CustomerDao dao;
	
	@Override
	public List<CustomerDto> selectList() {
		// TODO Auto-generated method stub
		return dao.selectList();
	}

	@Override
	public CustomerDto selectOne(String id) {
		// TODO Auto-generated method stub
		return dao.selectOne(id);
	}

	@Override
	public int insert(CustomerDto dto) {
		// TODO Auto-generated method stub
		return dao.insert(dto);
	}

	@Override
	public int update(CustomerDto dto) {
		// TODO Auto-generated method stub
		return dao.update(dto);
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

	@Override
	public CustomerDto login(String id, String pw) {
		// TODO Auto-generated method stub
		return dao.login(id, pw);
	}

	@Override
	@Transactional
	public String test() {

		dao.insert(new CustomerDto("1","1","1"));
		
		String test =dao.test();
		test.length();
		return test;
	}
	/*
	 *@Transactional (<tx:annotation-driven/>) 
	 *
	 *-isolation : 별도로 정의하지 않으면 DB의 isolation level을 따른다.
	 *
	 *	<isolation level>
	 *	-default :데이터베이스에 의존
	 *	-uncommitted : commit 되지 않은 데이터 볼수 있다.
	 *	-committed : commit된 데이터만 볼수 있다.
	 *	-repeatable : 새로운 데이터 입력시 볼수 있다,
	 *	-serializable : 동일한 데이터에 동시에 두개 이상의 트랜젝션 수행 불가
	 *
	 *-propagation : 전파규칙 정의 (기본값 : required)
	 *	-reqired : 기존 트랜잭션이 존대 하면 지원, 없으면 새오운 트랜잭션 시작
	 *	-supports : 기존 트랜잭션이 존재하면 지원, 없으면 트랜잭션 없이
	 *	-mandatory : 반드시 트랜잭션 내에서 메서드 실행, 없으면 예외 발생
	 *	-required_new : 언제나 새로운 트랜잭션 실행, 기존 트랜잭션 일시정지
	 *	-not_supported : 기존 트랜잭션 내에서 실해으 없으면 트랜잭션 없이
	 *	-never : mandatory와 반대 (반드시 트랜잭션 외부에서 메서드 실행)
	 *	-nested : 트랜잭션이 존재하면 중첩되어 실행, 없으면 새로운 트랜잭션 시작
	 *-readOnly : 읽기 전용
	 *-rollbackFor : 정의된 exception에 대해서 rollback 수행 (rollbackFor exception.class)
	 *-norollbackFor : 정의된 exception에 대해서 rollback 수행안함 
	 *
	 *-timeout : 지정한 시간 내에 메서드 수행 완료되지 않으면 rollback (기본값 -1 = notimeout)
	 *
	 *mybatis 에서 timeout이 존재한다면 중첩되서 실행, 없으면 새로운 트렌젝선 실행
	 *
	 */
}
