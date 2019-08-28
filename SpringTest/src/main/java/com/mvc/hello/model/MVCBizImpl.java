package com.mvc.hello.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.hello.dto.MVCBoardDto;

@Service
public class MVCBizImpl implements MVCBiz {

	@Autowired
	private MVCDaoImpl dao;
	
	@Override
	public List<MVCBoardDto> selectList() {
		// TODO Auto-generated method stub
		return dao.selectList();
	}

	@Override
	public MVCBoardDto selectone(int seq) {
		// TODO Auto-generated method stub
		return dao.selectone(seq);
	}

	@Override
	public int insert(MVCBoardDto dto) {
		// TODO Auto-generated method stub
		return dao.insert(dto);
	}

	@Override
	public int update(MVCBoardDto dto) {
		// TODO Auto-generated method stub
		return dao.update(dto);
	}

	@Override
	public int delete(int seq) {
		// TODO Auto-generated method stub
		return dao.delete(seq);
	}

}
