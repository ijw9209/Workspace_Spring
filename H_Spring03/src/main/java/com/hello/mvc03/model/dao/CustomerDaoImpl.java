package com.hello.mvc03.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hello.mvc03.model.dto.CustomerDto;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<CustomerDto> selectList() {

		List<CustomerDto> list = new ArrayList<CustomerDto>();
		
		try {
			list = sqlSession.selectList(namespace + "selectlist");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public CustomerDto selectOne(String id) {

		CustomerDto dto = null;
		
		try {
			dto = sqlSession.selectOne(namespace+"selectone", id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dto;
	}

	@Override
	public int insert(CustomerDto dto) {

		int res = 0;
		
		try {
			res = sqlSession.insert(namespace+"insert", dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int update(CustomerDto dto) {
		int res = 0;
		
		try {
			res = sqlSession.update(namespace+"update",dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int delete(String id) {
		
		int res = 0;
		
		try {
			res = sqlSession.delete(namespace + "delete" , id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}

}
