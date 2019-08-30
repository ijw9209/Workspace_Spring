package com.hello.mvc03.model.biz;

import java.util.List;

import com.hello.mvc03.model.dto.CustomerDto;

public interface CustomerBiz {

	public List<CustomerDto> selectList();
	public CustomerDto selectOne(String id);
	public int insert(CustomerDto dto);
	public int update(CustomerDto dto);
	public int delete(String id);
}