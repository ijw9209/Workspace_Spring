package com.hello.mvc03.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hello.mvc03.model.dao.CustomerDao;
import com.hello.mvc03.model.dto.CustomerDto;

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

}
